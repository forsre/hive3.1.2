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

import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.aggregates.VectorAggregateExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpressionWriter;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpressionWriterFactory;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationBufferRow;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationDesc;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DecimalColumnVector;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.ql.util.JavaDataModel;
import org.apache.hadoop.hive.serde2.io.HiveDecimalWritable;

/**
* VectorUDAFMaxDecimal. Vectorized implementation for MIN/MAX aggregates.
*/
@Description(name = "max",
    value = "_FUNC_(expr) - Returns the maximum value of expr (vectorized, type: decimal)")
public class VectorUDAFMaxDecimal extends VectorAggregateExpression {

    private static final long serialVersionUID = 1L;

    /**
     * class for storing the current aggregate value.
     */
    static private final class Aggregation implements AggregationBuffer {

      private static final long serialVersionUID = 1L;

      transient private final HiveDecimalWritable value;

      /**
      * Value is explicitly (re)initialized in reset()
      */
      transient private boolean isNull = true;

      public Aggregation() {
        value = new HiveDecimalWritable();
      }

      public void checkValue(HiveDecimalWritable writable, short scale) {
        if (isNull) {
          isNull = false;
          this.value.set(writable);
        } else if (this.value.compareTo(writable) < 0) {
          this.value.set(writable);
        }
      }

      @Override
      public int getVariableSize() {
        throw new UnsupportedOperationException();
      }

      @Override
      public void reset () {
        isNull = true;
        value.set(HiveDecimal.ZERO);
      }
    }

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFMaxDecimal() {
    super();
  }

