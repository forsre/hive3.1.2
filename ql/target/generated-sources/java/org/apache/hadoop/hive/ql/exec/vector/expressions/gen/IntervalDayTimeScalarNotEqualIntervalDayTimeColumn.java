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

import java.util.Arrays;
import java.sql.Timestamp;

import org.apache.hadoop.hive.common.type.HiveIntervalDayTime;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.NullUtil;
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * Generated from template ScalarCompareTimestamp.txt, which covers comparison
 * expressions between a long/double scalar and a column. The boolean output is stored in a
 * separate boolean column.
 */
public class IntervalDayTimeScalarNotEqualIntervalDayTimeColumn extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final HiveIntervalDayTime value;
  private final int colNum;

  public IntervalDayTimeScalarNotEqualIntervalDayTimeColumn(HiveIntervalDayTime value, int colNum, int outputColumnNum) {
    super(outputColumnNum);
    this.value = value;
    this.colNum = colNum;
  }

  public IntervalDayTimeScalarNotEqualIntervalDayTimeColumn() {
     super();

    // Dummy final assignments.
    value = null;
    colNum = -1;
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

     // Input #2 is type interval_day_time.
    IntervalDayTimeColumnVector inputColVector2 = (IntervalDayTimeColumnVector) batch.cols[colNum];

    LongColumnVector outputColVector = (LongColumnVector) batch.cols[outputColumnNum];

    int[] sel = batch.selected;
    boolean[] inputIsNull = inputColVector2.isNull;
    boolean[] outputIsNull = outputColVector.isNull;

    long[] outputVector = outputColVector.vector;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    if (inputColVector2.isRepeating) {
      if (inputColVector2.noNulls || !inputIsNull[0]) {
        outputIsNull[0] = false;
        outputVector[0] = inputColVector2.compareTo(value, 0) != 0 ? 1 : 0;
      } else {
        outputIsNull[0] = true;
        outputColVector.noNulls = false;
      }
      outputColVector.isRepeating = true;
      NullUtil.setNullOutputEntriesColScalar(outputColVector, batch.selectedInUse, sel, n);
      return;
    }

    if (inputColVector2.noNulls) {
      if (batch.selectedInUse) {

         // CONSIDER: For large n, fill n or all of isNull array and use the tighter ELSE loop.

         if (!outputColVector.noNulls) {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             outputIsNull[i] = false;
             outputVector[i] = inputColVector2.compareTo(value, i) != 0 ? 1 : 0;
          }
         } else {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             outputVector[i] = inputColVector2.compareTo(value, i) != 0 ? 1 : 0;
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
          outputVector[i] = inputColVector2.compareTo(value, i) != 0 ? 1 : 0;
        }
      }
    } else /* there are NULLs in the inputColVector */ {

      /*
       * Do careful maintenance of the outputColVector.noNulls flag.
       */

      if (batch.selectedInUse) {
        for(int j=0; j != n; j++) {
          int i = sel[j];
          if (!inputIsNull[i]) {
            outputIsNull[i] = false;
            outputVector[i] = inputColVector2.compareTo(value, i) != 0 ? 1 : 0;
          } else {
            // Comparison with NULL is NULL.
            outputIsNull[i] = true;
            outputColVector.noNulls = false;
          }
        }
      } else {
        System.arraycopy(inputIsNull, 0, outputIsNull, 0, n);
        for(int i = 0; i != n; i++) {
          if (!inputIsNull[i]) {
            outputIsNull[i] = false;
            outputVector[i] = inputColVector2.compareTo(value, i) != 0 ? 1 : 0;
          } else {
            // Comparison with NULL is NULL.
            outputIsNull[i] = true;
            outputColVector.noNulls = false;
          }
        }
      }
    }
  }

  @Override
  public String vectorExpressionParameters() {
    return "val " + TimestampUtils.timestampScalarTypeToString(value) + ", "  + getColumnParamString(1, colNum);
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
            VectorExpressionDescriptor.InputExpressionType.SCALAR,
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}
