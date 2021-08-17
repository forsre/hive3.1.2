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
 * TestColumnColumnOperationVectorExpressionCheckedEvaluation.
 *
 */
public class TestColumnColumnOperationVectorExpressionCheckedEvaluation{

  private static final int BATCH_SIZE = 100;
  private static final long SEED = 0xfa57;

  
  @Test
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnC1NullsRetFloat() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnC1NullsRetDouble() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColAddIntervalYearMonthColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnC1NullsRetFloat() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnC1NullsRetDouble() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testIntervalYearMonthColSubtractIntervalYearMonthColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthColSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1NullsRetTinyInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsC1NullsC2NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1RepeatsC2NullsRetTinyInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutRepeatsC2RepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1NullsRetSmallInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsC1NullsC2NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1RepeatsC2NullsRetSmallInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutRepeatsC2RepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1NullsRetInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsC1NullsC2NullsRepeatsRetInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1NullsRepeatsRetInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1RepeatsC2NullsRetInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutRepeatsC2RepeatsRetInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetBigInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1NullsRetBigInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsC1NullsC2NullsRepeatsRetBigInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutNullsRepeatsC1NullsRepeatsRetBigInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnC1RepeatsC2NullsRetBigInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddLongColumnOutRepeatsC2RepeatsRetBigInt() throws HiveException {

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

    LongColAddLongColumn vectorExpression =
      new LongColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1NullsRetTinyInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsC1NullsC2NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1RepeatsC2NullsRetTinyInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutRepeatsC2RepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1NullsRetSmallInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsC1NullsC2NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1RepeatsC2NullsRetSmallInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutRepeatsC2RepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1NullsRetInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsC1NullsC2NullsRepeatsRetInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1NullsRepeatsRetInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1RepeatsC2NullsRetInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutRepeatsC2RepeatsRetInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1NullsRetBigInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsC1NullsC2NullsRepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutNullsRepeatsC1NullsRepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnC1RepeatsC2NullsRetBigInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractLongColumnOutRepeatsC2RepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongColumn vectorExpression =
      new LongColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1NullsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsC1NullsC2NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1NullsRepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1RepeatsC2NullsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutRepeatsC2RepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1NullsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsC1NullsC2NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1NullsRepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1RepeatsC2NullsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutRepeatsC2RepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1NullsRetInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsC1NullsC2NullsRepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1NullsRepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1RepeatsC2NullsRetInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutRepeatsC2RepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1NullsRetBigInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsC1NullsC2NullsRepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutNullsRepeatsC1NullsRepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnC1RepeatsC2NullsRetBigInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyLongColumnOutRepeatsC2RepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongColumn vectorExpression =
      new LongColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnC1NullsRetFloat() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnC1NullsRetDouble() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColAddDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleColumn vectorExpression =
      new LongColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnC1NullsRetFloat() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnC1NullsRetDouble() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColSubtractDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleColumn vectorExpression =
      new LongColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnC1NullsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnC1NullsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColMultiplyDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleColumn vectorExpression =
      new LongColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddLongColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongColumn vectorExpression =
      new DoubleColAddLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractLongColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongColumn vectorExpression =
      new DoubleColSubtractLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyLongColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongColumn vectorExpression =
      new DoubleColMultiplyLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColAddDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleColumn vectorExpression =
      new DoubleColAddDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColSubtractDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleColumn vectorExpression =
      new DoubleColSubtractDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColMultiplyDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleColumn vectorExpression =
      new DoubleColMultiplyDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnC1NullsRetFloat() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnC1NullsRetDouble() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColDivideDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    LongColDivideDoubleColumn vectorExpression =
      new LongColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideLongColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColDivideLongColumn vectorExpression =
      new DoubleColDivideLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColDivideDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColDivideDoubleColumn vectorExpression =
      new DoubleColDivideDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnC1NullsRetFloat() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnC1NullsRetDouble() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testLongColModuloDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleColumn vectorExpression =
      new LongColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloLongColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongColumn vectorExpression =
      new DoubleColModuloLongColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnC1NullsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutNullsC1NullsC2NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutNullsRepeatsC1NullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnC1RepeatsC2NullsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutRepeatsC2RepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutNullsRepeatsC1RepeatsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnC1NullsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutNullsC1NullsC2NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutNullsRepeatsC1NullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnC1RepeatsC2NullsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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
  public void testDoubleColModuloDoubleColumnOutRepeatsC2RepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleColumn vectorExpression =
      new DoubleColModuloDoubleColumn(0, 1, 2);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
        "Output column vector repeating state does not match operand columns",
        (!inputColumnVector1.noNulls && inputColumnVector1.isRepeating)
        || (!inputColumnVector2.noNulls && inputColumnVector2.isRepeating)
        || inputColumnVector1.isRepeating && inputColumnVector2.isRepeating,
        outputColumnVector.isRepeating);

    assertEquals(
        "Output column vector no nulls state does not match operand columns",
        inputColumnVector1.noNulls && inputColumnVector2.noNulls, outputColumnVector.noNulls);

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


