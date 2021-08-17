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
 * TestColumnScalarOperationVectorExpressionCheckedEvaluation.
 *
 */
public class TestColumnScalarOperationVectorExpressionCheckedEvaluation{

  private static final int BATCH_SIZE = 100;
  private static final long SEED = 0xfa57;

  
  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnRetFloat() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutNullsColNullsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnRetDouble() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutNullsColNullsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarAddIntervalYearMonthColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarAddIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarAddIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnRetFloat() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutNullsColNullsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnRetDouble() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutNullsColNullsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testIntervalYearMonthScalarSubtractIntervalYearMonthColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    IntervalYearMonthScalarSubtractIntervalYearMonthColumn vectorExpression =
      new IntervalYearMonthScalarSubtractIntervalYearMonthColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedRetTinyInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedRetSmallInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedRetInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColNullsRetInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsRepeatsRetInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColRepeatsRetInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedRetBigInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColNullsRetBigInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddLongScalarCheckedOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongColAddLongScalarChecked vectorExpression =
      new LongColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedRetTinyInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedRetSmallInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedRetInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColNullsRetInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsRepeatsRetInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColRepeatsRetInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedRetBigInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColNullsRetBigInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractLongScalarCheckedOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongColSubtractLongScalarChecked vectorExpression =
      new LongColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedRetTinyInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedRetSmallInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedRetInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColNullsRetInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsRepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColRepeatsRetInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedRetBigInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColNullsRetBigInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyLongScalarCheckedOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongColMultiplyLongScalarChecked vectorExpression =
      new LongColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedRetFloat() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedRetDouble() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColAddDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongColAddDoubleScalarChecked vectorExpression =
      new LongColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedRetFloat() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedRetDouble() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColSubtractDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongColSubtractDoubleScalarChecked vectorExpression =
      new LongColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedRetFloat() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedRetDouble() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColMultiplyDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongColMultiplyDoubleScalarChecked vectorExpression =
      new LongColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedRetFloat() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedRetDouble() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddLongScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColAddLongScalarChecked vectorExpression =
      new DoubleColAddLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedRetFloat() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedRetDouble() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractLongScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractLongScalarChecked vectorExpression =
      new DoubleColSubtractLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedRetFloat() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedRetDouble() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyLongScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyLongScalarChecked vectorExpression =
      new DoubleColMultiplyLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedRetFloat() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedRetDouble() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColAddDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColAddDoubleScalarChecked vectorExpression =
      new DoubleColAddDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColSubtractDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColSubtractDoubleScalarChecked vectorExpression =
      new DoubleColSubtractDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColMultiplyDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColMultiplyDoubleScalarChecked vectorExpression =
      new DoubleColMultiplyDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnRetTinyInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnRetSmallInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnRetInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColNullsRetInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsRepeatsRetInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColRepeatsRetInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnRetBigInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColNullsRetBigInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddLongColumnOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongScalarAddLongColumn vectorExpression =
      new LongScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnRetTinyInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnRetSmallInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnRetInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColNullsRetInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsRepeatsRetInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColRepeatsRetInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnRetBigInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColNullsRetBigInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractLongColumnOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongScalarSubtractLongColumn vectorExpression =
      new LongScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnRetTinyInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnRetSmallInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnRetInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColNullsRetInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsRepeatsRetInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColRepeatsRetInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnRetBigInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColNullsRetBigInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyLongColumnOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongScalarMultiplyLongColumn vectorExpression =
      new LongScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnRetFloat() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnRetDouble() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarAddDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongScalarAddDoubleColumn vectorExpression =
      new LongScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnRetFloat() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnRetDouble() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarSubtractDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongScalarSubtractDoubleColumn vectorExpression =
      new LongScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnRetFloat() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnRetDouble() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarMultiplyDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongScalarMultiplyDoubleColumn vectorExpression =
      new LongScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnRetFloat() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnRetDouble() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddLongColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarAddLongColumn vectorExpression =
      new DoubleScalarAddLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnRetFloat() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnRetDouble() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractLongColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarSubtractLongColumn vectorExpression =
      new DoubleScalarSubtractLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnRetFloat() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnRetDouble() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyLongColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyLongColumn vectorExpression =
      new DoubleScalarMultiplyLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnRetFloat() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnRetDouble() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarAddDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarAddDoubleColumn vectorExpression =
      new DoubleScalarAddDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnRetFloat() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnRetDouble() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarSubtractDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarSubtractDoubleColumn vectorExpression =
      new DoubleScalarSubtractDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnRetFloat() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnRetDouble() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarMultiplyDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarMultiplyDoubleColumn vectorExpression =
      new DoubleScalarMultiplyDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnRetFloat() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnRetDouble() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarDivideDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongScalarDivideDoubleColumn vectorExpression =
      new LongScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnRetFloat() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnRetDouble() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideLongColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarDivideLongColumn vectorExpression =
      new DoubleScalarDivideLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnRetFloat() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnRetDouble() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarDivideDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarDivideDoubleColumn vectorExpression =
      new DoubleScalarDivideDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedRetTinyInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedRetSmallInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedRetInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColNullsRetInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsRepeatsRetInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColRepeatsRetInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedRetBigInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColNullsRetBigInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloLongScalarCheckedOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongColModuloLongScalarChecked vectorExpression =
      new LongColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedRetFloat() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedRetDouble() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongColModuloDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongColModuloDoubleScalarChecked vectorExpression =
      new LongColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedRetFloat() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedRetDouble() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloLongScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloLongScalarChecked vectorExpression =
      new DoubleColModuloLongScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedRetFloat() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedRetDouble() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleColModuloDoubleScalarCheckedOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleColModuloDoubleScalarChecked vectorExpression =
      new DoubleColModuloDoubleScalarChecked(0, scalarValue, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutRepeatsColNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnRetTinyInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColNullsRetTinyInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsRepeatsRetTinyInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColRepeatsRetTinyInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("tinyint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutRepeatsColNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnRetSmallInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColNullsRetSmallInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsRepeatsRetSmallInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColRepeatsRetSmallInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("smallint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutRepeatsColNullsRepeatsRetInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnRetInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColNullsRetInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsRepeatsRetInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColRepeatsRetInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("int"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutRepeatsColNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnRetBigInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColNullsRetBigInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsRepeatsRetBigInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloLongColumnOutNullsColRepeatsRetBigInt() throws HiveException {

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

    LongScalarModuloLongColumn vectorExpression =
      new LongScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("bigint"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnRetFloat() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnRetDouble() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testLongScalarModuloDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    LongScalarModuloDoubleColumn vectorExpression =
      new LongScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnRetFloat() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnRetDouble() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloLongColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarModuloLongColumn vectorExpression =
      new DoubleScalarModuloLongColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutRepeatsColNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnRetFloat() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutNullsColNullsRetFloat() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutNullsRepeatsRetFloat() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutNullsColRepeatsRetFloat() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("float"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutRepeatsColNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnRetDouble() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutNullsColNullsRetDouble() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutNullsRepeatsRetDouble() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
    */

    if(!outputColumnVector.noNulls && !outputColumnVector.isRepeating) {
      for(int i = 0; i < BATCH_SIZE; i++) {
        //null vectors are safe to check, as they are always initialized to match the data vector
        assertEquals("Output vector doesn't match input vector's is null state for index",
          inputColumnVector.isNull[i], outputColumnVector.isNull[i]);
      }
    }
  }

  @Test
  public void testDoubleScalarModuloDoubleColumnOutNullsColRepeatsRetDouble() throws HiveException {

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

    DoubleScalarModuloDoubleColumn vectorExpression =
      new DoubleScalarModuloDoubleColumn(scalarValue, 0, 1);
    vectorExpression.setOutputTypeInfo(TypeInfoFactory.getPrimitiveTypeInfo("double"));

    vectorExpression.evaluate(rowBatch);

    assertEquals(
      "Output column vector is repeating state does not match operand column",
      inputColumnVector.isRepeating, outputColumnVector.isRepeating);

    /*
     We no longer set noNulls to the input ColumnVector's value since that doesn't work
     for scratch column reuse.
    assertEquals(
      "Output column vector no nulls state does not match operand column",
      inputColumnVector.noNulls, outputColumnVector.noNulls);
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


