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


import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;

import org.apache.hadoop.hive.common.type.Date;
import org.apache.hadoop.hive.serde2.io.DateWritableV2;

/**
 * Generated from template DTIColumnCompareScalar.txt, which covers comparison
 * expressions between a datetime/interval column and a scalar of the same type. The boolean output
 * is stored in a separate boolean column.
 */
public class DateColGreaterEqualDateScalar extends org.apache.hadoop.hive.ql.exec.vector.expressions.LongColGreaterEqualLongScalar {

  private static final long serialVersionUID = 1L;

  public DateColGreaterEqualDateScalar(int colNum, long value, int outputColumnNum) {
    super(colNum, value, outputColumnNum);
  }

  public DateColGreaterEqualDateScalar() {
    super();
  }

  @Override
  public String vectorExpressionParameters() {
    Date dt = Date.ofEpochMilli(DateWritableV2.daysToMillis((int) value));
    return getColumnParamString(0, colNum) + ", date " + dt.toString();
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder())
        .setMode(
            VectorExpressionDescriptor.Mode.PROJECTION)
        .setNumArguments(2)
        .setArgumentTypes(
            VectorExpressionDescriptor.ArgumentType.getType("date"),
            VectorExpressionDescriptor.ArgumentType.getType("date"))
        .setInputExpressionTypes(
            VectorExpressionDescriptor.InputExpressionType.COLUMN,
            VectorExpressionDescriptor.InputExpressionType.SCALAR).build();
  }
}
