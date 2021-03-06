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
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.StringExpr;
import org.apache.hadoop.hive.ql.exec.vector.BytesColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * This is a generated class to evaluate a == comparison on a vector of strings.
 * Do not edit the generated code directly. 
 */
public abstract class StringGroupScalarEqualStringGroupColumnBase extends VectorExpression {

  private static final long serialVersionUID = 1L;

  protected final int colNum;
  protected final byte[] value;

  public StringGroupScalarEqualStringGroupColumnBase(int colNum, byte[] value, int outputColumnNum) {
    super(outputColumnNum);
    this.colNum = colNum;
    this.value = value;
  }

  public StringGroupScalarEqualStringGroupColumnBase() {
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
    BytesColumnVector inputColVector = (BytesColumnVector) batch.cols[colNum];
    LongColumnVector outputColVector = (LongColumnVector) batch.cols[outputColumnNum];
    int[] sel = batch.selected;
    boolean[] inputIsNull = inputColVector.isNull;
    boolean[] outputIsNull = outputColVector.isNull;

    byte[][] vector = inputColVector.vector;
    int[] length = inputColVector.length;
    int[] start = inputColVector.start;
    long[] outVector = outputColVector.vector;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    if (inputColVector.noNulls) {

      if (inputColVector.isRepeating) {
        outputColVector.isRepeating = true;
        outputIsNull[0] = false;
        if (StringExpr.equal(value, 0, value.length, vector[0], start[0], length[0])) {
          outVector[0] = 1;
        } else {
          outVector[0] = 0;
        }
      } else if (batch.selectedInUse) {
        for(int j=0; j != n; j++) {
          int i = sel[j];
          outputIsNull[i] = false;
          if (StringExpr.equal(value, 0, value.length, vector[i], start[i], length[i])) {
            outVector[i] = 1;
          } else {
            outVector[i] = 0;
          }
        }
      } else {
        Arrays.fill(outputIsNull, 0, n, false);
        for(int i = 0; i != n; i++) {
          if (StringExpr.equal(value, 0, value.length, vector[i], start[i], length[i])) {
            outVector[i] = 1;
          } else {
            outVector[i] = 0;
          }
        }
      }
    } else {

      // Carefully handle NULLs...
      outputColVector.noNulls = false;

      if (inputColVector.isRepeating) {
        outputColVector.isRepeating = true;
        outputIsNull[0] = inputIsNull[0];
        if (!inputIsNull[0]) {
          if (StringExpr.equal(value, 0, value.length, vector[0], start[0], length[0])) {
            outVector[0] = 1;
          } else {
            outVector[0] = 0;
          }
        } 
      } else if (batch.selectedInUse) {
        for(int j=0; j != n; j++) {
          int i = sel[j];
          outputIsNull[i] = inputIsNull[i];
          if (!inputIsNull[i]) {
            if (StringExpr.equal(value, 0, value.length, vector[i], start[i], length[i])) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        }
      } else {
        System.arraycopy(inputIsNull, 0, outputIsNull, 0, n);
        for(int i = 0; i != n; i++) {
          if (!inputIsNull[i]) {
            if (StringExpr.equal(value, 0, value.length, vector[i], start[i], length[i])) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        }
      }
    }
  }

  @Override
  public String vectorExpressionParameters() {
    return "val " + displayUtf8Bytes(value) + ", " + getColumnParamString(1, colNum);
  }
}
