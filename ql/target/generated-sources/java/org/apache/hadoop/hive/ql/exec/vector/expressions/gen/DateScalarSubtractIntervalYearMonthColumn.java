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
import java.util.Arrays;

import org.apache.hadoop.hive.common.type.HiveIntervalYearMonth;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.exec.vector.*;


/*
 * Because of the templatized nature of the code, either or both
 * of these ColumnVector imports may be needed. Listing both of them
 * rather than using ....vectorization.*;
 */
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.expressions.NullUtil;
import org.apache.hadoop.hive.ql.util.DateTimeMath;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.io.DateWritableV2;

/**
 * Generated from template DateTimeScalarArithmeticIntervalYearMonthColumn.txt.
 * Implements a vectorized arithmetic operator with a scalar on the left and a
 * column vector on the right. The result is output to an output column vector.
 */
public class DateScalarSubtractIntervalYearMonthColumn extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int colNum;
  private final Date value;

  private transient final HiveIntervalYearMonth scratchIntervalYearMonth2 = new HiveIntervalYearMonth();
  private transient final Date outputDate = new Date(0);
  private transient final DateTimeMath dtm = new DateTimeMath();

  public DateScalarSubtractIntervalYearMonthColumn(long value, int colNum, int outputColumnNum) {
    super(outputColumnNum);
    this.value = new Date(DateWritableV2.daysToMillis((int) value));
    this.colNum = colNum;
  }

  public DateScalarSubtractIntervalYearMonthColumn() {
    super();

    // Dummy final assignments.
    value = null;
    colNum = -1;
  }

  @Override
  /**
   * Method to evaluate scalar-column operation in vectorized fashion.
   *
   * @batch a package of rows with each column stored in a vector
   */
  public void evaluate(VectorizedRowBatch batch) throws HiveException {

    // return immediately if batch is empty
    final int n = batch.size;
    if (n == 0) {
      return;
    }

    if (childExpressions != null) {
      super.evaluateChildren(batch);
    }

    // Input #2 is type Interval_Year_Month (months).
    LongColumnVector inputColVector2 = (LongColumnVector) batch.cols[colNum];

    // Output is type Date.
    LongColumnVector outputColVector = (LongColumnVector) batch.cols[outputColumnNum];

    int[] sel = batch.selected;
    boolean[] inputIsNull = inputColVector2.isNull;
    boolean[] outputIsNull = outputColVector.isNull;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    long[] vector2 = inputColVector2.vector;
    long[] outputVector = outputColVector.vector;

    if (inputColVector2.isRepeating) {
      if (inputColVector2.noNulls || !inputIsNull[0]) {
        outputIsNull[0] = false;
        scratchIntervalYearMonth2.set((int) vector2[0]);
        dtm.subtract(
            value, scratchIntervalYearMonth2, outputDate);
        outputVector[0] = DateWritableV2.dateToDays(outputDate);
      } else {
        outputIsNull[0] = true;
        outputColVector.noNulls = false;
      }
      outputColVector.isRepeating = true;
      return;
    }

    if (inputColVector2.noNulls) {
      if (batch.selectedInUse) {

         // CONSIDER: For large n, fill n or all of isNull array and use the tighter ELSE loop.

         if (!outputColVector.noNulls) {
           for(int j = 0; j != n; j++) {
            final int i = sel[j];
            outputIsNull[i] = false;
            scratchIntervalYearMonth2.set((int) vector2[i]);
            dtm.subtract(
                value, scratchIntervalYearMonth2, outputDate);
            outputVector[i] = DateWritableV2.dateToDays(outputDate);
          }
         } else {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             scratchIntervalYearMonth2.set((int) vector2[i]);
             dtm.subtract(
                 value, scratchIntervalYearMonth2, outputDate);
             outputVector[i] = DateWritableV2.dateToDays(outputDate);
           }
         }
      } else {
        if (!outputColVector.noNulls) {

          // Assume it is almost always a performance win to fill all of isNull so we can
          // safely reset noNulls.
          Arrays.fill(outputIsNull, false);
          outputColVector.noNulls = true;
        }
        for(int i = 0; i != n; i++) {
          scratchIntervalYearMonth2.set((int) vector2[i]);
          dtm.subtract(
              value, scratchIntervalYearMonth2, outputDate);
          outputVector[i] = DateWritableV2.dateToDays(outputDate);
        }
      }
    } else /* there are NULLs in the inputColVector */ {

      /*
       * Do careful maintenance of the outputColVector.noNulls flag.
       */

      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          if (!inputIsNull[i]) {
            outputIsNull[i] = false;
            scratchIntervalYearMonth2.set((int) vector2[i]);
            dtm.subtract(
                value, scratchIntervalYearMonth2, outputDate);
            outputVector[i] = DateWritableV2.dateToDays(outputDate);
          } else {
            outputIsNull[i] = true;
            outputColVector.noNulls = false;
          }
        }
      } else {
        for(int i = 0; i != n; i++) {
          if (!inputIsNull[i]) {
            outputIsNull[i] = false;
            scratchIntervalYearMonth2.set((int) vector2[i]);
            dtm.subtract(
                value, scratchIntervalYearMonth2, outputDate);
            outputVector[i] = DateWritableV2.dateToDays(outputDate);
          } else {
            outputIsNull[i] = true;
            outputColVector.noNulls = false;
          }
        }
      }
    }

    NullUtil.setNullOutputEntriesColScalar(outputColVector, batch.selectedInUse, sel, n);
  }

  @Override
  public String vectorExpressionParameters() {
    return "val " + value + ", " + getColumnParamString(1, colNum);
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
            VectorExpressionDescriptor.InputExpressionType.SCALAR,
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}
