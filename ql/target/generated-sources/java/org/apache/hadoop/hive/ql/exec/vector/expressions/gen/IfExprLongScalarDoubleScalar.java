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

import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import java.util.Arrays;

/**
 * Compute IF(expr1, expr2, expr3) for 3 input  expressions.
 * The first is always a boolean (LongColumnVector).
 * The second is a constant value.
 * The third is a constant value.
 */
public class IfExprLongScalarDoubleScalar extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int arg1Column;
  private final long arg2Scalar;
  private final double arg3Scalar;

  public IfExprLongScalarDoubleScalar(int arg1Column, long arg2Scalar, double arg3Scalar,
      int outputColumnNum) {
    super(outputColumnNum);
    this.arg1Column = arg1Column;
    this.arg2Scalar = arg2Scalar;
    this.arg3Scalar = arg3Scalar;
  }

  public IfExprLongScalarDoubleScalar() {
    super();

    // Dummy final assignments.
    arg1Column = -1;
    arg2Scalar = 0;
    arg3Scalar = 0;
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

    LongColumnVector arg1ColVector = (LongColumnVector) batch.cols[arg1Column];
    DoubleColumnVector outputColVector = (DoubleColumnVector) batch.cols[outputColumnNum];
    int[] sel = batch.selected;
    boolean[] outputIsNull = outputColVector.isNull;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    long[] vector1 = arg1ColVector.vector;
    double[] outputVector = outputColVector.vector;

    if (arg1ColVector.isRepeating) {
      if ((arg1ColVector.noNulls || !arg1ColVector.isNull[0]) && vector1[0] == 1) {
        outputColVector.fill(arg2Scalar);
      } else {
        outputColVector.fill(arg3Scalar);
      }
      return;
    }

    if (arg1ColVector.noNulls) {
      if (batch.selectedInUse) {

         // CONSIDER: For large n, fill n or all of isNull array and use the tighter ELSE loop.

         if (!outputColVector.noNulls) {
           for(int j = 0; j != n; j++) {
            final int i = sel[j];
            outputIsNull[i] = false;
            outputVector[i] = (vector1[i] == 1 ? arg2Scalar : arg3Scalar);
          }
         } else {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             outputVector[i] = (vector1[i] == 1 ? arg2Scalar : arg3Scalar);
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
          outputVector[i] = (vector1[i] == 1 ? arg2Scalar : arg3Scalar);
        }
      }
    } else /* there are NULLs in the inputColVector */ {

      // Carefully handle NULLs...

      /*
       * Since we always generate a result without NULLs, we can optimize this case similar to
       * the optimization above...
       */

      if (batch.selectedInUse) {

         // CONSIDER: For large n, fill n or all of isNull array and use the tighter ELSE loop.

         if (!outputColVector.noNulls) {
           for(int j = 0; j != n; j++) {
            final int i = sel[j];
            outputIsNull[i] = false;
            outputVector[i] = (!arg1ColVector.isNull[i] && vector1[i] == 1 ?
                arg2Scalar : arg3Scalar);
          }
         } else {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             outputVector[i] = (!arg1ColVector.isNull[i] && vector1[i] == 1 ?
                arg2Scalar : arg3Scalar);
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
          outputVector[i] = (!arg1ColVector.isNull[i] && vector1[i] == 1 ?
                arg2Scalar : arg3Scalar);
        }
      }
    }
  }

  @Override
  public String vectorExpressionParameters() {
    return getColumnParamString(0, arg1Column) + ", val "+ arg2Scalar + ", val "+ arg3Scalar;
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder())
        .setMode(
            VectorExpressionDescriptor.Mode.PROJECTION)
        .setNumArguments(3)
        .setArgumentTypes(
            VectorExpressionDescriptor.ArgumentType.getType("long"),
            VectorExpressionDescriptor.ArgumentType.getType("long"),
            VectorExpressionDescriptor.ArgumentType.getType("double"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.SCALAR,
            VectorExpressionDescriptor.InputExpressionType.SCALAR).build();
  }
}
