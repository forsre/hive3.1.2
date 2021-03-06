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
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.StructColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationBufferRow;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationDesc;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.util.JavaDataModel;
import org.apache.hadoop.hive.serde2.io.TimestampWritableV2;
import org.apache.hadoop.hive.ql.util.TimestampUtils;

import com.google.common.base.Preconditions;

/**
 * Generated from template VectorUDAFAvg.txt.
 */
@Description(name = "avg",
    value = "_FUNC_(expr) - Returns the average value of expr (vectorized, type: timestamp)")
public class VectorUDAFAvgTimestamp extends VectorAggregateExpression {

    private static final long serialVersionUID = 1L;

    /** class for storing the current aggregate value. */
    static class Aggregation implements AggregationBuffer {

      private static final long serialVersionUID = 1L;

      transient private double sum;
      transient private long count;

      /**
      * Value is explicitly (re)initialized in reset()
      */
      transient private boolean isNull = true;

      public void sumValue(double value) {
        if (isNull) {
          sum = value;
          count = 1;
          isNull = false;
        } else {
          sum += value;
          count++;
        }
      }

      @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
      }

      @Override
      public void reset() {
        isNull = true;
        sum = 0;
        count = 0L;
      }
    }

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFAvgTimestamp() {
    super();
  }

  public VectorUDAFAvgTimestamp(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
      Preconditions.checkState(this.mode == GenericUDAFEvaluator.Mode.PARTIAL1);
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

      TimestampColumnVector inputColVector =
          (TimestampColumnVector)batch.cols[
              this.inputExpression.getOutputColumnNum()];

      if (inputColVector.noNulls) {
        if (inputColVector.isRepeating) {
          iterateNoNullsRepeatingWithAggregationSelection(
            aggregationBufferSets, bufferIndex,
            inputColVector.getDouble(0),
            batchSize);
        } else {
          if (batch.selectedInUse) {
            iterateNoNullsSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              inputColVector, batch.selected, batchSize);
          } else {
            iterateNoNullsWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              inputColVector, batchSize);
          }
        }
      } else {
        if (inputColVector.isRepeating) {
          if (batch.selectedInUse) {
            iterateHasNullsRepeatingSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              inputColVector.getDouble(0), batchSize, batch.selected, inputColVector.isNull);
          } else {
            iterateHasNullsRepeatingWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              inputColVector.getDouble(0), batchSize, inputColVector.isNull);
          }
        } else {
          if (batch.selectedInUse) {
            iterateHasNullsSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              inputColVector, batchSize, batch.selected, inputColVector.isNull);
          } else {
            iterateHasNullsWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              inputColVector, batchSize, inputColVector.isNull);
          }
        }
      }
    }

    private void iterateNoNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      double value,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.sumValue(value);
      }
    }

    private void iterateNoNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      TimestampColumnVector inputColVector,
      int[] selection,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.sumValue(
            inputColVector.getDouble(selection[i]));
      }
    }

    private void iterateNoNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      TimestampColumnVector inputColVector,
      int batchSize) {
      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.sumValue(inputColVector.getDouble(i));
      }
    }

    private void iterateHasNullsRepeatingSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      double value,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[selection[i]]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            i);
          myagg.sumValue(value);
        }
      }

    }

    private void iterateHasNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      double value,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            i);
          myagg.sumValue(value);
        }
      }
    }

    private void iterateHasNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      TimestampColumnVector inputColVector,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      for (int j=0; j < batchSize; ++j) {
        int i = selection[j];
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            j);
          myagg.sumValue(inputColVector.getDouble(i));
        }
      }
   }

    private void iterateHasNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      TimestampColumnVector inputColVector,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            i);
          myagg.sumValue(inputColVector.getDouble(i));
        }
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
            if (myagg.isNull) {
              myagg.isNull = false;
              myagg.sum = 0;
              myagg.count = 0;
            }
            myagg.sum += inputColVector.getDouble(0)*batchSize;
            myagg.count += batchSize;
          }
          return;
        }

        if (!batch.selectedInUse && inputColVector.noNulls) {
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

    private void iterateSelectionHasNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int j=0; j< batchSize; ++j) {
        int i = selected[j];
        if (!isNull[i]) {
          double value = inputColVector.getDouble(i);
          if (myagg.isNull) {
            myagg.isNull = false;
            myagg.sum = 0;
            myagg.count = 0;
          }
          myagg.sum += value;
          myagg.count += 1;
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        int[] selected) {

      if (myagg.isNull) {
        myagg.isNull = false;
        myagg.sum = 0;
        myagg.count = 0;
      }

      for (int i=0; i< batchSize; ++i) {
        double value = inputColVector.getDouble(selected[i]);
        myagg.sum += value;
        myagg.count += 1;
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          double value = inputColVector.getDouble(i);
          if (myagg.isNull) {
            myagg.isNull = false;
            myagg.sum = 0;
            myagg.count = 0;
          }
          myagg.sum += value;
          myagg.count += 1;
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize) {
      if (myagg.isNull) {
        myagg.isNull = false;
        myagg.sum = 0;
        myagg.count = 0;
      }

      for (int i=0;i<batchSize;++i) {
        double value = inputColVector.getDouble(i);
        myagg.sum += value;
        myagg.count += 1;
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
     * Average input is TIMESTAMP.
     * Output is STRUCT.
     *
     * Mode PARTIAL1.
     */
    return
        name.equals("avg") &&
        inputColVectorType == ColumnVector.Type.TIMESTAMP &&
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
    Preconditions.checkState(myagg.count > 0);
    outputColVector.isNull[batchIndex] = false;

    ColumnVector[] fields = outputColVector.fields;
    fields[AVERAGE_COUNT_FIELD_INDEX].isNull[batchIndex] = false;
    ((LongColumnVector) fields[AVERAGE_COUNT_FIELD_INDEX]).vector[batchIndex] = myagg.count;
    fields[AVERAGE_SUM_FIELD_INDEX].isNull[batchIndex] = false;
    ((DoubleColumnVector) fields[AVERAGE_SUM_FIELD_INDEX]).vector[batchIndex] = myagg.sum;

    // NULL out useless source field.
    ColumnVector sourceColVector = (ColumnVector) fields[AVERAGE_SOURCE_FIELD_INDEX];
    sourceColVector.isRepeating = true;
    sourceColVector.noNulls = false;
    sourceColVector.isNull[0] = true;

  }
}
