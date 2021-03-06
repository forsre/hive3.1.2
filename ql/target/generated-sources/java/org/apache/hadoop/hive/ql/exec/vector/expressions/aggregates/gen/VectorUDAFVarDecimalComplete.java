/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.exec.vector.expressions.aggregates.gen;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.serde2.io.HiveDecimalWritable;
import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.aggregates.VectorAggregateExpression;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationBufferRow;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationDesc;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DecimalColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.StructColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFVariance;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFVariance.VarianceKind;
import org.apache.hadoop.hive.ql.util.JavaDataModel;

import com.google.common.base.Preconditions;

/**
* VectorUDAFVarDecimalComplete. Vectorized implementation for VARIANCE aggregates.
*/
@Description(name = "variance, var_pop, var_samp, std, stddev, stddev_pop, stddev_samp",
    value = "_FUNC_(x) - Returns the variance of a set of numbers (vectorized, timestamp)")
public class VectorUDAFVarDecimalComplete extends VectorAggregateExpression {

    private static final long serialVersionUID = 1L;

    /**
    /* class for storing the current aggregate value.
    */
    private static final class Aggregation implements AggregationBuffer {

      private static final long serialVersionUID = 1L;

      transient private double sum;
      transient private long count;
      transient private double variance;

      /**
      * Value is explicitly (re)initialized in reset()
      */
      transient private boolean isNull = true;

      public Aggregation() {
      }

      public void init() {
        isNull = false;
        sum = 0.0;
        count = 0;
        variance = 0.0;
      }

     public void varianceValue(double value) {
        if (isNull) {
          sum = value;
          count = 1;
          variance = 0;
          isNull = false;
        } else {
          sum += value;
          count++;
          if (count > 1) {
            variance =
                GenericUDAFVariance.calculateIntermediate(
                    count, sum, value, variance);
          }
        }
      }

      public void varianceValue(HiveDecimalWritable value) {
        varianceValue(value.doubleValue());
      }

      @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
      }

