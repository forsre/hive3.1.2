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
import org.apache.hadoop.hive.ql.exec.vector.StructColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.util.JavaDataModel;

import com.google.common.base.Preconditions;

/**
 * Generated from template VectorUDAFAvg.txt.
 */
@Description(name = "avg",
    value = "_FUNC_(expr) - Returns the average value of expr (vectorized, type: <ValueType>)")
public class VectorUDAFAvgFinal extends VectorAggregateExpression {

    private static final long serialVersionUID = 1L;

    /** class for storing the current aggregate value. */
    static class Aggregation implements AggregationBuffer {

      private static final long serialVersionUID = 1L;

      transient private long mergeCount;
      transient private double mergeSum;

      /**
      * Value is explicitly (re)initialized in reset()
      */
      transient private boolean isNull = true;

      public void merge(long count, double sum) {
        if (isNull) {
          mergeCount = count;
          mergeSum = sum;
          isNull = false;
        } else {
          mergeCount += count;
          mergeSum += sum;
        }
      }

      @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
      }

      @Override
      public void reset () {
        isNull = true;
        mergeCount = 0L;
        mergeSum = 0;
      }
    }

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFAvgFinal() {
    super();
  }

  public VectorUDAFAvgFinal(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
    Preconditions.checkState(this.mode == GenericUDAFEvaluator.Mode.FINAL);
    init();
  }

    private void init() {
    }

    private Aggregation getCurrentAggregationBuffer(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int bufferIndex,
        int row) {
      VectorAggregationBufferRow mySet = aggregationBufferSets[row];
      Aggregation myagg = (Aggregation) mySet.getAggregationBuffer(bufferIndex);
      return myagg;
    }

    @Override
    public void aggregateInputSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      VectorizedRowBatch batch) throws HiveException {

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      inputExpression.evaluate(batch);

      StructColumnVector inputStructColVector =
          (StructColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];
      ColumnVector[] fields = inputStructColVector.fields;

      long[] countVector = ((LongColumnVector) fields[AVERAGE_COUNT_FIELD_INDEX]).vector;
      double[] sumVector = ((DoubleColumnVector) fields[AVERAGE_SUM_FIELD_INDEX]).vector;

      if (inputStructColVector.noNulls) {
        if (inputStructColVector.isRepeating) {
          iterateNoNullsRepeatingWithAggregationSelection(
            aggregationBufferSets, bufferIndex,
            countVector[0], sumVector[0], batchSize);
        } else {
          if (batch.selectedInUse) {
            iterateNoNullsSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              countVector, sumVector, batch.selected, batchSize);
          } else {
            iterateNoNullsWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              countVector, sumVector, batchSize);
          }
        }
      } else {
        if (inputStructColVector.isRepeating) {
          if (batch.selectedInUse) {
            iterateHasNullsRepeatingSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              countVector[0], sumVector[0], batchSize, batch.selected, inputStructColVector.isNull);
          } else {
            iterateHasNullsRepeatingWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              countVector[0], sumVector[0], batchSize, inputStructColVector.isNull);
          }
        } else {
          if (batch.selectedInUse) {
            iterateHasNullsSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              countVector, sumVector, batchSize, batch.selected, inputStructColVector.isNull);
          } else {
            iterateHasNullsWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              countVector, sumVector, batchSize, inputStructColVector.isNull);
          }
        }
      }
    }

    private void iterateNoNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long count,
      double sum,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.merge(count, sum);
      }
    }

    private void iterateNoNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] countVector,
      double[] sumVector,
      int[] selection,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        final int batchIndex = selection[i];
        myagg.merge(countVector[batchIndex], sumVector[batchIndex]);
      }
    }

    private void iterateNoNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] countVector,
      double[] sumVector,
      int batchSize) {
      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.merge(countVector[i], sumVector[i]);
      }
    }

    private void iterateHasNullsRepeatingSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long count,
      double sum,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      if (isNull[0]) {
        return;
      }

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.merge(count, sum);
      }

    }

    private void iterateHasNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long count,
      double sum,
      int batchSize,
      boolean[] isNull) {

      if (isNull[0]) {
        return;
      }

      for (int i = 0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.merge(count, sum);
      }
    }

    private void iterateHasNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] countVector,
      double[] sumVector,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      for (int i = 0; i < batchSize; i++) {
        final int batchIndex = selection[i];
        if (!isNull[batchIndex]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            i);
          myagg.merge(countVector[batchIndex], sumVector[batchIndex]);
        }
      }
   }

    private void iterateHasNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] countVector,
      double[] sumVector,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            i);
          myagg.merge(countVector[i], sumVector[i]);
        }
      }
   }

    @Override
    public void aggregateInput(AggregationBuffer agg, VectorizedRowBatch batch)
        throws HiveException {

      inputExpression.evaluate(batch);

      StructColumnVector inputStructColVector =
          (StructColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      ColumnVector[] fields = inputStructColVector.fields;

      long[] countVector = ((LongColumnVector) fields[AVERAGE_COUNT_FIELD_INDEX]).vector;
      double[] sumVector = ((DoubleColumnVector) fields[AVERAGE_SUM_FIELD_INDEX]).vector;

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      Aggregation myagg = (Aggregation)agg;

      if (inputStructColVector.isRepeating) {
        if (inputStructColVector.noNulls || !inputStructColVector.isNull[0]) {
          if (myagg.isNull) {
            myagg.isNull = false;
            myagg.mergeCount = 0;
            myagg.mergeSum = 0;
          }
          myagg.mergeCount += countVector[0] * batchSize;
          myagg.mergeSum += sumVector[0] * batchSize;
        }
        return;
      }

      if (!batch.selectedInUse && inputStructColVector.noNulls) {
        iterateNoSelectionNoNulls(myagg, countVector, sumVector, batchSize);
      } else if (!batch.selectedInUse) {
        iterateNoSelectionHasNulls(myagg, countVector, sumVector, batchSize, inputStructColVector.isNull);
      } else if (inputStructColVector.noNulls){
        iterateSelectionNoNulls(myagg, countVector, sumVector, batchSize, batch.selected);
      } else {
        iterateSelectionHasNulls(myagg, countVector, sumVector, batchSize, inputStructColVector.isNull, batch.selected);
      }
    }

    private void iterateSelectionHasNulls(
        Aggregation myagg,
        long[] countVector,
        double[] sumVector,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int i=0; i < batchSize; i++) {
        int batchIndex = selected[i];
        if (!isNull[batchIndex]) {
          if (myagg.isNull) {
            myagg.isNull = false;
            myagg.mergeCount = 0;
            myagg.mergeSum = 0;
          }
          myagg.mergeCount += countVector[batchIndex];
          myagg.mergeSum += sumVector[batchIndex];
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        long[] countVector,
        double[] sumVector,
        int batchSize,
        int[] selected) {

      if (myagg.isNull) {
        myagg.isNull = false;
        myagg.mergeCount = 0;
        myagg.mergeSum = 0;
      }

      for (int i = 0; i< batchSize; ++i) {
        final int batchIndex = selected[i];
        myagg.mergeCount += countVector[batchIndex];
        myagg.mergeSum += sumVector[batchIndex];
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        long[] countVector,
        double[] sumVector,
        int batchSize,
        boolean[] isNull) {

      for(int i = 0; i < batchSize; i++) {
        if (!isNull[i]) {
          if (myagg.isNull) {
            myagg.isNull = false;
            myagg.mergeCount = 0;
            myagg.mergeSum = 0;
          }
          myagg.mergeCount += countVector[i];
          myagg.mergeSum += sumVector[i];
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        long[] countVector,
        double[] sumVector,
        int batchSize) {
      if (myagg.isNull) {
        myagg.isNull = false;
        myagg.mergeCount = 0;
        myagg.mergeSum = 0;
      }

      for (int i=0;i<batchSize;++i) {
        myagg.mergeCount += countVector[i];
        myagg.mergeSum += sumVector[i];
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
      model.primitive2() * 2,
      model.memoryAlign());
  }

  @Override
  public boolean matches(String name, ColumnVector.Type inputColVectorType,
      ColumnVector.Type outputColVectorType, Mode mode) {

    /*
     * Variance input is STRUCT.
     * Output is DOUBLE.
     *
     * Mode FINAL.
     */
    return
        name.equals("avg") &&
        inputColVectorType == ColumnVector.Type.STRUCT &&
        outputColVectorType == ColumnVector.Type.DOUBLE &&
        mode == Mode.FINAL;
  }

  @Override
  public void assignRowColumn(VectorizedRowBatch batch, int batchIndex, int columnNum,
      AggregationBuffer agg) throws HiveException {

    DoubleColumnVector outputColVector = (DoubleColumnVector) batch.cols[columnNum];

    Aggregation myagg = (Aggregation) agg;
    if (myagg.isNull || myagg.mergeCount == 0) {
      outputColVector.noNulls = false;
      outputColVector.isNull[batchIndex] = true;
      return;
    }
    outputColVector.isNull[batchIndex] = false;

    outputColVector.vector[batchIndex] = myagg.mergeSum / myagg.mergeCount;
  }
}
