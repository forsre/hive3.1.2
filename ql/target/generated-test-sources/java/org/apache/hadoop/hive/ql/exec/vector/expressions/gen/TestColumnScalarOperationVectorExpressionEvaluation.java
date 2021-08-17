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
 * TestColumnScalarOperationVectorExpressionEvaluation.
 *
 */
public class TestColumnScalarOperationVectorExpressionEvaluation{

  private static final int BATCH_SIZE = 100;
  private static final long SEED = 0xfa57;

  
  @Test
  public void testIntervalYearMonthColAddIntervalYearMonthScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColAddIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColAddIntervalYearMonthScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColAddIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColAddIntervalYearMonthScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColAddIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColAddIntervalYearMonthScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColAddIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColAddIntervalYearMonthScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColAddIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColAddIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColSubtractIntervalYearMonthScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColSubtractIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColSubtractIntervalYearMonthScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColSubtractIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColSubtractIntervalYearMonthScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColSubtractIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColSubtractIntervalYearMonthScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColSubtractIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthColSubtractIntervalYearMonthScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    IntervalYearMonthColSubtractIntervalYearMonthScalar vectorExpression =
      new IntervalYearMonthColSubtractIntervalYearMonthScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColAddLongScalar vectorExpression =
      new LongColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColAddLongScalar vectorExpression =
      new LongColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColAddLongScalar vectorExpression =
      new LongColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColAddLongScalar vectorExpression =
      new LongColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColAddLongScalar vectorExpression =
      new LongColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColSubtractLongScalar vectorExpression =
      new LongColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColSubtractLongScalar vectorExpression =
      new LongColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColSubtractLongScalar vectorExpression =
      new LongColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColSubtractLongScalar vectorExpression =
      new LongColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColSubtractLongScalar vectorExpression =
      new LongColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColMultiplyLongScalar vectorExpression =
      new LongColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColMultiplyLongScalar vectorExpression =
      new LongColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColMultiplyLongScalar vectorExpression =
      new LongColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColMultiplyLongScalar vectorExpression =
      new LongColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColMultiplyLongScalar vectorExpression =
      new LongColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColAddDoubleScalar vectorExpression =
      new LongColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColAddDoubleScalar vectorExpression =
      new LongColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColAddDoubleScalar vectorExpression =
      new LongColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColAddDoubleScalar vectorExpression =
      new LongColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColAddDoubleScalar vectorExpression =
      new LongColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColSubtractDoubleScalar vectorExpression =
      new LongColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColSubtractDoubleScalar vectorExpression =
      new LongColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColSubtractDoubleScalar vectorExpression =
      new LongColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColSubtractDoubleScalar vectorExpression =
      new LongColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColSubtractDoubleScalar vectorExpression =
      new LongColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColMultiplyDoubleScalar vectorExpression =
      new LongColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColMultiplyDoubleScalar vectorExpression =
      new LongColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColMultiplyDoubleScalar vectorExpression =
      new LongColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColMultiplyDoubleScalar vectorExpression =
      new LongColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColMultiplyDoubleScalar vectorExpression =
      new LongColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColAddLongScalar vectorExpression =
      new DoubleColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColAddLongScalar vectorExpression =
      new DoubleColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColAddLongScalar vectorExpression =
      new DoubleColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColAddLongScalar vectorExpression =
      new DoubleColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColAddLongScalar vectorExpression =
      new DoubleColAddLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColSubtractLongScalar vectorExpression =
      new DoubleColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColSubtractLongScalar vectorExpression =
      new DoubleColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColSubtractLongScalar vectorExpression =
      new DoubleColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColSubtractLongScalar vectorExpression =
      new DoubleColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColSubtractLongScalar vectorExpression =
      new DoubleColSubtractLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColMultiplyLongScalar vectorExpression =
      new DoubleColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColMultiplyLongScalar vectorExpression =
      new DoubleColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColMultiplyLongScalar vectorExpression =
      new DoubleColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColMultiplyLongScalar vectorExpression =
      new DoubleColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColMultiplyLongScalar vectorExpression =
      new DoubleColMultiplyLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColAddDoubleScalar vectorExpression =
      new DoubleColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColAddDoubleScalar vectorExpression =
      new DoubleColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColAddDoubleScalar vectorExpression =
      new DoubleColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColAddDoubleScalar vectorExpression =
      new DoubleColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColAddDoubleScalar vectorExpression =
      new DoubleColAddDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColSubtractDoubleScalar vectorExpression =
      new DoubleColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColSubtractDoubleScalar vectorExpression =
      new DoubleColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColSubtractDoubleScalar vectorExpression =
      new DoubleColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColSubtractDoubleScalar vectorExpression =
      new DoubleColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColSubtractDoubleScalar vectorExpression =
      new DoubleColSubtractDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColMultiplyDoubleScalar vectorExpression =
      new DoubleColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColMultiplyDoubleScalar vectorExpression =
      new DoubleColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColMultiplyDoubleScalar vectorExpression =
      new DoubleColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColMultiplyDoubleScalar vectorExpression =
      new DoubleColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColMultiplyDoubleScalar vectorExpression =
      new DoubleColMultiplyDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddLongColumnChecked vectorExpression =
      new LongScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddLongColumnChecked vectorExpression =
      new LongScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddLongColumnChecked vectorExpression =
      new LongScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddLongColumnChecked vectorExpression =
      new LongScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddLongColumnChecked vectorExpression =
      new LongScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractLongColumnChecked vectorExpression =
      new LongScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractLongColumnChecked vectorExpression =
      new LongScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractLongColumnChecked vectorExpression =
      new LongScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractLongColumnChecked vectorExpression =
      new LongScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractLongColumnChecked vectorExpression =
      new LongScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyLongColumnChecked vectorExpression =
      new LongScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyLongColumnChecked vectorExpression =
      new LongScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyLongColumnChecked vectorExpression =
      new LongScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyLongColumnChecked vectorExpression =
      new LongScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyLongColumnChecked vectorExpression =
      new LongScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddDoubleColumnChecked vectorExpression =
      new LongScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddDoubleColumnChecked vectorExpression =
      new LongScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddDoubleColumnChecked vectorExpression =
      new LongScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddDoubleColumnChecked vectorExpression =
      new LongScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarAddDoubleColumnChecked vectorExpression =
      new LongScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractDoubleColumnChecked vectorExpression =
      new LongScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractDoubleColumnChecked vectorExpression =
      new LongScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractDoubleColumnChecked vectorExpression =
      new LongScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractDoubleColumnChecked vectorExpression =
      new LongScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarSubtractDoubleColumnChecked vectorExpression =
      new LongScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyDoubleColumnChecked vectorExpression =
      new LongScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyDoubleColumnChecked vectorExpression =
      new LongScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyDoubleColumnChecked vectorExpression =
      new LongScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyDoubleColumnChecked vectorExpression =
      new LongScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarMultiplyDoubleColumnChecked vectorExpression =
      new LongScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddLongColumnChecked vectorExpression =
      new DoubleScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddLongColumnChecked vectorExpression =
      new DoubleScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddLongColumnChecked vectorExpression =
      new DoubleScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddLongColumnChecked vectorExpression =
      new DoubleScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddLongColumnChecked vectorExpression =
      new DoubleScalarAddLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractLongColumnChecked vectorExpression =
      new DoubleScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractLongColumnChecked vectorExpression =
      new DoubleScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractLongColumnChecked vectorExpression =
      new DoubleScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractLongColumnChecked vectorExpression =
      new DoubleScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractLongColumnChecked vectorExpression =
      new DoubleScalarSubtractLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyLongColumnChecked vectorExpression =
      new DoubleScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyLongColumnChecked vectorExpression =
      new DoubleScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyLongColumnChecked vectorExpression =
      new DoubleScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyLongColumnChecked vectorExpression =
      new DoubleScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyLongColumnChecked vectorExpression =
      new DoubleScalarMultiplyLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddDoubleColumnChecked vectorExpression =
      new DoubleScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddDoubleColumnChecked vectorExpression =
      new DoubleScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddDoubleColumnChecked vectorExpression =
      new DoubleScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddDoubleColumnChecked vectorExpression =
      new DoubleScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarAddDoubleColumnChecked vectorExpression =
      new DoubleScalarAddDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractDoubleColumnChecked vectorExpression =
      new DoubleScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractDoubleColumnChecked vectorExpression =
      new DoubleScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractDoubleColumnChecked vectorExpression =
      new DoubleScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractDoubleColumnChecked vectorExpression =
      new DoubleScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarSubtractDoubleColumnChecked vectorExpression =
      new DoubleScalarSubtractDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyDoubleColumnChecked vectorExpression =
      new DoubleScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyDoubleColumnChecked vectorExpression =
      new DoubleScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyDoubleColumnChecked vectorExpression =
      new DoubleScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyDoubleColumnChecked vectorExpression =
      new DoubleScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarMultiplyDoubleColumnChecked vectorExpression =
      new DoubleScalarMultiplyDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColDivideDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColDivideDoubleScalar vectorExpression =
      new LongColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColDivideDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColDivideDoubleScalar vectorExpression =
      new LongColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColDivideDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColDivideDoubleScalar vectorExpression =
      new LongColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColDivideDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColDivideDoubleScalar vectorExpression =
      new LongColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColDivideDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColDivideDoubleScalar vectorExpression =
      new LongColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColDivideLongScalar vectorExpression =
      new DoubleColDivideLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColDivideLongScalar vectorExpression =
      new DoubleColDivideLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColDivideLongScalar vectorExpression =
      new DoubleColDivideLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColDivideLongScalar vectorExpression =
      new DoubleColDivideLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColDivideLongScalar vectorExpression =
      new DoubleColDivideLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColDivideDoubleScalar vectorExpression =
      new DoubleColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColDivideDoubleScalar vectorExpression =
      new DoubleColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColDivideDoubleScalar vectorExpression =
      new DoubleColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColDivideDoubleScalar vectorExpression =
      new DoubleColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColDivideDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColDivideDoubleScalar vectorExpression =
      new DoubleColDivideDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColModuloLongScalar vectorExpression =
      new LongColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColModuloLongScalar vectorExpression =
      new LongColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColModuloLongScalar vectorExpression =
      new LongColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColModuloLongScalar vectorExpression =
      new LongColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongColModuloLongScalar vectorExpression =
      new LongColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColModuloDoubleScalar vectorExpression =
      new LongColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColModuloDoubleScalar vectorExpression =
      new LongColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColModuloDoubleScalar vectorExpression =
      new LongColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColModuloDoubleScalar vectorExpression =
      new LongColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColModuloDoubleScalar vectorExpression =
      new LongColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColModuloLongScalar vectorExpression =
      new DoubleColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColModuloLongScalar vectorExpression =
      new DoubleColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColModuloLongScalar vectorExpression =
      new DoubleColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColModuloLongScalar vectorExpression =
      new DoubleColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColModuloLongScalar vectorExpression =
      new DoubleColModuloLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColModuloDoubleScalar vectorExpression =
      new DoubleColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColModuloDoubleScalar vectorExpression =
      new DoubleColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColModuloDoubleScalar vectorExpression =
      new DoubleColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColModuloDoubleScalar vectorExpression =
      new DoubleColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColModuloDoubleScalar vectorExpression =
      new DoubleColModuloDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloLongColumnChecked vectorExpression =
      new LongScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloLongColumnChecked vectorExpression =
      new LongScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloLongColumnChecked vectorExpression =
      new LongScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloLongColumnChecked vectorExpression =
      new LongScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloLongColumnChecked vectorExpression =
      new LongScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloDoubleColumnChecked vectorExpression =
      new LongScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloDoubleColumnChecked vectorExpression =
      new LongScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloDoubleColumnChecked vectorExpression =
      new LongScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloDoubleColumnChecked vectorExpression =
      new LongScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarModuloDoubleColumnChecked vectorExpression =
      new LongScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloLongColumnChecked vectorExpression =
      new DoubleScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloLongColumnChecked vectorExpression =
      new DoubleScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloLongColumnChecked vectorExpression =
      new DoubleScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloLongColumnChecked vectorExpression =
      new DoubleScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloLongColumnChecked vectorExpression =
      new DoubleScalarModuloLongColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnCheckedOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloDoubleColumnChecked vectorExpression =
      new DoubleScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnChecked() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloDoubleColumnChecked vectorExpression =
      new DoubleScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnCheckedOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloDoubleColumnChecked vectorExpression =
      new DoubleScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnCheckedOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloDoubleColumnChecked vectorExpression =
      new DoubleScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnCheckedOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    DoubleColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarModuloDoubleColumnChecked vectorExpression =
      new DoubleScalarModuloDoubleColumnChecked(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColEqualDoubleScalar vectorExpression =
      new LongColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColEqualDoubleScalar vectorExpression =
      new LongColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColEqualDoubleScalar vectorExpression =
      new LongColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColEqualDoubleScalar vectorExpression =
      new LongColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColEqualDoubleScalar vectorExpression =
      new LongColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColEqualDoubleScalar vectorExpression =
      new DoubleColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColEqualDoubleScalar vectorExpression =
      new DoubleColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColEqualDoubleScalar vectorExpression =
      new DoubleColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColEqualDoubleScalar vectorExpression =
      new DoubleColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColEqualDoubleScalar vectorExpression =
      new DoubleColEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColNotEqualDoubleScalar vectorExpression =
      new LongColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColNotEqualDoubleScalar vectorExpression =
      new LongColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColNotEqualDoubleScalar vectorExpression =
      new LongColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColNotEqualDoubleScalar vectorExpression =
      new LongColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColNotEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColNotEqualDoubleScalar vectorExpression =
      new LongColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColNotEqualDoubleScalar vectorExpression =
      new DoubleColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColNotEqualDoubleScalar vectorExpression =
      new DoubleColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColNotEqualDoubleScalar vectorExpression =
      new DoubleColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColNotEqualDoubleScalar vectorExpression =
      new DoubleColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColNotEqualDoubleScalar vectorExpression =
      new DoubleColNotEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessDoubleScalar vectorExpression =
      new LongColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessDoubleScalar vectorExpression =
      new LongColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessDoubleScalar vectorExpression =
      new LongColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessDoubleScalar vectorExpression =
      new LongColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessDoubleScalar vectorExpression =
      new LongColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessDoubleScalar vectorExpression =
      new DoubleColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessDoubleScalar vectorExpression =
      new DoubleColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessDoubleScalar vectorExpression =
      new DoubleColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessDoubleScalar vectorExpression =
      new DoubleColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessDoubleScalar vectorExpression =
      new DoubleColLessDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessEqualDoubleScalar vectorExpression =
      new LongColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessEqualDoubleScalar vectorExpression =
      new LongColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessEqualDoubleScalar vectorExpression =
      new LongColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessEqualDoubleScalar vectorExpression =
      new LongColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColLessEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColLessEqualDoubleScalar vectorExpression =
      new LongColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessEqualDoubleScalar vectorExpression =
      new DoubleColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessEqualDoubleScalar vectorExpression =
      new DoubleColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessEqualDoubleScalar vectorExpression =
      new DoubleColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessEqualDoubleScalar vectorExpression =
      new DoubleColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColLessEqualDoubleScalar vectorExpression =
      new DoubleColLessEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterDoubleScalar vectorExpression =
      new LongColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterDoubleScalar vectorExpression =
      new LongColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterDoubleScalar vectorExpression =
      new LongColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterDoubleScalar vectorExpression =
      new LongColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterDoubleScalar vectorExpression =
      new LongColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterDoubleScalar vectorExpression =
      new DoubleColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterDoubleScalar vectorExpression =
      new DoubleColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterDoubleScalar vectorExpression =
      new DoubleColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterDoubleScalar vectorExpression =
      new DoubleColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterDoubleScalar vectorExpression =
      new DoubleColGreaterDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterEqualDoubleScalar vectorExpression =
      new LongColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterEqualDoubleScalar vectorExpression =
      new LongColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterEqualDoubleScalar vectorExpression =
      new LongColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterEqualDoubleScalar vectorExpression =
      new LongColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColGreaterEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    LongColGreaterEqualDoubleScalar vectorExpression =
      new LongColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterEqualDoubleScalar vectorExpression =
      new DoubleColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterEqualDoubleScalar vectorExpression =
      new DoubleColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterEqualDoubleScalar vectorExpression =
      new DoubleColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterEqualDoubleScalar vectorExpression =
      new DoubleColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualDoubleScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleColGreaterEqualDoubleScalar vectorExpression =
      new DoubleColGreaterEqualDoubleScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColEqualLongScalar vectorExpression =
      new DoubleColEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColEqualLongScalar vectorExpression =
      new DoubleColEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColEqualLongScalar vectorExpression =
      new DoubleColEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColEqualLongScalar vectorExpression =
      new DoubleColEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColEqualLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColEqualLongScalar vectorExpression =
      new DoubleColEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColNotEqualLongScalar vectorExpression =
      new DoubleColNotEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColNotEqualLongScalar vectorExpression =
      new DoubleColNotEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColNotEqualLongScalar vectorExpression =
      new DoubleColNotEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColNotEqualLongScalar vectorExpression =
      new DoubleColNotEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColNotEqualLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColNotEqualLongScalar vectorExpression =
      new DoubleColNotEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessLongScalar vectorExpression =
      new DoubleColLessLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessLongScalar vectorExpression =
      new DoubleColLessLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessLongScalar vectorExpression =
      new DoubleColLessLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessLongScalar vectorExpression =
      new DoubleColLessLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessLongScalar vectorExpression =
      new DoubleColLessLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessEqualLongScalar vectorExpression =
      new DoubleColLessEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessEqualLongScalar vectorExpression =
      new DoubleColLessEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessEqualLongScalar vectorExpression =
      new DoubleColLessEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessEqualLongScalar vectorExpression =
      new DoubleColLessEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColLessEqualLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColLessEqualLongScalar vectorExpression =
      new DoubleColLessEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterLongScalar vectorExpression =
      new DoubleColGreaterLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterLongScalar vectorExpression =
      new DoubleColGreaterLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterLongScalar vectorExpression =
      new DoubleColGreaterLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterLongScalar vectorExpression =
      new DoubleColGreaterLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterLongScalar vectorExpression =
      new DoubleColGreaterLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongScalarOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterEqualLongScalar vectorExpression =
      new DoubleColGreaterEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongScalar() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterEqualLongScalar vectorExpression =
      new DoubleColGreaterEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongScalarOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterEqualLongScalar vectorExpression =
      new DoubleColGreaterEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongScalarOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterEqualLongScalar vectorExpression =
      new DoubleColGreaterEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColGreaterEqualLongScalarOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    DoubleColGreaterEqualLongScalar vectorExpression =
      new DoubleColGreaterEqualLongScalar(0, scalarValue, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarEqualDoubleColumn vectorExpression =
      new LongScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarEqualDoubleColumn vectorExpression =
      new LongScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarEqualDoubleColumn vectorExpression =
      new LongScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarEqualDoubleColumn vectorExpression =
      new LongScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarEqualDoubleColumn vectorExpression =
      new LongScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualDoubleColumn vectorExpression =
      new DoubleScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualDoubleColumn vectorExpression =
      new DoubleScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualDoubleColumn vectorExpression =
      new DoubleScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualDoubleColumn vectorExpression =
      new DoubleScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualDoubleColumn vectorExpression =
      new DoubleScalarEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarNotEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarNotEqualDoubleColumn vectorExpression =
      new LongScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarNotEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarNotEqualDoubleColumn vectorExpression =
      new LongScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarNotEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarNotEqualDoubleColumn vectorExpression =
      new LongScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarNotEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarNotEqualDoubleColumn vectorExpression =
      new LongScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarNotEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarNotEqualDoubleColumn vectorExpression =
      new LongScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualDoubleColumn vectorExpression =
      new DoubleScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualDoubleColumn vectorExpression =
      new DoubleScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualDoubleColumn vectorExpression =
      new DoubleScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualDoubleColumn vectorExpression =
      new DoubleScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualDoubleColumn vectorExpression =
      new DoubleScalarNotEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessDoubleColumn vectorExpression =
      new LongScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessDoubleColumn vectorExpression =
      new LongScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessDoubleColumn vectorExpression =
      new LongScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessDoubleColumn vectorExpression =
      new LongScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessDoubleColumn vectorExpression =
      new LongScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessDoubleColumn vectorExpression =
      new DoubleScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessDoubleColumn vectorExpression =
      new DoubleScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessDoubleColumn vectorExpression =
      new DoubleScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessDoubleColumn vectorExpression =
      new DoubleScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessDoubleColumn vectorExpression =
      new DoubleScalarLessDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessEqualDoubleColumn vectorExpression =
      new LongScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessEqualDoubleColumn vectorExpression =
      new LongScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessEqualDoubleColumn vectorExpression =
      new LongScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessEqualDoubleColumn vectorExpression =
      new LongScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarLessEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarLessEqualDoubleColumn vectorExpression =
      new LongScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualDoubleColumn vectorExpression =
      new DoubleScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualDoubleColumn vectorExpression =
      new DoubleScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualDoubleColumn vectorExpression =
      new DoubleScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualDoubleColumn vectorExpression =
      new DoubleScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualDoubleColumn vectorExpression =
      new DoubleScalarLessEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterDoubleColumn vectorExpression =
      new LongScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterDoubleColumn vectorExpression =
      new LongScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterDoubleColumn vectorExpression =
      new LongScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterDoubleColumn vectorExpression =
      new LongScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterDoubleColumn vectorExpression =
      new LongScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterDoubleColumn vectorExpression =
      new DoubleScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterDoubleColumn vectorExpression =
      new DoubleScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterDoubleColumn vectorExpression =
      new DoubleScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterDoubleColumn vectorExpression =
      new DoubleScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterDoubleColumn vectorExpression =
      new DoubleScalarGreaterDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterEqualDoubleColumn vectorExpression =
      new LongScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterEqualDoubleColumn vectorExpression =
      new LongScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterEqualDoubleColumn vectorExpression =
      new LongScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterEqualDoubleColumn vectorExpression =
      new LongScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarGreaterEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    long scalarValue = 0;
    do {
      scalarValue = rand.nextLong();
    } while(scalarValue == 0);

    LongScalarGreaterEqualDoubleColumn vectorExpression =
      new LongScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualDoubleColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new DoubleScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualDoubleColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new DoubleScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualDoubleColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new DoubleScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualDoubleColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new DoubleScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualDoubleColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    DoubleColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateDoubleColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualDoubleColumn vectorExpression =
      new DoubleScalarGreaterEqualDoubleColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualLongColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualLongColumn vectorExpression =
      new DoubleScalarEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualLongColumn vectorExpression =
      new DoubleScalarEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualLongColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualLongColumn vectorExpression =
      new DoubleScalarEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualLongColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualLongColumn vectorExpression =
      new DoubleScalarEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarEqualLongColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarEqualLongColumn vectorExpression =
      new DoubleScalarEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualLongColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualLongColumn vectorExpression =
      new DoubleScalarNotEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualLongColumn vectorExpression =
      new DoubleScalarNotEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualLongColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualLongColumn vectorExpression =
      new DoubleScalarNotEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualLongColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualLongColumn vectorExpression =
      new DoubleScalarNotEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarNotEqualLongColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarNotEqualLongColumn vectorExpression =
      new DoubleScalarNotEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessLongColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessLongColumn vectorExpression =
      new DoubleScalarLessLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessLongColumn vectorExpression =
      new DoubleScalarLessLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessLongColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessLongColumn vectorExpression =
      new DoubleScalarLessLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessLongColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessLongColumn vectorExpression =
      new DoubleScalarLessLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessLongColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessLongColumn vectorExpression =
      new DoubleScalarLessLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualLongColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualLongColumn vectorExpression =
      new DoubleScalarLessEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualLongColumn vectorExpression =
      new DoubleScalarLessEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualLongColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualLongColumn vectorExpression =
      new DoubleScalarLessEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualLongColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualLongColumn vectorExpression =
      new DoubleScalarLessEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarLessEqualLongColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarLessEqualLongColumn vectorExpression =
      new DoubleScalarLessEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterLongColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterLongColumn vectorExpression =
      new DoubleScalarGreaterLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterLongColumn vectorExpression =
      new DoubleScalarGreaterLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterLongColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterLongColumn vectorExpression =
      new DoubleScalarGreaterLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterLongColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterLongColumn vectorExpression =
      new DoubleScalarGreaterLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterLongColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterLongColumn vectorExpression =
      new DoubleScalarGreaterLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualLongColumnOutRepeatsColNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualLongColumn vectorExpression =
      new DoubleScalarGreaterEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualLongColumn() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualLongColumn vectorExpression =
      new DoubleScalarGreaterEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualLongColumnOutNullsColNulls() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualLongColumn vectorExpression =
      new DoubleScalarGreaterEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualLongColumnOutNullsRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      true, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      false, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualLongColumn vectorExpression =
      new DoubleScalarGreaterEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarGreaterEqualLongColumnOutNullsColRepeats() throws HiveException {

    Random rand = new Random(SEED);

    LongColumnVector outputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(true,
      false, BATCH_SIZE, rand);

    LongColumnVector inputColumnVector =
      VectorizedRowGroupGenUtil.generateLongColumnVector(false,
      true, BATCH_SIZE, rand);

    VectorizedRowBatch rowBatch = new VectorizedRowBatch(2, BATCH_SIZE);
    rowBatch.cols[0] = inputColumnVector;
    rowBatch.cols[1] = outputColumnVector;

    double scalarValue = 0;
    do {
      scalarValue = rand.nextDouble();
    } while(scalarValue == 0);

    DoubleScalarGreaterEqualLongColumn vectorExpression =
      new DoubleScalarGreaterEqualLongColumn(scalarValue, 0, 1);

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
     */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }


}


