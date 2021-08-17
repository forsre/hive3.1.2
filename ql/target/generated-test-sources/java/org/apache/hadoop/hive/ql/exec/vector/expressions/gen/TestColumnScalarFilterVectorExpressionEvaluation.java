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

import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.util.VectorizedRowGroupGenUtil;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.junit.Test;
import org.apache.hadoop.hive.ql.metadata.HiveException;

/**
 *
 * TestColumnScalarFilterVectorExpressionEvaluation.
 *
 */
public class TestColumnScalarFilterVectorExpressionEvaluation{

  private static final int BATCH_SIZE = 100;
  private static final long SEED = 0xfa57;

  
  @Test
  public void testFilterLongColEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColEqualDoubleScalar vectorExpression =
      new FilterLongColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColEqualDoubleScalar vectorExpression =
      new FilterLongColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColEqualDoubleScalar vectorExpression =
      new FilterLongColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColEqualDoubleScalar vectorExpression =
      new FilterLongColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColEqualDoubleScalar vectorExpression =
      new FilterDoubleColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColEqualDoubleScalar vectorExpression =
      new FilterDoubleColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColEqualDoubleScalar vectorExpression =
      new FilterDoubleColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColEqualDoubleScalar vectorExpression =
      new FilterDoubleColEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColNotEqualDoubleScalar vectorExpression =
      new FilterLongColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColNotEqualDoubleScalar vectorExpression =
      new FilterLongColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColNotEqualDoubleScalar vectorExpression =
      new FilterLongColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColNotEqualDoubleScalar vectorExpression =
      new FilterLongColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualDoubleScalar vectorExpression =
      new FilterDoubleColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualDoubleScalar vectorExpression =
      new FilterDoubleColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualDoubleScalar vectorExpression =
      new FilterDoubleColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualDoubleScalar vectorExpression =
      new FilterDoubleColNotEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessDoubleScalar vectorExpression =
      new FilterLongColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessDoubleScalar vectorExpression =
      new FilterLongColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessDoubleScalar vectorExpression =
      new FilterLongColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessDoubleScalar vectorExpression =
      new FilterLongColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessDoubleScalar vectorExpression =
      new FilterDoubleColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessDoubleScalar vectorExpression =
      new FilterDoubleColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessDoubleScalar vectorExpression =
      new FilterDoubleColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessDoubleScalar vectorExpression =
      new FilterDoubleColLessDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessEqualDoubleScalar vectorExpression =
      new FilterLongColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessEqualDoubleScalar vectorExpression =
      new FilterLongColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessEqualDoubleScalar vectorExpression =
      new FilterLongColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColLessEqualDoubleScalar vectorExpression =
      new FilterLongColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualDoubleScalar vectorExpression =
      new FilterDoubleColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualDoubleScalar vectorExpression =
      new FilterDoubleColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualDoubleScalar vectorExpression =
      new FilterDoubleColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualDoubleScalar vectorExpression =
      new FilterDoubleColLessEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterDoubleScalar vectorExpression =
      new FilterLongColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterDoubleScalar vectorExpression =
      new FilterLongColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterDoubleScalar vectorExpression =
      new FilterLongColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterDoubleScalar vectorExpression =
      new FilterLongColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterDoubleScalar vectorExpression =
      new FilterDoubleColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterDoubleScalar vectorExpression =
      new FilterDoubleColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterDoubleScalar vectorExpression =
      new FilterDoubleColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterDoubleScalar vectorExpression =
      new FilterDoubleColGreaterDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualDoubleScalar vectorExpression =
      new FilterLongColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualDoubleScalar vectorExpression =
      new FilterLongColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualDoubleScalar vectorExpression =
      new FilterLongColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualDoubleScalar vectorExpression =
      new FilterLongColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualDoubleScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualDoubleScalar vectorExpression =
      new FilterDoubleColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualDoubleScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualDoubleScalar vectorExpression =
      new FilterDoubleColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualDoubleScalar vectorExpression =
      new FilterDoubleColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualDoubleScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualDoubleScalar vectorExpression =
      new FilterDoubleColGreaterEqualDoubleScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColEqualLongScalar vectorExpression =
      new FilterLongColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColEqualLongScalar vectorExpression =
      new FilterLongColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColEqualLongScalar vectorExpression =
      new FilterLongColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColEqualLongScalar vectorExpression =
      new FilterLongColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColEqualLongScalar vectorExpression =
      new FilterDoubleColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColEqualLongScalar vectorExpression =
      new FilterDoubleColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColEqualLongScalar vectorExpression =
      new FilterDoubleColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColEqualLongScalar vectorExpression =
      new FilterDoubleColEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] == scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] == scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "=="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColNotEqualLongScalar vectorExpression =
      new FilterLongColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColNotEqualLongScalar vectorExpression =
      new FilterLongColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColNotEqualLongScalar vectorExpression =
      new FilterLongColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColNotEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColNotEqualLongScalar vectorExpression =
      new FilterLongColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualLongScalar vectorExpression =
      new FilterDoubleColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualLongScalar vectorExpression =
      new FilterDoubleColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualLongScalar vectorExpression =
      new FilterDoubleColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColNotEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColNotEqualLongScalar vectorExpression =
      new FilterDoubleColNotEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] != scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] != scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "!="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessLongScalar vectorExpression =
      new FilterLongColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessLongScalar vectorExpression =
      new FilterLongColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessLongScalar vectorExpression =
      new FilterLongColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessLongScalar vectorExpression =
      new FilterLongColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessLongScalar vectorExpression =
      new FilterDoubleColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessLongScalar vectorExpression =
      new FilterDoubleColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessLongScalar vectorExpression =
      new FilterDoubleColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessLongScalar vectorExpression =
      new FilterDoubleColLessLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] < scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] < scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessEqualLongScalar vectorExpression =
      new FilterLongColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessEqualLongScalar vectorExpression =
      new FilterLongColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessEqualLongScalar vectorExpression =
      new FilterLongColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColLessEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColLessEqualLongScalar vectorExpression =
      new FilterLongColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualLongScalar vectorExpression =
      new FilterDoubleColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualLongScalar vectorExpression =
      new FilterDoubleColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualLongScalar vectorExpression =
      new FilterDoubleColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColLessEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColLessEqualLongScalar vectorExpression =
      new FilterDoubleColLessEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] <= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] <= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + "<="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterLongScalar vectorExpression =
      new FilterLongColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterLongScalar vectorExpression =
      new FilterLongColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterLongScalar vectorExpression =
      new FilterLongColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterLongScalar vectorExpression =
      new FilterLongColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterLongScalar vectorExpression =
      new FilterDoubleColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterLongScalar vectorExpression =
      new FilterDoubleColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterLongScalar vectorExpression =
      new FilterDoubleColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterLongScalar vectorExpression =
      new FilterDoubleColGreaterLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] > scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] > scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">"
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualLongScalar vectorExpression =
      new FilterLongColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualLongScalar vectorExpression =
      new FilterLongColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualLongScalar vectorExpression =
      new FilterLongColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongColGreaterEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongColGreaterEqualLongScalar vectorExpression =
      new FilterLongColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualLongScalarColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualLongScalar vectorExpression =
      new FilterDoubleColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualLongScalarColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualLongScalar vectorExpression =
      new FilterDoubleColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualLongScalar vectorExpression =
      new FilterDoubleColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleColGreaterEqualLongScalarColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterDoubleColGreaterEqualLongScalar vectorExpression =
      new FilterDoubleColGreaterEqualLongScalar(0, scalarValue);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && inputColumnVector.vector[i] >= scalarValue
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(inputColumnVector.vector[i] >= scalarValue) {
            assertEquals(
              "Vector index that passes filter "
              + inputColumnVector.vector[i] + ">="
              + scalarValue + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualDoubleColumn vectorExpression =
      new FilterLongScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualDoubleColumn vectorExpression =
      new FilterLongScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualDoubleColumn vectorExpression =
      new FilterLongScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualDoubleColumn vectorExpression =
      new FilterLongScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualDoubleColumn vectorExpression =
      new FilterLongScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualDoubleColumn vectorExpression =
      new FilterLongScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualDoubleColumn vectorExpression =
      new FilterLongScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualDoubleColumn vectorExpression =
      new FilterLongScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarNotEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessDoubleColumn vectorExpression =
      new FilterLongScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessDoubleColumn vectorExpression =
      new FilterLongScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessDoubleColumn vectorExpression =
      new FilterLongScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessDoubleColumn vectorExpression =
      new FilterLongScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessDoubleColumn vectorExpression =
      new FilterDoubleScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessDoubleColumn vectorExpression =
      new FilterDoubleScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessDoubleColumn vectorExpression =
      new FilterDoubleScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessDoubleColumn vectorExpression =
      new FilterDoubleScalarLessDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualDoubleColumn vectorExpression =
      new FilterLongScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualDoubleColumn vectorExpression =
      new FilterLongScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualDoubleColumn vectorExpression =
      new FilterLongScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualDoubleColumn vectorExpression =
      new FilterLongScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarLessEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterDoubleColumn vectorExpression =
      new FilterLongScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterDoubleColumn vectorExpression =
      new FilterLongScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterDoubleColumn vectorExpression =
      new FilterLongScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterDoubleColumn vectorExpression =
      new FilterLongScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterLongScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterLongScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterLongScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterLongScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualDoubleColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualDoubleColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualDoubleColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualDoubleColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualLongColumn vectorExpression =
      new FilterLongScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualLongColumn vectorExpression =
      new FilterLongScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualLongColumn vectorExpression =
      new FilterLongScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarEqualLongColumn vectorExpression =
      new FilterLongScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualLongColumn vectorExpression =
      new FilterDoubleScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualLongColumn vectorExpression =
      new FilterDoubleScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualLongColumn vectorExpression =
      new FilterDoubleScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarEqualLongColumn vectorExpression =
      new FilterDoubleScalarEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue == inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue == inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "=="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualLongColumn vectorExpression =
      new FilterLongScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualLongColumn vectorExpression =
      new FilterLongScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualLongColumn vectorExpression =
      new FilterLongScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarNotEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarNotEqualLongColumn vectorExpression =
      new FilterLongScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualLongColumn vectorExpression =
      new FilterDoubleScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualLongColumn vectorExpression =
      new FilterDoubleScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualLongColumn vectorExpression =
      new FilterDoubleScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarNotEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarNotEqualLongColumn vectorExpression =
      new FilterDoubleScalarNotEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue != inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue != inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "!="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessLongColumn vectorExpression =
      new FilterLongScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessLongColumn vectorExpression =
      new FilterLongScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessLongColumn vectorExpression =
      new FilterLongScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessLongColumn vectorExpression =
      new FilterLongScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessLongColumn vectorExpression =
      new FilterDoubleScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessLongColumn vectorExpression =
      new FilterDoubleScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessLongColumn vectorExpression =
      new FilterDoubleScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessLongColumn vectorExpression =
      new FilterDoubleScalarLessLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue < inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue < inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualLongColumn vectorExpression =
      new FilterLongScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualLongColumn vectorExpression =
      new FilterLongScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualLongColumn vectorExpression =
      new FilterLongScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarLessEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarLessEqualLongColumn vectorExpression =
      new FilterLongScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualLongColumn vectorExpression =
      new FilterDoubleScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualLongColumn vectorExpression =
      new FilterDoubleScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualLongColumn vectorExpression =
      new FilterDoubleScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarLessEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarLessEqualLongColumn vectorExpression =
      new FilterDoubleScalarLessEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue <= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue <= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + "<="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterLongColumn vectorExpression =
      new FilterLongScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterLongColumn vectorExpression =
      new FilterLongScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterLongColumn vectorExpression =
      new FilterLongScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterLongColumn vectorExpression =
      new FilterLongScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterLongColumn vectorExpression =
      new FilterDoubleScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterLongColumn vectorExpression =
      new FilterDoubleScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterLongColumn vectorExpression =
      new FilterDoubleScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterLongColumn vectorExpression =
      new FilterDoubleScalarGreaterLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue > inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue > inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">"
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualLongColumn vectorExpression =
      new FilterLongScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualLongColumn vectorExpression =
      new FilterLongScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualLongColumn vectorExpression =
      new FilterLongScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterLongScalarGreaterEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    FilterLongScalarGreaterEqualLongColumn vectorExpression =
      new FilterLongScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualLongColumnColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualLongColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualLongColumnColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualLongColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualLongColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }

  @Test
  public void testFilterDoubleScalarGreaterEqualLongColumnColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(1, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    FilterDoubleScalarGreaterEqualLongColumn vectorExpression =
      new FilterDoubleScalarGreaterEqualLongColumn(scalarValue, 0);

    vectorExpression.evaluate(rowBatch);

    
    int selectedIndex = 0;
    int i=0;
    //check for isRepeating optimization
    if(inputColumnVector.isRepeating) {
      //null vector is safe to check, as it is always initialized to match the data vector
      selectedIndex =
        !inputColumnVector.isNull[i] && scalarValue >= inputColumnVector.vector[i]
          ? BATCH_SIZE : 0;
    } else {
      for(i = 0; i < BATCH_SIZE; i++) {
        if(!inputColumnVector.isNull[i]) {
          if(scalarValue >= inputColumnVector.vector[i]) {
            assertEquals(
              "Vector index that passes filter "
              + scalarValue + ">="
              + inputColumnVector.vector[i] + " is not in rowBatch selected index",
              i,
              rowBatch.selected[selectedIndex]);
            selectedIndex++;
          }
        }
      }
    }

    assertEquals("Row batch size not set to number of selected rows: " + selectedIndex,
      selectedIndex, rowBatch.size);

    if(selectedIndex > 0 && selectedIndex < BATCH_SIZE) {
      assertEquals(
        "selectedInUse should be set when > 0 and < entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        true, rowBatch.selectedInUse);
    } else if(selectedIndex == BATCH_SIZE) {
      assertEquals(
        "selectedInUse should not be set when entire batch(" + BATCH_SIZE + ") is selected: "
        + selectedIndex,
        false, rowBatch.selectedInUse);
    }
  }


}


