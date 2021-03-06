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
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.StructColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFVariance;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFVariance.VarianceKind;
import org.apache.hadoop.hive.ql.util.JavaDataModel;
import org.apache.hadoop.hive.serde2.typeinfo.StructTypeInfo;

import com.google.common.base.Preconditions;

/**
* VectorUDAFVarDouble. Vectorized implementation for VARIANCE aggregates.
*/
@Description(name = "variance, var_pop, var_samp, std, stddev, stddev_pop, stddev_samp",
    value = "_FUNC_(x) - Returns one of the variance family of a set of numbers (vectorized, double)")
public class VectorUDAFVarDouble extends VectorAggregateExpression {

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


  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFVarDouble() {
    super();
  }

  public VectorUDAFVarDouble(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
    Preconditions.checkState(this.mode == GenericUDAFEvaluator.Mode.PARTIAL1);
    init();
  }

    private void init() {
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

      DoubleColumnVector inputVector =
          (DoubleColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      double[] vector = inputVector.vector;

      if (inputVector.isRepeating) {
        if (inputVector.noNulls || !inputVector.isNull[0]) {
          iterateRepeatingNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector[0], batchSize);
        }
      }
      else if (!batch.selectedInUse && inputVector.noNulls) {
        iterateNoSelectionNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, batchSize);
      }
      else if (!batch.selectedInUse) {
        iterateNoSelectionHasNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, batchSize, inputVector.isNull);
      }
      else if (inputVector.noNulls){
        iterateSelectionNoNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, batchSize, batch.selected);
      }
      else {
        iterateSelectionHasNullsWithAggregationSelection(
            aggregationBufferSets, aggregateIndex, vector, batchSize,
            inputVector.isNull, batch.selected);
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
        if (myagg.isNull) {
          myagg.init();
        }
        myagg.varianceValue(value);
      }
    }

    private void iterateSelectionHasNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        double[] vector,
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
          double value = vector[i];
          if (myagg.isNull) {
            myagg.init ();
          }
          myagg.varianceValue(value);
        }
      }
    }

    private void iterateSelectionNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        double[] vector,
        int batchSize,
        int[] selected) {

      for (int i=0; i< batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
        double value = vector[selected[i]];
        if (myagg.isNull) {
          myagg.init ();
        }
        myagg.varianceValue(value);
      }
    }

    private void iterateNoSelectionHasNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        double[] vector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregateIndex,
          i);
          double value = vector[i];
          if (myagg.isNull) {
            myagg.init ();
          }
          myagg.varianceValue(value);
        }
      }
    }

    private void iterateNoSelectionNoNullsWithAggregationSelection(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregateIndex,
        double[] vector,
        int batchSize) {

      for (int i=0; i<batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregateIndex,
          i);
        if (myagg.isNull) {
          myagg.init ();
        }
        myagg.varianceValue(vector[i]);
      }
    }

    @Override
    public void aggregateInput(AggregationBuffer agg, VectorizedRowBatch batch)
        throws HiveException {

      inputExpression.evaluate(batch);

      DoubleColumnVector inputVector =
          (DoubleColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      Aggregation myagg = (Aggregation)agg;

      double[] vector = inputVector.vector;

      if (inputVector.isRepeating) {
        if (inputVector.noNulls || !inputVector.isNull[0]) {
          iterateRepeatingNoNulls(myagg, vector[0], batchSize);
        }
      }
      else if (!batch.selectedInUse && inputVector.noNulls) {
        iterateNoSelectionNoNulls(myagg, vector, batchSize);
      }
      else if (!batch.selectedInUse) {
        iterateNoSelectionHasNulls(myagg, vector, batchSize, inputVector.isNull);
      }
      else if (inputVector.noNulls){
        iterateSelectionNoNulls(myagg, vector, batchSize, batch.selected);
      }
      else {
        iterateSelectionHasNulls(myagg, vector, batchSize, inputVector.isNull, batch.selected);
      }
    }

    private void  iterateRepeatingNoNulls(
        Aggregation myagg,
        double value,
        int batchSize) {

      if (myagg.isNull) {
        myagg.init ();
      }

      myagg.varianceValue(value);

      // We pulled out i=0 so we can remove the count > 1 check in the loop
      for (int i=1; i<batchSize; ++i) {
        myagg.sum += value;
        myagg.count += 1;
        double t = myagg.count*value - myagg.sum;
        myagg.variance += (t*t) / ((double)myagg.count*(myagg.count-1));
      }
    }

    private void iterateSelectionHasNulls(
        Aggregation myagg,
        double[] vector,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int j=0; j< batchSize; ++j) {
        int i = selected[j];
        if (!isNull[i]) {
          double value = vector[i];
          if (myagg.isNull) {
            myagg.init ();
          }
          myagg.varianceValue(value);
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        double[] vector,
        int batchSize,
        int[] selected) {

      if (myagg.isNull) {
        myagg.init ();
      }

      double value = vector[selected[0]];
      myagg.varianceValue(value);

      // i=0 was pulled out to remove the count > 1 check in the loop
      //
      for (int i=1; i< batchSize; ++i) {
        value = vector[selected[i]];
        myagg.sum += value;
        myagg.count += 1;
        double t = myagg.count*value - myagg.sum;
        myagg.variance += (t*t) / ((double)myagg.count*(myagg.count-1));
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        double[] vector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          double value = vector[i];
          if (myagg.isNull) {
            myagg.init ();
          }
          myagg.varianceValue(value);
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        double[] vector,
        int batchSize) {

      if (myagg.isNull) {
        myagg.init ();
      }

      double value = vector[0];
      myagg.varianceValue(value);

      // i=0 was pulled out to remove count > 1 check
      for (int i=1; i<batchSize; ++i) {
        value = vector[i];
        myagg.sum += value;
        myagg.count += 1;
        double t = myagg.count*value - myagg.sum;
        myagg.variance += (t*t) / ((double)myagg.count*(myagg.count-1));
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
     * Variance input is DOUBLE.
     * Output is STRUCT.
     *
     * Mode PARTIAL1.
     */
    return
        GenericUDAFVariance.isVarianceFamilyName(name) &&
        inputColVectorType == ColumnVector.Type.DOUBLE &&
        outputColVectorType == ColumnVector.Type.STRUCT &&
        mode == Mode.PARTIAL1;
  }

  @Override
  public void assignRowColumn(VectorizedRowBatch batch, int batchIndex, int columnNum,
      AggregationBuffer agg) throws HiveException {

    StructColumnVector outputColVector = (StructColumnVector) batch.cols[columnNum];

    Aggregation myagg = (Aggregation) agg;
    if (myagg.isNull) {
      outputColVector.noNulls = false;
      outputColVector.isNull[batchIndex] = true;
      return;
    }
    outputColVector.isNull[batchIndex] = false;

    ColumnVector[] fields = outputColVector.fields;
    ((LongColumnVector) fields[VARIANCE_COUNT_FIELD_INDEX]).vector[batchIndex] = myagg.count;
    ((DoubleColumnVector) fields[VARIANCE_SUM_FIELD_INDEX]).vector[batchIndex] = myagg.sum;
    ((DoubleColumnVector) fields[VARIANCE_VARIANCE_FIELD_INDEX]).vector[batchIndex] = myagg.variance;
  }
}