      @Override
      public void reset () {
        isNull = true;
        sum = 0.0;
        count = 0;
        variance = 0.0;
      }

    }

    transient private VarianceKind varianceKind = VarianceKind.NONE;

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFVarDecimalComplete() {
    super();
  }

  public VectorUDAFVarDecimalComplete(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
    Preconditions.checkState(this.mode == GenericUDAFEvaluator.Mode.COMPLETE);
    init();
  }

    private void init() {
      String aggregateName = vecAggrDesc.getAggrDesc().getGenericUDAFName();
      varianceKind = VarianceKind.nameMap.get(aggregateName);
    }

    private Aggregation getCurrentAggregationBuffer(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        int row) {
      VectorAggregationBufferRow mySet = aggregationBufferSets[row];
      Aggregation myagg = (Aggregation) mySet.getAggregationBuffer(aggregateIndex);
      return myagg;
    }


    @Override
    public void aggregateInputSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregateIndex,
      VectorizedRowBatch batch) throws HiveException {

      inputExpression.evaluate(batch);

      DecimalColumnVector inputVector =
          (DecimalColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      HiveDecimalWritable[] vector = inputVector.vector;

      if (inputVector.isRepeating) {
        if (inputVector.noNulls || !inputVector.isNull[0]) {
          iterateRepeatingNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector[0], inputVector.scale, batchSize);
        }
      }
      else if (!batch.selectedInUse && inputVector.noNulls) {
        iterateNoSelectionNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, inputVector.scale, batchSize);
      }
      else if (!batch.selectedInUse) {
        iterateNoSelectionHasNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, inputVector.scale,
            batchSize, inputVector.isNull);
      }
      else if (inputVector.noNulls){
        iterateSelectionNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, inputVector.scale,
            batchSize, batch.selected);
      }
      else {
        iterateSelectionHasNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, inputVector.scale, batchSize,
            inputVector.isNull, batch.selected);
      }

    }

    private void  iterateRepeatingNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        HiveDecimalWritable value,
        short scale,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
        myagg.varianceValue(value);
      }
    }

    private void iterateSelectionHasNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int j=0; j< batchSize; ++j) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          j);
        int i = selected[j];
        if (!isNull[i]) {
          myagg.varianceValue(vector[i]);
        }
      }
    }

    private void iterateSelectionNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        int[] selected) {

      for (int i=0; i< batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
        myagg.varianceValue(vector[selected[i]]);
      }
    }

    private void iterateNoSelectionHasNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregateIndex,
          i);
          myagg.varianceValue(vector[i]);
        }
      }
    }

    private void iterateNoSelectionNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
         myagg.varianceValue(vector[i]);
      }
    }

    @Override
    public void aggregateInput(AggregationBuffer agg, VectorizedRowBatch batch)
    throws HiveException {

      inputExpression.evaluate(batch);

      DecimalColumnVector inputVector =
          (DecimalColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      Aggregation myagg = (Aggregation)agg;

      HiveDecimalWritable[] vector = inputVector.vector;

      if (inputVector.isRepeating) {
        if (inputVector.noNulls || !inputVector.isNull[0]) {
          iterateRepeatingNoNulls(myagg, vector[0], inputVector.scale, batchSize);
        }
      }
      else if (!batch.selectedInUse && inputVector.noNulls) {
        iterateNoSelectionNoNulls(myagg, vector, inputVector.scale, batchSize);
      }
      else if (!batch.selectedInUse) {
        iterateNoSelectionHasNulls(myagg, vector, inputVector.scale, batchSize, inputVector.isNull);
      }
      else if (inputVector.noNulls){
        iterateSelectionNoNulls(myagg, vector, inputVector.scale, batchSize, batch.selected);
      }
      else {
        iterateSelectionHasNulls(myagg, vector, inputVector.scale,
          batchSize, inputVector.isNull, batch.selected);
      }
    }

    private void  iterateRepeatingNoNulls(
        Aggregation myagg,
        HiveDecimalWritable value,
        short scale,
        int batchSize) {

      double doubleValue = value.doubleValue();
      for (int i=0; i<batchSize; ++i) {
        myagg.varianceValue(doubleValue);
      }
    }

    private void iterateSelectionHasNulls(
        Aggregation myagg,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int j=0; j< batchSize; ++j) {
        int i = selected[j];
        if (!isNull[i]) {
          myagg.varianceValue(vector[i]);
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        int[] selected) {

      for (int i=0; i< batchSize; ++i) {
        myagg.varianceValue(vector[selected[i]]);
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          myagg.varianceValue(vector[i]);
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        myagg.varianceValue(vector[i]);
      }
    }

    @Override
    public AggregationBuffer getNewAggregationBuffer() throws HiveException {
      return new Aggregation();
    }

    @Override
    public void reset(AggregationBuffer agg) throws HiveException {
      Aggregation myAgg = (Aggregation) agg;
      myAgg.reset();
    }

  @Override
  public long getAggregationBufferFixedSize() {
      JavaDataModel model = JavaDataModel.get();
      return JavaDataModel.alignUp(
        model.object() +
        model.primitive2()*3+
        model.primitive1(),
        model.memoryAlign());
  }

  @Override
  public boolean matches(String name, ColumnVector.Type inputColVectorType,
      ColumnVector.Type outputColVectorType, Mode mode) {

    /*
     * Variance input is DECIMAL.
     * Output is DOUBLE.
     *
     * Mode COMPLETE.
     */
    return
        GenericUDAFVariance.isVarianceFamilyName(name) &&
        inputColVectorType == ColumnVector.Type.DECIMAL &&
        outputColVectorType == ColumnVector.Type.DOUBLE &&
        mode == Mode.COMPLETE;
  }

  @Override
  public void assignRowColumn(VectorizedRowBatch batch, int batchIndex, int columnNum,
      AggregationBuffer agg) throws HiveException {

    DoubleColumnVector outputColVector = (DoubleColumnVector) batch.cols[columnNum];

    Aggregation myagg = (Aggregation) agg;
    if (GenericUDAFVariance.isVarianceNull(myagg.count, varianceKind)) {

      // SQL standard - return null for zero (or 1 for sample) elements
      outputColVector.noNulls = false;
      outputColVector.isNull[batchIndex] = true;
      return;
    }
    outputColVector.isNull[batchIndex] = false;

    final double result;
    if (myagg.count > 1) {

      // Use the common variance family result calculation method.
      result = GenericUDAFVariance.calculateVarianceFamilyResult(
          myagg.variance, myagg.count, varianceKind);
    } else {

      // For one element the variance is always 0.
      result = 0.0;
    }
    outputColVector.vector[batchIndex] = result;
  }
}
