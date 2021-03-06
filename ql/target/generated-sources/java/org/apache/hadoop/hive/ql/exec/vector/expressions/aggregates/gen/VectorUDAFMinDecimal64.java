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

package org.apache.hadoop.hive.ql.exec.vector.expressions.aggregates.gen;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.vector.VectorAggregationDesc;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;

/**
* VectorUDAFMinDecimal64. Vectorized implementation for MIN/MAX aggregates for Decimal64.
*/
@Description(name = "min",
    value = "_FUNC_(expr) - Returns the minimum value of expr (vectorized, type: decimal64)")
public class VectorUDAFMinDecimal64 extends VectorUDAFMinLong {

  private static final long serialVersionUID = 1L;

  // This constructor is used to momentarily create the object so match can be called.
  public VectorUDAFMinDecimal64() {
    super();
  }

  public VectorUDAFMinDecimal64(VectorAggregationDesc vecAggrDesc) {
    super(vecAggrDesc);
  }

  @Override
  public boolean matches(String name, ColumnVector.Type inputColVectorType,
      ColumnVector.Type outputColVectorType, Mode mode) {

    /*
     * Min/max input and output is DECIMAL_64.
     *
     * Any mode (PARTIAL1, PARTIAL2, FINAL, COMPLETE).
     */
    return
        name.equals("min") &&
        inputColVectorType == ColumnVector.Type.DECIMAL_64 &&
        outputColVectorType == ColumnVector.Type.DECIMAL_64;
  }
}
