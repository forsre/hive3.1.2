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

import java.sql.Timestamp;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.aggregates.VectorAggregateExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpressionWriter;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpressionWriterFactory;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationBufferRow;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationDesc;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.util.JavaDataModel;
import org.apache.hadoop.hive.serde2.io.TimestampWritableV2;

/**
* VectorUDAFMaxTimestamp. Vectorized implementation for MIN/MAX aggregates.
*/
@Description(name = "max",
    value = "_FUNC_(expr) - Returns the maximum value of expr (vectorized, type: timestamp)")
public class VectorUDAFMaxTimestamp extends VectorAggregateExpression {

    private static final long serialVersionUID = 1L;

    /**
     * class for storing the current aggregate value.
     */
    static private final class Aggregation implements AggregationBuffer {

      private static final long serialVersionUID = 1L;

      transient private final Timestamp value;

      /**
      * Value is explicitly (re)initialized in reset()
      */
      transient private boolean isNull = true;

      public Aggregation() {
        value = new Timestamp(0);
      }

      public void checkValue(TimestampColumnVector colVector, int index) {
        if (isNull) {
          isNull = false;
          colVector.timestampUpdate(this.value, index);
        } else if (colVector.compareTo(this.value, index) < 0) {
          colVector.timestampUpdate(this.value, index);
        }
      }

      @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
      }

      @Override
      public void reset () {
        isNull = true;
        this.value.setTime(0);
      }
    }

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFMaxTimestamp() {
    super();
  }

  public VectorUDAFMaxTimestamp(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
    init();
  }

    private void init() {
    }

    private Aggregation getCurrentAggregationBuffer(
        VectorAggregationBufferRow[] aggregationBufferSets,
        int aggregrateIndex,
        int row) {
      VectorAggregationBufferRow mySet = aggregationBufferSets[row];
      Aggregation myagg = (Aggregation) mySet.getAggregationBuffer(aggregrateIndex);
      return myagg;
    }

    @Override
    public void aggregateInputSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      VectorizedRowBatch batch) throws HiveException {

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      inputExpression.evaluate(batch);

      TimestampColumnVector inputColVector =
          (TimestampColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      if (inputColVector.noNulls) {
        if (inputColVector.isRepeating) {
          iterateNoNullsRepeatingWithAggregationSelection(
            aggregationBufferSets, aggregrateIndex,
            inputColVector, batchSize);
        } else {
          if (batch.selectedInUse) {
            iterateNoNullsSelectionWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              inputColVector, batch.selected, batchSize);
          } else {
            iterateNoNullsWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              inputColVector, batchSize);
          }
        }
      } else {
        if (inputColVector.isRepeating) {
          if (batch.selectedInUse) {
            iterateHasNullsRepeatingSelectionWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              inputColVector, batchSize, batch.selected, inputColVector.isNull);
          } else {
            iterateHasNullsRepeatingWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              inputColVector, batchSize, inputColVector.isNull);
          }
        } else {
          if (batch.selectedInUse) {
            iterateHasNullsSelectionWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              inputColVector, batchSize, batch.selected, inputColVector.isNull);
          } else {
            iterateHasNullsWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              inputColVector, batchSize, inputColVector.isNull);
          }
        }
      }
    }

    private void iterateNoNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        // Repeating use index 0.
        myagg.checkValue(inputColVector, 0);
      }
    }

    private void iterateNoNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int[] selection,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        myagg.checkValue(inputColVector, selection[i]);
      }
    }

    private void iterateNoNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int batchSize) {
      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        myagg.checkValue(inputColVector, i);
      }
    }

    private void iterateHasNullsRepeatingSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[selection[i]]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregrateIndex,
            i);
          // Repeating use index 0.
          myagg.checkValue(inputColVector, 0);
        }
      }

    }

    private void iterateHasNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregrateIndex,
            i);
          // Repeating use index 0.
          myagg.checkValue(inputColVector, 0);
        }
      }
    }

    private void iterateHasNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      for (int j=0; j < batchSize; ++j) {
        int i = selection[j];
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregrateIndex,
            j);
          myagg.checkValue(inputColVector, i);
        }
      }
   }

    private void iterateHasNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      TimestampColumnVector inputColVector,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregrateIndex,
            i);
          myagg.checkValue(inputColVector, i);
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
          if ((inputColVector.noNulls || !inputColVector.isNull[0]) &&
            (myagg.isNull || (inputColVector.compareTo(myagg.value, 0) < 0))) {
            myagg.isNull = false;
            inputColVector.timestampUpdate(myagg.value, 0);
          }
          return;
        }

        if (!batch.selectedInUse && inputColVector.noNulls) {
          iterateNoSelectionNoNulls(myagg, inputColVector, batchSize);
        }
        else if (!batch.selectedInUse) {
          iterateNoSelectionHasNulls(myagg, inputColVector,
            batchSize, inputColVector.isNull);
        }
        else if (inputColVector.noNulls){
          iterateSelectionNoNulls(myagg, inputColVector, batchSize, batch.selected);
        }
        else {
          iterateSelectionHasNulls(myagg, inputColVector,
            batchSize, inputColVector.isNull, batch.selected);
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
          if (myagg.isNull) {
            myagg.isNull = false;
            inputColVector.timestampUpdate(myagg.value, i);
          }
          else if (inputColVector.compareTo(myagg.value, i) < 0) {
            inputColVector.timestampUpdate(myagg.value, i);
          }
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        int[] selected) {

      if (myagg.isNull) {
        inputColVector.timestampUpdate(myagg.value, selected[0]);
        myagg.isNull = false;
      }

      for (int i=0; i< batchSize; ++i) {
        int sel = selected[i];
        if (inputColVector.compareTo(myagg.value, sel) < 0) {
          inputColVector.timestampUpdate(myagg.value, sel);
        }
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          if (myagg.isNull) {
            inputColVector.timestampUpdate(myagg.value, i);
            myagg.isNull = false;
          }
          else if (inputColVector.compareTo(myagg.value, i) < 0) {
            inputColVector.timestampUpdate(myagg.value, i);
          }
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        TimestampColumnVector inputColVector,
        int batchSize) {
      if (myagg.isNull) {
        inputColVector.timestampUpdate(myagg.value, 0);
        myagg.isNull = false;
      }

      for (int i=0;i<batchSize;++i) {
        if (inputColVector.compareTo(myagg.value, i) < 0) {
          inputColVector.timestampUpdate(myagg.value, i);
        }
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
      model.primitive2(),
      model.memoryAlign());
  }

  @Override
  public boolean matches(String name, ColumnVector.Type inputColVectorType,
      ColumnVector.Type outputColVectorType, Mode mode) {

    /*
     * Min/max input and output is TIMESTAMP.
     *
     * Any mode (PARTIAL1, PARTIAL2, FINAL, COMPLETE).
     */
    return
        name.equals("max") &&
        inputColVectorType == ColumnVector.Type.TIMESTAMP &&
        outputColVectorType == ColumnVector.Type.TIMESTAMP;
  }

  @Override
  public void assignRowColumn(VectorizedRowBatch batch, int batchIndex, int columnNum,
      AggregationBuffer agg) throws HiveException {

    TimestampColumnVector outputColVector = (TimestampColumnVector) batch.cols[columnNum];
    Aggregation myagg = (Aggregation) agg;
       if (myagg.isNull) {
      outputColVector.noNulls = false;
      outputColVector.isNull[batchIndex] = true;
      return;
    }
    outputColVector.isNull[batchIndex] = false;
    outputColVector.set(batchIndex, myagg.value);
  }
}

