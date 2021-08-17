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

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.expressions.gen.FilterLongColumnBetween;
import org.apache.hadoop.hive.ql.plan.DynamicValue;
import org.apache.hadoop.hive.serde2.io.DateWritableV2;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import org.apache.hadoop.hive.common.type.HiveChar;
import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.common.type.HiveVarchar;
import org.apache.hadoop.hive.ql.metadata.HiveException;

public class FilterLongColumnBetweenDynamicValue extends FilterLongColumnBetween {

  private static final long serialVersionUID = 1L;

  private static final Logger LOG = LoggerFactory.getLogger(FilterLongColumnBetweenDynamicValue.class);

  protected final DynamicValue leftDynamicValue;
  protected final DynamicValue rightDynamicValue;

  // Transient members initialized by transientInit method.
  protected transient boolean initialized;
  protected transient boolean isLeftOrRightNull;

  public FilterLongColumnBetweenDynamicValue(int colNum, DynamicValue leftValue, DynamicValue rightValue) {
    super(colNum, 0, 0);
    this.leftDynamicValue = leftValue;
    this.rightDynamicValue = rightValue;
  }

  public FilterLongColumnBetweenDynamicValue() {
    super();

    // Dummy final assignments.
    leftDynamicValue = null;
    rightDynamicValue = null;
  }

  @Override
  public void transientInit() throws HiveException {
    super.transientInit();

    initialized = false;
    isLeftOrRightNull = false;
  }

  public DynamicValue getLeftDynamicValue() {
    return leftDynamicValue;
  }

  public DynamicValue getRightDynamicValue() {
    return rightDynamicValue;
  }

  @Override
  public void init(Configuration conf) {
    super.init(conf);
    leftDynamicValue.setConf(conf);
    rightDynamicValue.setConf(conf);
  }

  @Override
  public void evaluate(VectorizedRowBatch batch) throws HiveException {
    if (!initialized) {
      Object lVal = leftDynamicValue.getValue();
      Object rVal = rightDynamicValue.getValue();
      if (lVal == null || rVal == null) {
        isLeftOrRightNull = true;
      } else {
        long min = (PrimitiveObjectInspectorUtils.getLong(
            lVal, leftDynamicValue.getObjectInspector()));
        setLeftValue(min);

        long max = (PrimitiveObjectInspectorUtils.getLong(
            rVal, rightDynamicValue.getObjectInspector()));
        setRightValue(max);
      }
      initialized = true;
    }

    // Special case for dynamic values - min/max can be null
    if (isLeftOrRightNull) {
      // Entire batch is filtered out
      batch.size = 0;
    }

    super.evaluate(batch);
  }
}
