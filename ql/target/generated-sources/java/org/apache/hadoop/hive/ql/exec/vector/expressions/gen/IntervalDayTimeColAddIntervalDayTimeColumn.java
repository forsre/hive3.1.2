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

package org.apache.hadoop.hive.ql.exec.vector.expressions.gen;

import java.sql.Timestamp;

import org.apache.hadoop.hive.common.type.HiveIntervalDayTime;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.NullUtil;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.util.DateTimeMath;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * Generated from template TimestampColumnArithmeticTimestampColumnBase.txt, which covers binary arithmetic
 * expressions between columns.
 */
public class IntervalDayTimeColAddIntervalDayTimeColumn extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int colNum1;
  private final int colNum2;

  private transient final DateTimeMath dtm = new DateTimeMath();

  public IntervalDayTimeColAddIntervalDayTimeColumn(int colNum1, int colNum2, int outputColumnNum) {
    super(outputColumnNum);
    this.colNum1 = colNum1;
    this.colNum2 = colNum2;
  }

  public IntervalDayTimeColAddIntervalDayTimeColumn() {
     super();

    // Dummy final assignments.
    colNum1 = -1;
    colNum2 = -1;
  }

  @Override
  public void evaluate(VectorizedRowBatch batch) throws HiveException {

    // return immediately if batch is empty
    final int n = batch.size;
    if (n == 0) {
      return;
    }

    if (childExpressions != null) {
      super.evaluateChildren(batch);
    }

    // Input #1 is type interval_day_time.
    IntervalDayTimeColumnVector inputColVector1 = (IntervalDayTimeColumnVector) batch.cols[colNum1];

    // Input #2 is type interval_day_time.
    IntervalDayTimeColumnVector inputColVector2 = (IntervalDayTimeColumnVector) batch.cols[colNum2];

    // Output is type interval_day_time.
    IntervalDayTimeColumnVector outputColVector = (IntervalDayTimeColumnVector) batch.cols[outputColumnNum];

    int[] sel = batch.selected;

    /*
     * Propagate null values for a two-input operator and set isRepeating and noNulls appropriately.
     */
    NullUtil.propagateNullsColCol(
      inputColVector1, inputColVector2, outputColVector, sel, n, batch.selectedInUse);

    /* Disregard nulls for processing. In other words,
     * the arithmetic operation is performed even if one or
     * more inputs are null. This is to improve speed by avoiding
     * conditional checks in the inner loop.
     */
    if (inputColVector1.isRepeating && inputColVector2.isRepeating) {
      dtm.add(
          inputColVector1.asScratchIntervalDayTime(0), inputColVector2.asScratchIntervalDayTime(0), outputColVector.getScratchIntervalDayTime());
      outputColVector.setFromScratchIntervalDayTime(0);
    } else if (inputColVector1.isRepeating) {
      HiveIntervalDayTime value1 = inputColVector1.asScratchIntervalDayTime(0);
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          dtm.add(
              value1, inputColVector2.asScratchIntervalDayTime(i), outputColVector.getScratchIntervalDayTime());
          outputColVector.setFromScratchIntervalDayTime(i);
        }
      } else {
        for(int i = 0; i != n; i++) {
          dtm.add(
              value1, inputColVector2.asScratchIntervalDayTime(i), outputColVector.getScratchIntervalDayTime());
          outputColVector.setFromScratchIntervalDayTime(i);
        }
      }
    } else if (inputColVector2.isRepeating) {
      HiveIntervalDayTime value2 = inputColVector2.asScratchIntervalDayTime(0);
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          dtm.add(
              inputColVector1.asScratchIntervalDayTime(i), value2, outputColVector.getScratchIntervalDayTime());
          outputColVector.setFromScratchIntervalDayTime(i);
        }
      } else {
        for(int i = 0; i != n; i++) {
          dtm.add(
              inputColVector1.asScratchIntervalDayTime(i), value2, outputColVector.getScratchIntervalDayTime());
          outputColVector.setFromScratchIntervalDayTime(i);
        }
      }
    } else {
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          dtm.add(
              inputColVector1.asScratchIntervalDayTime(i), inputColVector2.asScratchIntervalDayTime(i), outputColVector.getScratchIntervalDayTime());
          outputColVector.setFromScratchIntervalDayTime(i);
        }
      } else {
        for(int i = 0; i != n; i++) {
          dtm.add(
              inputColVector1.asScratchIntervalDayTime(i), inputColVector2.asScratchIntervalDayTime(i), outputColVector.getScratchIntervalDayTime());
          outputColVector.setFromScratchIntervalDayTime(i);
        }
      }
    }

    /* For the case when the output can have null values, follow
     * the convention that the data values must be 1 for long and
     * NaN for double. This is to prevent possible later zero-divide errors
     * in complex arithmetic expressions like col2 / (col1 - 1)
     * in the case when some col1 entries are null.
     */
    NullUtil.setNullDataEntriesIntervalDayTime(outputColVector, batch.selectedInUse, sel, n);
  }

  @Override
  public String vectorExpressionParameters() {
    return getColumnParamString(0, colNum1) + ", " + getColumnParamString(1, colNum2);
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder())
        .setMode(
            VectorExpressionDescriptor.Mode.PROJECTION)
        .setNumArguments(2)
        .setArgumentTypes(
            VectorExpressionDescriptor.ArgumentType.getType("interval_day_time"),
            VectorExpressionDescriptor.ArgumentType.getType("interval_day_time"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}
