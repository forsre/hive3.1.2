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

import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import java.sql.Timestamp;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * Compute IF(expr1, expr2, expr3) for 3 input column expressions.
 * The first is always a boolean (LongColumnVector).
 * The second is a column or non-constant expression result.
 * The third is a constant value.
 */
public class IfExprTimestampScalarColumn extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int arg1Column;
  private Timestamp arg2Scalar;
  private final int arg3Column;

  public IfExprTimestampScalarColumn(int arg1Column, Timestamp arg2Scalar, int arg3Column,
      int outputColumnNum) {
    super(outputColumnNum);
    this.arg1Column = arg1Column;
    this.arg2Scalar = arg2Scalar;
    this.arg3Column = arg3Column;
  }

  public IfExprTimestampScalarColumn() {
    super();

    // Dummy final assignments.
    arg1Column = -1;
    arg2Scalar = null;
    arg3Column = -1;
  }

  @Override
  public void evaluate(VectorizedRowBatch batch) throws HiveException {

    if (childExpressions != null) {
      super.evaluateChildren(batch);
    }

    LongColumnVector arg1ColVector = (LongColumnVector) batch.cols[arg1Column];
    TimestampColumnVector arg3ColVector = (TimestampColumnVector) batch.cols[arg3Column];
    boolean[] arg3IsNull = arg3ColVector.isNull;
    TimestampColumnVector outputColVector = (TimestampColumnVector) batch.cols[outputColumnNum];
    int[] sel = batch.selected;
    boolean[] outputIsNull = outputColVector.isNull;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    int n = batch.size;
    long[] vector1 = arg1ColVector.vector;

    // return immediately if batch is empty
    if (n == 0) {
      return;
    }

    if (arg1ColVector.isRepeating) {
      if ((arg1ColVector.noNulls || !arg1ColVector.isNull[0]) && vector1[0] == 1) {
        outputColVector.fill(arg2Scalar);
      } else {
        arg3ColVector.copySelected(batch.selectedInUse, sel, n, outputColVector);
      }
      return;
    }

    // Extend any repeating values and noNulls indicator in the inputs to
    // reduce the number of code paths needed below.
    // This could be optimized in the future by having separate paths
    // for when arg3ColVector is repeating or has no nulls.
    arg3ColVector.flatten(batch.selectedInUse, sel, n);

    if (arg1ColVector.noNulls) {

      // FUTURE: We could check arg3ColVector.noNulls and optimize these loops.
      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          if (vector1[i] == 1) {
            outputIsNull[i] = false;
            outputColVector.set(i, arg2Scalar);
          } else {
            if (!arg3IsNull[i]) {
              outputIsNull[i] = false;
              outputColVector.set(i, arg3ColVector.asScratchTimestamp(i));
            } else {
              outputIsNull[i] = true;
              outputColVector.noNulls = false;
            }
          }
        }
      } else {
        for(int i = 0; i != n; i++) {
          if (vector1[i] == 1) {
            outputIsNull[i] = false;
            outputColVector.set(i, arg2Scalar);
          } else {
            if (!arg3IsNull[i]) {
              outputIsNull[i] = false;
              outputColVector.set(i, arg3ColVector.asScratchTimestamp(i));
            } else {
              outputIsNull[i] = true;
              outputColVector.noNulls = false;
            }
          }
        }
      }
    } else /* there are nulls */ {

      if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          if (!arg1ColVector.isNull[i] && vector1[i] == 1) {
            outputIsNull[i] = false;
            outputColVector.set(i, arg2Scalar);
          } else {
            if (!arg3IsNull[i]) {
              outputIsNull[i] = false;
              outputColVector.set(i, arg3ColVector.asScratchTimestamp(i));
            } else {
              outputIsNull[i] = true;
              outputColVector.noNulls = false;
            }
          }
        }
      } else {
        for(int i = 0; i != n; i++) {
          if (!arg1ColVector.isNull[i] && vector1[i] == 1) {
            outputIsNull[i] = false;
            outputColVector.set(i, arg2Scalar);
          } else {
            if (!arg3IsNull[i]) {
              outputIsNull[i] = false;
              outputColVector.set(i, arg3ColVector.asScratchTimestamp(i));
            } else {
              outputIsNull[i] = true;
              outputColVector.noNulls = false;
            }
          }
        }
      }
    }

    // restore repeating and no nulls indicators
    arg3ColVector.unFlatten();
  }

  @Override
  public String vectorExpressionParameters() {
    return getColumnParamString(0, arg1Column) + ", val "+ arg2Scalar + ", " +
        getColumnParamString(2, arg3Column);
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder())
        .setMode(
            VectorExpressionDescriptor.Mode.PROJECTION)
        .setNumArguments(3)
        .setArgumentTypes(
            VectorExpressionDescriptor.ArgumentType.getType("int_family"),
            VectorExpressionDescriptor.ArgumentType.getType("timestamp"),
            VectorExpressionDescriptor.ArgumentType.getType("timestamp"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.SCALAR,
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}
