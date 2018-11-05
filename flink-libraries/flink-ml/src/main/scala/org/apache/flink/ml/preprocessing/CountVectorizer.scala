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

package org.apache.flink.ml.preprocessing

import org.apache.flink.api.scala.DataSet
import org.apache.flink.ml.common.ParameterMap
import org.apache.flink.ml.pipeline.{FitOperation, Transformer}
import org.apache.flink.util.Collector


class CountVectorizer extends Transformer[CountVectorizer] {



}

object CountVectorizer {

  implicit val fitDictionary = new FitOperation[CountVectorizer, String] {
    override def fit(instance: CountVectorizer, fitParameters: ParameterMap, input: DataSet[String]): Unit = {

    }
  }

  private def trainDictionary(input: DataSet[String]): DataSet[Map[String, Int]] = {


  }

}