  public VectorUDAFMaxDecimal(VectorAggregationDesc vecAggrDesc) {
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

      DecimalColumnVector inputVector =
          (DecimalColumnVector) batch.cols[
              this.inputExpression.getOutputColumnNum()];

      HiveDecimalWritable[] vector = inputVector.vector;

      if (inputVector.noNulls) {
        if (inputVector.isRepeating) {
          iterateNoNullsRepeatingWithAggregationSelection(
            aggregationBufferSets, aggregrateIndex,
            vector[0], inputVector.scale, batchSize);
        } else {
          if (batch.selectedInUse) {
            iterateNoNullsSelectionWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              vector, inputVector.scale, batch.selected, batchSize);
          } else {
            iterateNoNullsWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              vector, inputVector.scale, batchSize);
          }
        }
      } else {
        if (inputVector.isRepeating) {
          if (batch.selectedInUse) {
            iterateHasNullsRepeatingSelectionWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              vector[0], inputVector.scale, batchSize, batch.selected, inputVector.isNull);
          } else {
            iterateHasNullsRepeatingWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              vector[0], inputVector.scale, batchSize, inputVector.isNull);
          }
        } else {
          if (batch.selectedInUse) {
            iterateHasNullsSelectionWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              vector, inputVector.scale, batchSize, batch.selected, inputVector.isNull);
          } else {
            iterateHasNullsWithAggregationSelection(
              aggregationBufferSets, aggregrateIndex,
              vector, inputVector.scale, batchSize, inputVector.isNull);
          }
        }
      }
    }

    private void iterateNoNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable value,
      short scale,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        myagg.checkValue(value, scale);
      }
    }

    private void iterateNoNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable[] values,
      short scale,
      int[] selection,
      int batchSize) {

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        myagg.checkValue(values[selection[i]], scale);
      }
    }

    private void iterateNoNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable[] values,
      short scale,
      int batchSize) {
      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        myagg.checkValue(values[i], scale);
      }
    }

    private void iterateHasNullsRepeatingSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable value,
      short scale,
      int batchSize,
      int[] selection,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[selection[i]]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregrateIndex,
            i);
          myagg.checkValue(value, scale);
        }
      }

    }

    private void iterateHasNullsRepeatingWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable value,
      short scale,
      int batchSize,
      boolean[] isNull) {

      if (isNull[0]) {
        return;
      }

      for (int i=0; i < batchSize; ++i) {
        Aggregation myagg = getCurrentAggregationBuffer(
          aggregationBufferSets,
          aggregrateIndex,
          i);
        myagg.checkValue(value, scale);
      }
    }

    private void iterateHasNullsSelectionWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable[] values,
      short scale,
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
          myagg.checkValue(values[i], scale);
        }
      }
   }

    private void iterateHasNullsWithAggregationSelection(
      VectorAggregationBufferRow[] aggregationBufferSets,
      int aggregrateIndex,
      HiveDecimalWritable[] values,
      short scale,
      int batchSize,
      boolean[] isNull) {

      for (int i=0; i < batchSize; ++i) {
        if (!isNull[i]) {
          Aggregation myagg = getCurrentAggregationBuffer(
            aggregationBufferSets,
            aggregrateIndex,
            i);
          myagg.checkValue(values[i], scale);
        }
      }
   }

    @Override
    public void aggregateInput(AggregationBuffer agg, VectorizedRowBatch batch)
      throws HiveException {

        inputExpression.evaluate(batch);

        DecimalColumnVector inputVector =
            (DecimalColumnVector)batch.cols[
                this.inputExpression.getOutputColumnNum()];

        int batchSize = batch.size;

        if (batchSize == 0) {
          return;
        }

        Aggregation myagg = (Aggregation)agg;

        HiveDecimalWritable[] vector = inputVector.vector;

        if (inputVector.isRepeating) {
          if ((inputVector.noNulls || !inputVector.isNull[0]) &&
            (myagg.isNull || (myagg.value.compareTo(vector[0]) < 0))) {
            myagg.isNull = false;
            myagg.value.set(vector[0]);
          }
          return;
        }

        if (!batch.selectedInUse && inputVector.noNulls) {
          iterateNoSelectionNoNulls(myagg, vector, inputVector.scale, batchSize);
        }
        else if (!batch.selectedInUse) {
          iterateNoSelectionHasNulls(myagg, vector, inputVector.scale,
            batchSize, inputVector.isNull);
        }
        else if (inputVector.noNulls){
          iterateSelectionNoNulls(myagg, vector, inputVector.scale, batchSize, batch.selected);
        }
        else {
          iterateSelectionHasNulls(myagg, vector, inputVector.scale,
            batchSize, inputVector.isNull, batch.selected);
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
          HiveDecimalWritable writable = vector[i];
          if (myagg.isNull) {
            myagg.isNull = false;
            myagg.value.set(writable);
          }
          else if (myagg.value.compareTo(writable) < 0) {
            myagg.value.set(writable);
          }
        }
      }
    }

    private void iterateSelectionNoNulls(
        Aggregation myagg,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize,
        int[] selected) {

      if (myagg.isNull) {
        myagg.value.set(vector[selected[0]]);
        myagg.isNull = false;
      }

      for (int i=0; i< batchSize; ++i) {
        HiveDecimalWritable writable = vector[selected[i]];
        if (myagg.value.compareTo(writable) < 0) {
          myagg.value.set(writable);
        }
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
          HiveDecimalWritable writable = vector[i];
          if (myagg.isNull) {
            myagg.value.set(writable);
            myagg.isNull = false;
          }
          else if (myagg.value.compareTo(writable) < 0) {
            myagg.value.set(writable);
          }
        }
      }
    }

    private void iterateNoSelectionNoNulls(
        Aggregation myagg,
        HiveDecimalWritable[] vector,
        short scale,
        int batchSize) {
      if (myagg.isNull) {
        myagg.value.set(vector[0]);
        myagg.isNull = false;
      }

      for (int i=0;i<batchSize;++i) {
        HiveDecimalWritable writable = vector[i];
        if (myagg.value.compareTo(writable) < 0) {
          myagg.value.set(writable);
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
     * Min/max input and output is DECIMAL.
     *
     * Any mode (PARTIAL1, PARTIAL2, FINAL, COMPLETE).
     */
    return
        name.equals("max") &&
        inputColVectorType == ColumnVector.Type.DECIMAL &&
        outputColVectorType == ColumnVector.Type.DECIMAL;
  }

  @Override
  public void assignRowColumn(VectorizedRowBatch batch, int batchIndex, int columnNum,
      AggregationBuffer agg) throws HiveException {

    DecimalColumnVector outputColVector = (DecimalColumnVector) batch.cols[columnNum];
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
