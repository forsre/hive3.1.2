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
import org.apache.hadoop.hive.ql.exec.vector.expressions.StringExpr;
import org.apache.hadoop.hive.ql.exec.vector.BytesColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 * Filter the rows in a batch by comparing one string column to another. 
 * This code is generated from a template.
 */
public class StringGroupColGreaterStringGroupColumn extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private final int colNum1;
  private final int colNum2;

  public StringGroupColGreaterStringGroupColumn(int colNum1, int colNum2, int outputColumnNum) {
    super(outputColumnNum);
    this.colNum1 = colNum1;
    this.colNum2 = colNum2;
  }

  public StringGroupColGreaterStringGroupColumn() {
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

    BytesColumnVector inputColVector1 = (BytesColumnVector) batch.cols[colNum1];
    BytesColumnVector inputColVector2 = (BytesColumnVector) batch.cols[colNum2];
    LongColumnVector outputColVector = (LongColumnVector) batch.cols[outputColumnNum];
    int[] sel = batch.selected;
    boolean[] nullPos1 = inputColVector1.isNull;
    boolean[] nullPos2 = inputColVector2.isNull;
    boolean[] outputIsNull = outputColVector.isNull;

    byte[][] vector1 = inputColVector1.vector;
    byte[][] vector2 = inputColVector2.vector;
    int[] start1 = inputColVector1.start;
    int[] start2 = inputColVector2.start;
    int[] length1 = inputColVector1.length;
    int[] length2 = inputColVector2.length;

    long[] outVector = outputColVector.vector;

    // We do not need to do a column reset since we are carefully changing the output.
    outputColVector.isRepeating = false;

    // handle case where neither input has nulls
    if (inputColVector1.noNulls && inputColVector2.noNulls) {

      if (inputColVector1.isRepeating && inputColVector2.isRepeating) {
        outputColVector.isRepeating = true;
        outputIsNull[0] = false;
        int ret = StringExpr.compare(vector1[0], start1[0], length1[0],
                                         vector2[0], start2[0], length2[0]);
        if (ret> 0) {
          outVector[0] = 1;
        } else {
          outVector[0] = 0;
        }
      } else if (inputColVector1.isRepeating) {
        if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = false;
            if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                   vector2[i], start2[i], length2[i])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        } else {
          Arrays.fill(outputIsNull, 0, n, false);
          for(int i = 0; i != n; i++) {
            if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                   vector2[i], start2[i], length2[i])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        }
      } else if (inputColVector2.isRepeating) {
        if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = false;
            if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                   vector2[0], start2[0], length2[0])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        } else {
          Arrays.fill(outputIsNull, 0, n, false);
          for(int i = 0; i != n; i++) {
            if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                   vector2[0], start2[0], length2[0])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        }
      } else if (batch.selectedInUse) {
        for(int j = 0; j != n; j++) {
          int i = sel[j];
          outputIsNull[i] = false;
          if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                 vector2[i], start2[i], length2[i])> 0) {
            outVector[i] = 1;
          } else {
            outVector[i] = 0;
          }
        }
      } else {
        Arrays.fill(outputIsNull, 0, n, false);
        for(int i = 0; i != n; i++) {
          if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                 vector2[i], start2[i], length2[i])> 0) {
            outVector[i] = 1;
          } else {
            outVector[i] = 0;
          }
        }
      }

    // handle case where only input 2 has nulls
    } else if (inputColVector1.noNulls) {

      // Carefully handle NULLs...
      outputColVector.noNulls = false;

      if (inputColVector1.isRepeating && inputColVector2.isRepeating) {
        outputColVector.isRepeating = true;
        outputIsNull[0] = nullPos2[0];
        if (!nullPos2[0]) {
          if (StringExpr.compare(vector1[0], start1[0], length1[0],
                               vector2[0], start2[0], length2[0])> 0) {
            outVector[0] = 1;
          } else {
            outVector[0] = 0;
          }
        } 
      } else if (inputColVector1.isRepeating) {
          
         // no need to check for nulls in input 1
         if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos2[i];
            if (!nullPos2[i]) {
              if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos2[i];
            if (!nullPos2[i]) {
              if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            } 
          }
        }
      } else if (inputColVector2.isRepeating) {
        if (nullPos2[0]) {
          // Entire output vector will be null
          outputColVector.isRepeating = true;
          outputIsNull[0] = true;
          return;
        }
        if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = false;
            if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                   vector2[0], start2[0], length2[0])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = false;
            if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                   vector2[0], start2[0], length2[0])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        }
      } else { // neither input is repeating
        if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos2[i];
            if (!nullPos2[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos2[i];
            if (!nullPos2[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        }
      }

    // handle case where only input 1 has nulls
    } else if (inputColVector2.noNulls) {

      // Carefully handle NULLs...
      outputColVector.noNulls = false;

      if (inputColVector1.isRepeating && inputColVector2.isRepeating) {
        outputColVector.isRepeating = true;
        outputIsNull[0] = nullPos1[0];
        if (!nullPos1[0]) {
          if (StringExpr.compare(vector1[0], start1[0], length1[0],
                               vector2[0], start2[0], length2[0])> 0) {
            outVector[0] = 1;
          } else {
            outVector[0] = 0;
          }
        } 
      } else if (inputColVector1.isRepeating) {
        if (nullPos1[0]) {
          // Entire output vector will be null
          outputColVector.isRepeating = true;
          outputIsNull[0] = true;
          return; 
        }
        if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = false;
            if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                   vector2[i], start2[i], length2[i])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = false;
            if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                   vector2[i], start2[i], length2[i])> 0) {
              outVector[i] = 1;
            } else {
              outVector[i] = 0;
            }
          }
        }
      } else if (inputColVector2.isRepeating) {
         if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos1[i];
            if (!nullPos1[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[0], start2[0], length2[0])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos1[i];
            if (!nullPos1[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[0], start2[0], length2[0])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        }
      } else { // neither input is repeating
         if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos1[i];
            if (!nullPos1[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos1[i];
            if (!nullPos1[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        }
      }

    // handle case where both inputs have nulls
    } else {

      // Carefully handle NULLs...
      outputColVector.noNulls = false;

      if (inputColVector1.isRepeating && inputColVector2.isRepeating) {
        outputColVector.isRepeating = true;
        outputIsNull[0] = nullPos1[0] || nullPos2[0];
        if (!outputIsNull[0]) {
          if (StringExpr.compare(vector1[0], start1[0], length1[0],
                             vector2[0], start2[0], length2[0])> 0) {
            outVector[0] = 1;
          } else {
            outVector[0] = 0;
          }
        } 
      } else if (inputColVector1.isRepeating) {
         if (nullPos1[0]) {
           outputColVector.isRepeating = true;
           outputIsNull[0] = true;
           return;
         }
         if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos2[i];
            if (!nullPos2[i]) {
              if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos2[i];
            if (!nullPos2[i]) {
              if (StringExpr.compare(vector1[0], start1[0], length1[0],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        }
      } else if (inputColVector2.isRepeating) {
        if (nullPos2[0]) {
          outputColVector.isRepeating = true;
          outputIsNull[0] = true;
          return;
        }
        if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos1[i];
            if (!nullPos1[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[0], start2[0], length2[0])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos1[i];
            if (!nullPos1[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[0], start2[0], length2[0])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        }
      } else { // neither input is repeating
         if (batch.selectedInUse) {
          for(int j = 0; j != n; j++) {
            int i = sel[j];
            outputIsNull[i] = nullPos1[i] || nullPos2[i];
            if (!outputIsNull[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        } else {
          for(int i = 0; i != n; i++) {
            outputIsNull[i] = nullPos1[i] || nullPos2[i];
            if (!outputIsNull[i]) {
              if (StringExpr.compare(vector1[i], start1[i], length1[i],
                                     vector2[i], start2[i], length2[i])> 0) {
                outVector[i] = 1;
              } else {
                outVector[i] = 0;
              }
            }
          }
        }
      }
    }
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
            VectorExpressionDescriptor.ArgumentType.STRING_FAMILY,
            VectorExpressionDescriptor.ArgumentType.STRING_FAMILY)
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.COLUMN).build();
  }
}
