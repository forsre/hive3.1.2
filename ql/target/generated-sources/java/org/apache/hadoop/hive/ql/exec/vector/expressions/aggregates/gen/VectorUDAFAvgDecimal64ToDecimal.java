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
import org.apache.hadoop.hive.ql.exec.vector.DecimalColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.Decimal64ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.StructColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.util.JavaDataModel;
import org.apache.hadoop.hive.serde2.typeinfo.StructTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.DecimalTypeInfo;
import org.apache.hadoop.hive.serde2.io.HiveDecimalWritable;

import com.google.common.base.Preconditions;

/**
 * Generated from template VectorUDAFAvg.txt.
 */
@Description(name = "avg",
    value = "_FUNC_(expr) - Returns the average value of expr (vectorized, type: decimal64)")
public class VectorUDAFAvgDecimal64ToDecimal extends VectorAggregateExpression {

  private static final long serialVersionUID = 1L;

  private int inputScale;

  private DecimalTypeInfo outputDecimalTypeInfo;

  private transient final HiveDecimalWritable temp = new HiveDecimalWritable();


  /** class for storing the current aggregate value. */
  static class Aggregation implements AggregationBuffer {

    private static final long serialVersionUID = 1L;

    // The max for 18 - 1 digits.
    private static final long nearDecimal64Max =
        HiveDecimalWritable.getDecimal64AbsMax(HiveDecimalWritable.DECIMAL64_DECIMAL_DIGITS - 1);

    private final int inputScale;
    private final HiveDecimalWritable temp;

    //----------------------------------------------------------------------------------------------

    private long sum;
    private final HiveDecimalWritable regularDecimalSum = new HiveDecimalWritable(0);

    transient private long count;

    /**
     * Value is explicitly (re)initialized in reset()
     */
    private boolean isNull = true;
    private boolean usingRegularDecimal = false;

    public Aggregation(int inputScale, HiveDecimalWritable temp) {
      this.inputScale = inputScale;
      this.temp = temp;
    }

    public void avgValue(long value) {
      if (isNull) {
        sum = value;
        count = 1;
        isNull = false;
      } else {
        if (Math.abs(sum) > nearDecimal64Max) {
          if (!usingRegularDecimal) {
            usingRegularDecimal = true;
            regularDecimalSum.deserialize64(sum, inputScale);
          } else {
            temp.deserialize64(sum, inputScale);
            regularDecimalSum.mutateAdd(temp);
          }
          sum = value;
        } else {
          sum += value;
        }

        count++;
      }
    }

    @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reset () {
      isNull = true;
      usingRegularDecimal = false;
      sum = 0;
      regularDecimalSum.setFromLong(0);

      count = 0L;
    }
  }

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFAvgDecimal64ToDecimal() {
    super();
  }

  public VectorUDAFAvgDecimal64ToDecimal(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
      Preconditions.checkState(this.mode == GenericUDAFEvaluator.Mode.PARTIAL1);
    init();
  }

