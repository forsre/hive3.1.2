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
 * TestColumnColumnOperationVectorExpressionEvaluation.
 *
 */
public class TestColumnColumnOperationVectorExpressionEvaluation{

  private static final int BATCH_SIZE = 100;
  private static final long SEED = 0xfa57;

  
  @Test
  public void testLongColAddLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddLongColumnChecked vectorExpression =
      new LongColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddLongColumnChecked vectorExpression =
      new LongColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddLongColumnChecked vectorExpression =
      new LongColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddLongColumnChecked vectorExpression =
      new LongColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddLongColumnChecked vectorExpression =
      new LongColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddLongColumnChecked vectorExpression =
      new LongColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractLongColumnChecked vectorExpression =
      new LongColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractLongColumnChecked vectorExpression =
      new LongColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractLongColumnChecked vectorExpression =
      new LongColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractLongColumnChecked vectorExpression =
      new LongColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractLongColumnChecked vectorExpression =
      new LongColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractLongColumnChecked vectorExpression =
      new LongColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyLongColumnChecked vectorExpression =
      new LongColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyLongColumnChecked vectorExpression =
      new LongColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyLongColumnChecked vectorExpression =
      new LongColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyLongColumnChecked vectorExpression =
      new LongColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyLongColumnChecked vectorExpression =
      new LongColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyLongColumnChecked vectorExpression =
      new LongColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddDoubleColumnChecked vectorExpression =
      new LongColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddDoubleColumnChecked vectorExpression =
      new LongColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddDoubleColumnChecked vectorExpression =
      new LongColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddDoubleColumnChecked vectorExpression =
      new LongColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddDoubleColumnChecked vectorExpression =
      new LongColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColAddDoubleColumnChecked vectorExpression =
      new LongColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractDoubleColumnChecked vectorExpression =
      new LongColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractDoubleColumnChecked vectorExpression =
      new LongColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractDoubleColumnChecked vectorExpression =
      new LongColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractDoubleColumnChecked vectorExpression =
      new LongColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractDoubleColumnChecked vectorExpression =
      new LongColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColSubtractDoubleColumnChecked vectorExpression =
      new LongColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyDoubleColumnChecked vectorExpression =
      new LongColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyDoubleColumnChecked vectorExpression =
      new LongColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyDoubleColumnChecked vectorExpression =
      new LongColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyDoubleColumnChecked vectorExpression =
      new LongColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyDoubleColumnChecked vectorExpression =
      new LongColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColMultiplyDoubleColumnChecked vectorExpression =
      new LongColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddLongColumnChecked vectorExpression =
      new DoubleColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddLongColumnChecked vectorExpression =
      new DoubleColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddLongColumnChecked vectorExpression =
      new DoubleColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddLongColumnChecked vectorExpression =
      new DoubleColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddLongColumnChecked vectorExpression =
      new DoubleColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddLongColumnChecked vectorExpression =
      new DoubleColAddLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractLongColumnChecked vectorExpression =
      new DoubleColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractLongColumnChecked vectorExpression =
      new DoubleColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractLongColumnChecked vectorExpression =
      new DoubleColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractLongColumnChecked vectorExpression =
      new DoubleColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractLongColumnChecked vectorExpression =
      new DoubleColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractLongColumnChecked vectorExpression =
      new DoubleColSubtractLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyLongColumnChecked vectorExpression =
      new DoubleColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyLongColumnChecked vectorExpression =
      new DoubleColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyLongColumnChecked vectorExpression =
      new DoubleColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyLongColumnChecked vectorExpression =
      new DoubleColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyLongColumnChecked vectorExpression =
      new DoubleColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyLongColumnChecked vectorExpression =
      new DoubleColMultiplyLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddDoubleColumnChecked vectorExpression =
      new DoubleColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddDoubleColumnChecked vectorExpression =
      new DoubleColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddDoubleColumnChecked vectorExpression =
      new DoubleColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddDoubleColumnChecked vectorExpression =
      new DoubleColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddDoubleColumnChecked vectorExpression =
      new DoubleColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColAddDoubleColumnChecked vectorExpression =
      new DoubleColAddDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractDoubleColumnChecked vectorExpression =
      new DoubleColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractDoubleColumnChecked vectorExpression =
      new DoubleColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractDoubleColumnChecked vectorExpression =
      new DoubleColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractDoubleColumnChecked vectorExpression =
      new DoubleColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractDoubleColumnChecked vectorExpression =
      new DoubleColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColSubtractDoubleColumnChecked vectorExpression =
      new DoubleColSubtractDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyDoubleColumnChecked vectorExpression =
      new DoubleColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyDoubleColumnChecked vectorExpression =
      new DoubleColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyDoubleColumnChecked vectorExpression =
      new DoubleColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyDoubleColumnChecked vectorExpression =
      new DoubleColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyDoubleColumnChecked vectorExpression =
      new DoubleColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColMultiplyDoubleColumnChecked vectorExpression =
      new DoubleColMultiplyDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColModuloDoubleColumnChecked vectorExpression =
      new LongColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColModuloDoubleColumnChecked vectorExpression =
      new LongColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColModuloDoubleColumnChecked vectorExpression =
      new LongColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColModuloDoubleColumnChecked vectorExpression =
      new LongColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColModuloDoubleColumnChecked vectorExpression =
      new LongColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColModuloDoubleColumnChecked vectorExpression =
      new LongColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloLongColumnChecked vectorExpression =
      new DoubleColModuloLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloLongColumnChecked vectorExpression =
      new DoubleColModuloLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloLongColumnChecked vectorExpression =
      new DoubleColModuloLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloLongColumnChecked vectorExpression =
      new DoubleColModuloLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloLongColumnChecked vectorExpression =
      new DoubleColModuloLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloLongColumnChecked vectorExpression =
      new DoubleColModuloLongColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleColumnCheckedOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloDoubleColumnChecked vectorExpression =
      new DoubleColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleColumnCheckedC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloDoubleColumnChecked vectorExpression =
      new DoubleColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleColumnCheckedOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloDoubleColumnChecked vectorExpression =
      new DoubleColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleColumnCheckedOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloDoubleColumnChecked vectorExpression =
      new DoubleColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleColumnCheckedC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloDoubleColumnChecked vectorExpression =
      new DoubleColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleColumnCheckedOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColModuloDoubleColumnChecked vectorExpression =
      new DoubleColModuloDoubleColumnChecked(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColEqualDoubleColumn vectorExpression =
      new LongColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColEqualDoubleColumn vectorExpression =
      new LongColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColEqualDoubleColumn vectorExpression =
      new LongColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColEqualDoubleColumn vectorExpression =
      new LongColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColEqualDoubleColumn vectorExpression =
      new LongColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColEqualDoubleColumn vectorExpression =
      new LongColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualDoubleColumn vectorExpression =
      new DoubleColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualDoubleColumn vectorExpression =
      new DoubleColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualDoubleColumn vectorExpression =
      new DoubleColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualDoubleColumn vectorExpression =
      new DoubleColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualDoubleColumn vectorExpression =
      new DoubleColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualDoubleColumn vectorExpression =
      new DoubleColEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColNotEqualDoubleColumn vectorExpression =
      new LongColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColNotEqualDoubleColumn vectorExpression =
      new LongColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColNotEqualDoubleColumn vectorExpression =
      new LongColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColNotEqualDoubleColumn vectorExpression =
      new LongColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColNotEqualDoubleColumn vectorExpression =
      new LongColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColNotEqualDoubleColumn vectorExpression =
      new LongColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualDoubleColumn vectorExpression =
      new DoubleColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualDoubleColumn vectorExpression =
      new DoubleColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualDoubleColumn vectorExpression =
      new DoubleColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualDoubleColumn vectorExpression =
      new DoubleColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualDoubleColumn vectorExpression =
      new DoubleColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualDoubleColumn vectorExpression =
      new DoubleColNotEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessDoubleColumn vectorExpression =
      new LongColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessDoubleColumn vectorExpression =
      new LongColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessDoubleColumn vectorExpression =
      new LongColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessDoubleColumn vectorExpression =
      new LongColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessDoubleColumn vectorExpression =
      new LongColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessDoubleColumn vectorExpression =
      new LongColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessDoubleColumn vectorExpression =
      new DoubleColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessDoubleColumn vectorExpression =
      new DoubleColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessDoubleColumn vectorExpression =
      new DoubleColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessDoubleColumn vectorExpression =
      new DoubleColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessDoubleColumn vectorExpression =
      new DoubleColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessDoubleColumn vectorExpression =
      new DoubleColLessDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessEqualDoubleColumn vectorExpression =
      new LongColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessEqualDoubleColumn vectorExpression =
      new LongColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessEqualDoubleColumn vectorExpression =
      new LongColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessEqualDoubleColumn vectorExpression =
      new LongColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessEqualDoubleColumn vectorExpression =
      new LongColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColLessEqualDoubleColumn vectorExpression =
      new LongColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualDoubleColumn vectorExpression =
      new DoubleColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualDoubleColumn vectorExpression =
      new DoubleColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualDoubleColumn vectorExpression =
      new DoubleColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualDoubleColumn vectorExpression =
      new DoubleColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualDoubleColumn vectorExpression =
      new DoubleColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualDoubleColumn vectorExpression =
      new DoubleColLessEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterDoubleColumn vectorExpression =
      new LongColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterDoubleColumn vectorExpression =
      new LongColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterDoubleColumn vectorExpression =
      new LongColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterDoubleColumn vectorExpression =
      new LongColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterDoubleColumn vectorExpression =
      new LongColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterDoubleColumn vectorExpression =
      new LongColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterDoubleColumn vectorExpression =
      new DoubleColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterDoubleColumn vectorExpression =
      new DoubleColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterDoubleColumn vectorExpression =
      new DoubleColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterDoubleColumn vectorExpression =
      new DoubleColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterDoubleColumn vectorExpression =
      new DoubleColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterDoubleColumn vectorExpression =
      new DoubleColGreaterDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterEqualDoubleColumn vectorExpression =
      new LongColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterEqualDoubleColumn vectorExpression =
      new LongColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterEqualDoubleColumn vectorExpression =
      new LongColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterEqualDoubleColumn vectorExpression =
      new LongColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterEqualDoubleColumn vectorExpression =
      new LongColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    LongColGreaterEqualDoubleColumn vectorExpression =
      new LongColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualDoubleColumn vectorExpression =
      new DoubleColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualDoubleColumn vectorExpression =
      new DoubleColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualDoubleColumn vectorExpression =
      new DoubleColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualDoubleColumn vectorExpression =
      new DoubleColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualDoubleColumn vectorExpression =
      new DoubleColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualDoubleColumn vectorExpression =
      new DoubleColGreaterEqualDoubleColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualLongColumn vectorExpression =
      new DoubleColEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualLongColumn vectorExpression =
      new DoubleColEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualLongColumn vectorExpression =
      new DoubleColEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualLongColumn vectorExpression =
      new DoubleColEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualLongColumn vectorExpression =
      new DoubleColEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColEqualLongColumn vectorExpression =
      new DoubleColEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualLongColumn vectorExpression =
      new DoubleColNotEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualLongColumn vectorExpression =
      new DoubleColNotEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualLongColumn vectorExpression =
      new DoubleColNotEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualLongColumn vectorExpression =
      new DoubleColNotEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualLongColumn vectorExpression =
      new DoubleColNotEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColNotEqualLongColumn vectorExpression =
      new DoubleColNotEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessLongColumn vectorExpression =
      new DoubleColLessLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessLongColumn vectorExpression =
      new DoubleColLessLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessLongColumn vectorExpression =
      new DoubleColLessLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessLongColumn vectorExpression =
      new DoubleColLessLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessLongColumn vectorExpression =
      new DoubleColLessLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessLongColumn vectorExpression =
      new DoubleColLessLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualLongColumn vectorExpression =
      new DoubleColLessEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualLongColumn vectorExpression =
      new DoubleColLessEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualLongColumn vectorExpression =
      new DoubleColLessEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualLongColumn vectorExpression =
      new DoubleColLessEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualLongColumn vectorExpression =
      new DoubleColLessEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColLessEqualLongColumn vectorExpression =
      new DoubleColLessEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterLongColumn vectorExpression =
      new DoubleColGreaterLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterLongColumn vectorExpression =
      new DoubleColGreaterLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterLongColumn vectorExpression =
      new DoubleColGreaterLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterLongColumn vectorExpression =
      new DoubleColGreaterLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterLongColumn vectorExpression =
      new DoubleColGreaterLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterLongColumn vectorExpression =
      new DoubleColGreaterLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualLongColumn vectorExpression =
      new DoubleColGreaterEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongColumnC1Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualLongColumn vectorExpression =
      new DoubleColGreaterEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongColumnOutNullsC1NullsC2NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualLongColumn vectorExpression =
      new DoubleColGreaterEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongColumnOutNullsRepeatsC1NullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualLongColumn vectorExpression =
      new DoubleColGreaterEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongColumnC1RepeatsC2Nulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualLongColumn vectorExpression =
      new DoubleColGreaterEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongColumnOutRepeatsC2Repeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector1 =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector2 =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(3, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector1;
    rowBatch.cols[1] = inputColumnVector2;
    rowBatch.cols[2] = outputColumnVector;

    DoubleColGreaterEqualLongColumn vectorExpression =
      new DoubleColGreaterEqualLongColumn(0, 1, 2);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);
    */

    //if repeating, only the first value matters
    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vectors' is null state for index",
          inputColumnVector1.isNull[i] || inputColumnVector2.isNull[i],
          outputColumnVector.isNull[i]);
      }
    }
  }


}


