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
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFVariance;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFVariance.VarianceKind;
import org.apache.hadoop.hive.ql.util.JavaDataModel;

import com.google.common.base.Preconditions;

/**
* VectorUDAFVarPopTimestamp. Vectorized implementation for VARIANCE aggregates.
*/
@Description(name = "variance, var_pop",
    value = "_FUNC_(x) - Returns the variance of a set of numbers (vectorized, timestamp)")
public class VectorUDAFVarTimestampComplete extends VectorAggregateExpression {

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
      * Value is explicitly (re)initialized in reset() (despite the init() bellow...)
      */
      transient private boolean isNull = true;

      public void init() {
        isNull = false;
        sum = 0;
        count = 0;
        variance = 0;
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

      @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
      }

      @Override
      public void reset () {
        isNull = true;
        sum = 0;
        count = 0;
        variance = 0;
      }
    }

    transient private VarianceKind varianceKind = VarianceKind.NONE;

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFVarTimestampComplete() {
    super();
  }

  public VectorUDAFVarTimestampComplete(VectorAggregationDesc vecAggrDesc) {
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

      TimestampColumnVector inputColVector =
          (TimestampColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      if (inputColVector.isRepeating) {
        if (inputColVector.noNulls || !inputColVector.isNull[0]) {
          iterateRepeatingNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, inputColVector.getDouble(0), batchSize);
        }
      }
      else if (!batch.selectedInUse && inputColVector.noNulls) {
        iterateNoSelectionNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, inputColVector, batchSize);
      }
      else if (!batch.selectedInUse) {
        iterateNoSelectionHasNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, inputColVector, batchSize, inputColVector.isNull);
      }
      else if (inputColVector.noNulls){
        iterateSelectionNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, inputColVector, batchSize, batch.selected);
      }
      else {
        iterateSelectionHasNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, inputColVector, batchSize,
            inputColVector.isNull, batch.selected);
      }

    }

    private void  iterateRepeatingNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        double value,
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
        TimestampColumnVector inputColVector,
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
          myagg.varianceValue(inputColVector.getDouble(i));
        }
      }
    }

    private void iterateSelectionNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        TimestampColumnVector inputColVector,
        int batchSize,
        int[] selected) {

      for (int i=0; i< batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
        myagg.varianceValue(inputColVector.getDouble(selected[i]));
      }
    }

    private void iterateNoSelectionHasNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        TimestampColumnVector inputColVector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregateIndex,
          i);
          myagg.varianceValue(inputColVector.getDouble(i));
        }
      }
    }

    private void iterateNoSelectionNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        TimestampColumnVector inputColVector,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
        myagg.varianceValue(inputColVector.getDouble(i));
      }
    }

    @Override
    public void aggregateInput(AggregationBuffer agg, VectorizedRowBatch batch)
    throws HiveException {

      inputExpression.evaluate(batch);

      TimestampColumnVector inputColVector =
          (TimestampColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      Aggregation myagg = (Aggregation)agg;

      if (inputColVector.isRepeating) {
        if (inputColVector.noNulls || !inputColVector.isNull[0]) {
          iterateRepeatingNoNulls(myagg, inputColVector.getDouble(0), batchSize);
        }
      }
      else if (!batch.selectedInUse && inputColVector.noNulls) {
        iterateNoSelectionNoNulls(myagg, inputColVector, batchSize);
      }
      else if (!batch.selectedInUse) {
        iterateNoSelectionHasNulls(myagg, inputColVector, batchSize, inputColVector.isNull);
      }
      else if (inputColVector.noNulls){
        iterateSelectionNoNulls(myagg, inputColVector, batchSize, batch.selected);
      }
      else {
        iterateSelectionHasNulls(myagg, inputColVector, batchSize, inputColVector.isNull, batch.selected);
      }
    }

    private void  iterateRepeatingNoNulls(
        Aggregation myagg,
        double value,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        myagg.varianceValue(value);
      }
    }

    private void iterateSelectionHasNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int j=0; j< batchSize; ++j) {
        int i = selected[j];
        if (!isNull[i]) {
          myagg.varianceValue(inputColVector.getDouble(i));
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        int[] selected) {

      for (int i=0; i< batchSize; ++i) {
        myagg.varianceValue(inputColVector.getDouble(selected[i]));
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          myagg.varianceValue(inputColVector.getDouble(i));
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        myagg.varianceValue(inputColVector.getDouble(i));
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
     * Variance input is TIMESTAMP.
     * Output is DOUBLE.
     *
     * Mode COMPLETE.
     */
    return
        GenericUDAFVariance.isVarianceFamilyName(name) &&
        inputColVectorType == ColumnVector.Type.TIMESTAMP &&
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