  private void init() {
    inputScale = ((DecimalTypeInfo) inputTypeInfo).getScale();
    StructTypeInfo structTypeInfo = (StructTypeInfo) outputTypeInfo;
    outputDecimalTypeInfo = (DecimalTypeInfo) structTypeInfo.getAllStructFieldTypeInfos().get(AVERAGE_SUM_FIELD_INDEX);
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

       Decimal64ColumnVector inputVector =
           (Decimal64ColumnVector) batch.cols[
               this.inputExpression.getOutputColumnNum()];

      long[] vector = inputVector.vector;

      if (inputVector.noNulls) {
        if (inputVector.isRepeating) {
          iterateNoNullsRepeatingWithAggregationSelection(
            aggregationBufferSets, bufferIndex,
            vector[0], batchSize);
        } else {
          if (batch.selectedInUse) {
            iterateNoNullsSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              vector, batch.selected, batchSize);
          } else {
            iterateNoNullsWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              vector, batchSize);
          }
        }
      } else {
        if (inputVector.isRepeating) {
          if (batch.selectedInUse) {
            iterateHasNullsRepeatingSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              vector[0], batchSize, batch.selected, inputVector.isNull);
          } else {
            iterateHasNullsRepeatingWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              vector[0], batchSize, inputVector.isNull);
          }
        } else {
          if (batch.selectedInUse) {
            iterateHasNullsSelectionWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              vector, batchSize, batch.selected, inputVector.isNull);
          } else {
            iterateHasNullsWithAggregationSelection(
              aggregationBufferSets, bufferIndex,
              vector, batchSize, inputVector.isNull);
          }
        }
      }
    }

    private void iterateNoNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long value,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.avgValue(value);
      }
    }

    private void iterateNoNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] values,
      int[] selection,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.avgValue(values[selection[i]]);
      }
    }

    private void iterateNoNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] values,
      int batchSize) {
      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.avgValue(values[i]);
      }
    }

    private void iterateHasNullsRepeatingSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long value,
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
        myagg.avgValue(value);
      }

    }

    private void iterateHasNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long value,
      int batchSize,
      boolean[] isNull) {

      if (isNull[0]) {
        return;
      }

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          bufferIndex,
          i);
        myagg.avgValue(value);
      }
    }

    private void iterateHasNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] values,
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
          myagg.avgValue(values[i]);
        }
      }
   }

    private void iterateHasNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int bufferIndex,
      long[] values,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            bufferIndex,
            i);
          myagg.avgValue(values[i]);
        }
      }
   }

    @Override
    public void aggregateInput(AggregationBuffer agg, VectorizedRowBatch batch)
        throws HiveException {

      inputExpression.evaluate(batch);

      Decimal64ColumnVector inputVector =
          (Decimal64ColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      int batchSize = batch.size;

      if (batchSize == 0) {
        return;
      }

      Aggregation myagg = (Aggregation)agg;

      long[] vector = inputVector.vector;

      if (inputVector.isRepeating) {
        if (inputVector.noNulls || !inputVector.isNull[0]) {
          final long value = vector[0];
          for (int i = 0; i < batchSize; i++) {
            myagg.avgValue(value);
          }
        }
        return;
      }

      if (!batch.selectedInUse && inputVector.noNulls) {
        iterateNoSelectionNoNulls(myagg, vector, batchSize);
      } else if (!batch.selectedInUse) {
        iterateNoSelectionHasNulls(myagg, vector, batchSize, inputVector.isNull);
      } else if (inputVector.noNulls){
        iterateSelectionNoNulls(myagg, vector, batchSize, batch.selected);
      } else {
        iterateSelectionHasNulls(myagg, vector, batchSize, inputVector.isNull, batch.selected);
      }
    }

    private void iterateSelectionHasNulls(
        Aggregation myagg,
        long[] vector,
        int batchSize,
        boolean[] isNull,
        int[] selected) {

      for (int j=0; j< batchSize; ++j) {
        int i = selected[j];
        if (!isNull[i]) {
          myagg.avgValue(vector[i]);
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        long[] vector,
        int batchSize,
        int[] selected) {

      for (int i=0; i< batchSize; ++i) {
        myagg.avgValue(vector[selected[i]]);
      }
    }

    private void iterateNoSelectionHasNulls(
        Aggregation myagg,
        long[] vector,
        int batchSize,
        boolean[] isNull) {

      for(int i=0;i<batchSize;++i) {
        if (!isNull[i]) {
          myagg.avgValue(vector[i]);
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        long[] vector,
        int batchSize) {

      for (int i=0;i<batchSize;++i) {
        myagg.avgValue(vector[i]);
      }
    }

    @Override
    public AggregationBuffer getNewAggregationBuffer() throws HiveException {
      return new Aggregation(inputScale, temp);
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
     * Average input is DECIMAL_64.
     * Output is STRUCT.
     *
     * Mode PARTIAL1.
     */
    return
        name.equals("avg") &&
        inputColVectorType == ColumnVector.Type.DECIMAL_64 &&
        outputColVectorType == ColumnVector.Type.STRUCT &&
        mode == Mode.PARTIAL1;
  }

  @Override
  public void assignRowColumn(VectorizedRowBatch batch, int batchIndex, int columnNum,
      AggregationBuffer agg) throws HiveException {

    StructColumnVector outputColVector = (StructColumnVector) batch.cols[columnNum];

    Aggregation myagg = (Aggregation) agg;
    final boolean isNull;
    if (!myagg.isNull) {
      if (!myagg.usingRegularDecimal) {
        myagg.regularDecimalSum.deserialize64(myagg.sum, inputScale);
      } else {
        myagg.temp.deserialize64(myagg.sum, inputScale);
        myagg.regularDecimalSum.mutateAdd(myagg.temp);
      }

      isNull = !myagg.regularDecimalSum.isSet();
    } else {
      isNull = true;
    }
    if (isNull) {
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
    ((DecimalColumnVector) fields[AVERAGE_SUM_FIELD_INDEX]).set(
        batchIndex, myagg.regularDecimalSum);

    // NULL out useless source field.
    ColumnVector sourceColVector = (ColumnVector) fields[AVERAGE_SOURCE_FIELD_INDEX];
    sourceColVector.isRepeating = true;
    sourceColVector.noNulls = false;
    sourceColVector.isNull[0] = true;

  }
}
