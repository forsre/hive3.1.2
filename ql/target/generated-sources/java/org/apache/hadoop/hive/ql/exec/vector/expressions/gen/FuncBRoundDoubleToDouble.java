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

import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.MathExpr;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.metadata.HiveException;

public class FuncBRoundDoubleToDouble extends VectorExpression {
  private static final long serialVersionUID = 1L;

  private final int colNum;

  public FuncBRoundDoubleToDouble(int colNum, int outputColumnNum) {
    super(outputColumnNum);
    this.colNum = colNum;
  }

  public FuncBRoundDoubleToDouble() {
    super();

    // Dummy final assignments.
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
      this.evaluateChildren(batch);
    }

    DoubleColumnVector inputColVector = (DoubleColumnVector) batch.cols[colNum];
    DoubleColumnVector outputColVector = (DoubleColumnVector) batch.cols[outputColumnNum];
    int[] sel = batch.selected;
    boolean[] inputIsNull = inputColVector.isNull;
    boolean[] outputIsNull = outputColVector.isNull;

    double[] vector = inputColVector.vector;
    double[] outputVector = outputColVector.vector;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    if (inputColVector.isRepeating) {
      if (inputColVector.noNulls || !inputIsNull[0]) {
        outputIsNull[0] = false;
        outputVector[0] =  MathExpr.bround( vector[0]);
      } else {
        outputIsNull[0] = true;
        outputColVector.noNulls = false;
      }
      outputColVector.isRepeating = true;
      
      return;
    }

    if (inputColVector.noNulls) {
      if (batch.selectedInUse) {

         // CONSIDER: For large n, fill n or all of isNull array and use the tighter ELSE loop.

         if (!outputColVector.noNulls) {
           for(int j = 0; j != n; j++) {
            final int i = sel[j];
            outputIsNull[i] = false;
            outputVector[i] =  MathExpr.bround( vector[i]);
          }
         } else {
           for(int j = 0; j != n; j++) {
             final int i = sel[j];
             outputVector[i] =  MathExpr.bround( vector[i]);
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
          outputVector[i] =  MathExpr.bround( vector[i]);
        }
      }
    } else /* there are NULLs in the inputColVector */ {

      // Carefully handle NULLs...

      /*
       * For better performance on LONG/DOUBLE we don't want the conditional
       * statements inside the for loop.
       */
      outputColVector.noNulls = false;

      if (batch.selectedInUse) {
        for(int j=0; j != n; j++) {
          int i = sel[j];
          outputIsNull[i] = inputIsNull[i];
          outputVector[i] =  MathExpr.bround( vector[i]);
        }
      } else {
        System.arraycopy(inputIsNull, 0, outputIsNull, 0, n);
        for(int i = 0; i != n; i++) {
          outputVector[i] =  MathExpr.bround( vector[i]);
        }
      }
    }
    
  }

  @Override
  public String vectorExpressionParameters() {
    return getColumnParamString(0, colNum);
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder())
        .setMode(
            VectorExpressionDescriptor.Mode.PROJECTION)
        .setNumArguments(1)
        .setArgumentTypes(
            VectorExpressionDescriptor.ArgumentType.getType("double"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}
