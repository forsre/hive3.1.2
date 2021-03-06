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

import java.sql.Date;
import org.apache.hadoop.hive.common.type.HiveIntervalYearMonth;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.NullUtil;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.util.DateTimeMath;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.io.DateWritableV2;

/**
 * Generated from template DateColumnArithmeticIntervalYearMonthColumn.txt, which covers binary arithmetic
 * expressions between date and interval year month columns.
 */
public class DateColAddIntervalYearMonthColumn extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int colNum1;
  private final int colNum2;

  private transient final Date scratchDate1 = new Date(0);
  private transient final HiveIntervalYearMonth scratchIntervalYearMonth2 = new HiveIntervalYearMonth();
  private transient final Date outputDate = new Date(0);
  private transient final DateTimeMath dtm = new DateTimeMath();

  public DateColAddIntervalYearMonthColumn(int colNum1, int colNum2, int outputColumnNum) {
    super(outputColumnNum);
    this.colNum1 = colNum1;
    this.colNum2 = colNum2;
  }

  public DateColAddIntervalYearMonthColumn() {
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

    // Input #1 is type date.
    LongColumnVector inputColVector1 = (LongColumnVector) batch.cols[colNum1];

    // Input #2 is type interval_year_month.
    LongColumnVector inputColVector2 = (LongColumnVector) batch.cols[colNum2];

    // Output is type date.
    LongColumnVector outputColVector = (LongColumnVector) batch.cols[outputColumnNum];

    int[] sel = batch.selected;

    long[] vector1 = inputColVector1.vector;
    long[] vector2 = inputColVector2.vector;
    long[] outputVector = outputColVector.vector;

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
      scratchDate1.setTime(DateWritableV2.daysToMillis((int) vector1[0]));
      scratchIntervalYearMonth2.set((int) vector2[0]);
      dtm.add(
          scratchDate1, scratchIntervalYearMonth2,  outputDate);
      outputVector[0] = DateWritableV2.dateToDays(outputDate);
    } else if (inputColVector1.isRepeating) {
      scratchDate1.setTime(DateWritableV2.daysToMillis((int) vector1[0]));
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.add(
              scratchDate1, scratchIntervalYearMonth2,  outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      } else {
        for(int i = 0; i != n; i++) {
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.add(
              scratchDate1, scratchIntervalYearMonth2,  outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      }
    } else if (inputColVector2.isRepeating) {
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          scratchDate1.setTime(DateWritableV2.daysToMillis((int) vector1[i]));
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.add(
              scratchDate1, scratchIntervalYearMonth2,  outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      } else {
        for(int i = 0; i != n; i++) {
          scratchDate1.setTime(DateWritableV2.daysToMillis((int) vector1[i]));
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.add(
              scratchDate1, scratchIntervalYearMonth2,  outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      }
    } else {
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          scratchDate1.setTime(DateWritableV2.daysToMillis((int) vector1[i]));
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.add(
              scratchDate1, scratchIntervalYearMonth2,  outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      } else {
        for(int i = 0; i != n; i++) {
          scratchDate1.setTime(DateWritableV2.daysToMillis((int) vector1[i]));
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.add(
              scratchDate1, scratchIntervalYearMonth2,  outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      }
    }

    /* For the case when the output can have null values, follow
     * the convention that the data values must be 1 for long and
     * NaN for double. This is to prevent possible later zero-divide errors
     * in complex arithmetic expressions like col2 / (col1 - 1)
     * in the case when some col1 entries are null.
     */
    NullUtil.setNullDataEntriesLong(outputColVector, batch.selectedInUse, sel, n);
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
            VectorExpressionDescriptor.ArgumentType.getType("date"),
            VectorExpressionDescriptor.ArgumentType.getType("interval_year_month"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}

