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

import java.nio.charset.StandardCharsets;

import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.StringExpr;
import org.apache.hadoop.hive.ql.exec.vector.BytesColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * This is a generated class to evaluate a == comparison on a vector of strings.
 */
public abstract class FilterStringGroupColEqualStringGroupScalarBase extends VectorExpression {

  private static final long serialVersionUID = 1L;

  protected final int colNum;
  protected final byte[] value;

  public FilterStringGroupColEqualStringGroupScalarBase(int colNum, byte[] value) {
    super();
    this.colNum = colNum;
    this.value = value;
  }

  public FilterStringGroupColEqualStringGroupScalarBase() {
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
    int[] sel = batch.selected;
    boolean[] inputIsNull = inputColVector.isNull;

    byte[][] vector = inputColVector.vector;
    int[] length = inputColVector.length;
    int[] start = inputColVector.start;

    if (inputColVector.noNulls) {
      if (inputColVector.isRepeating) {
        if (!(StringExpr.equal(vector[0], start[0], length[0], value, 0, value.length))) {

          //Entire batch is filtered out.
          batch.size = 0;
        }
      } else if (batch.selectedInUse) {
        int newSize = 0;
        for(int j=0; j != n; j++) {
          int i = sel[j];
          if (StringExpr.equal(vector[i], start[i], length[i], value, 0, value.length)) {
            sel[newSize++] = i;
          }
        }
        batch.size = newSize;
      } else {
        int newSize = 0;
        for(int i = 0; i != n; i++) {
          if (StringExpr.equal(vector[i], start[i], length[i], value, 0, value.length)) {
            sel[newSize++] = i;
          }
        }
        if (newSize < n) {
          batch.size = newSize;
          batch.selectedInUse = true;
        }
      }
    } else {
      if (inputColVector.isRepeating) {
        if (!inputIsNull[0]) {
          if (!(StringExpr.equal(vector[0], start[0], length[0], value, 0, value.length))) {

            //Entire batch is filtered out.
            batch.size = 0;
          }
        } else {
          batch.size = 0;
        }
      } else if (batch.selectedInUse) {
        int newSize = 0;
        for(int j=0; j != n; j++) {
          int i = sel[j];
          if (!inputIsNull[i]) {
           if (StringExpr.equal(vector[i], start[i], length[i], value, 0, value.length)) {
             sel[newSize++] = i;
           }
          }
        }

        //Change the selected vector
        batch.size = newSize;
      } else {
        int newSize = 0;
        for(int i = 0; i != n; i++) {
          if (!inputIsNull[i]) {
            if (StringExpr.equal(vector[i], start[i], length[i], value, 0, value.length)) {
              sel[newSize++] = i;
            }
          }
        }
        if (newSize < n) {
          batch.size = newSize;
          batch.selectedInUse = true;
        }
      }
    }
  }

  @Override
  public String vectorExpressionParameters() {
    return getColumnParamString(0, colNum) + ", val " + displayUtf8Bytes(value);
  }

}
