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
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.expressions.NullUtil;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.hadoop.hive.ql.util.DateTimeMath;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * Generated from template TimestampColumnArithmeticTimestampScalar.txt, which covers binary arithmetic
 * expressions between a column and a scalar.
 */
public class IntervalDayTimeColAddTimestampScalar extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int colNum;
  private final Timestamp value;

  private transient final DateTimeMath dtm = new DateTimeMath();

  public IntervalDayTimeColAddTimestampScalar(int colNum, Timestamp value, int outputColumnNum) {
    super(outputColumnNum);
    this.colNum = colNum;
    this.value = value;
  }

  public IntervalDayTimeColAddTimestampScalar() {
     super();

    // Dummy final assignments.
    colNum = -1;
    value = null;
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
    IntervalDayTimeColumnVector inputColVector1 = (IntervalDayTimeColumnVector) batch.cols[colNum];

    // Output is type timestamp.
    TimestampColumnVector outputColVector = (TimestampColumnVector) batch.cols[outputColumnNum];

    int[] sel = batch.selected;
    boolean[] inputIsNull = inputColVector1.isNull;
    boolean[] outputIsNull = outputColVector.isNull;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    if (inputColVector1.isRepeating) {
      if (inputColVector1.noNulls || !inputIsNull[0]) {
        outputIsNull[0] = false;
        dtm.add(
            inputColVector1.asScratchIntervalDayTime(0), value, outputColVector.getScratchTimestamp());
        outputColVector.setFromScratchTimestamp(0);
      } else {
        outputIsNull[0] = true;
        outputColVector.noNulls = false;
      }
      outputColVector.isRepeating = true;
      NullUtil.setNullOutputEntriesColScalar(outputColVector, batch.selectedInUse, sel, n);
      return;
    }

    if (inputColVector1.noNulls) {
      if (batch.selectedInUse) {

         // CONSIDER: For large n, fill n or all of isNull array and use the tighter ELSE loop.

         if (!outputColVector.noNulls) {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             outputIsNull[i] = false;
             dtm.add(
                inputColVector1.asScratchIntervalDayTime(i), value, outputColVector.getScratchTimestamp());
             outputColVector.setFromScratchTimestamp(i);
          }
         } else {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             dtm.add(
                inputColVector1.asScratchIntervalDayTime(i), value, outputColVector.getScratchTimestamp());
             outputColVector.setFromScratchTimestamp(i);
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
          dtm.add(
              inputColVector1.asScratchIntervalDayTime(i), value, outputColVector.getScratchTimestamp());
          outputColVector.setFromScratchTimestamp(i);
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
            dtm.add(
                inputColVector1.asScratchIntervalDayTime(i), value, outputColVector.getScratchTimestamp());
            outputColVector.setFromScratchTimestamp(i);
          } else {
            outputIsNull[i] = true;
            outputColVector.noNulls = false;
          }
        }
      } else {
        for(int i = 0; i != n; i++) {
         if (!inputIsNull[i]) {
            outputIsNull[i] = false;
            dtm.add(
                inputColVector1.asScratchIntervalDayTime(i), value, outputColVector.getScratchTimestamp());
            outputColVector.setFromScratchTimestamp(i);
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
    return getColumnParamString(0, colNum) + ", val " + TimestampUtils.timestampScalarTypeToString(value);
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder())
        .setMode(
            VectorExpressionDescriptor.Mode.PROJECTION)
        .setNumArguments(2)
        .setArgumentTypes(
            VectorExpressionDescriptor.ArgumentType.getType("interval_day_time"),
            VectorExpressionDescriptor.ArgumentType.getType("timestamp"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.SCALAR).build();
  }
}
