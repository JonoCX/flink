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
import org.apache.flink.ml.common.{Parameter, ParameterMap}
import org.apache.flink.ml.pipeline.{FitOperation, Transformer}
import org.apache.flink.ml.preprocessing.CountVectorizer.{Binary, Lowercase, StopWords}
import org.apache.flink.ml.math.{SparseMatrix, Vector}

class CountVectorizer extends Transformer[CountVectorizer] {

  /**
    * Convert all characters to lowercase before tokenizing
    *
    * @param lowercase default value is True
    */
  def setLowercase(lowercase: Boolean): CountVectorizer = {
    parameters.add(Lowercase, lowercase)
    this
  }

  def setStopWords(stopWords: Array[String]): CountVectorizer = {
    require(stopWords.length > 0, "Stop Words cannot be an empty list")
    parameters.add(StopWords, stopWords)
    this
  }

  def setBinary(binary: Boolean): CountVectorizer = {
    parameters.add(Binary, binary)
    this
  }
}

object CountVectorizer {

  // ====================================== Parameters =============================================

  case object Lowercase extends Parameter[Boolean] {
    override val defaultValue: Option[Boolean] = Some(true)
  }

  case object StopWords extends Parameter[Array[String]] {
    override val defaultValue: Option[Array[String]] = Some(null)
  }

  case object Binary extends Parameter[Boolean] {
    override val defaultValue: Option[Boolean] = Some(false)
  }

  // =================================== Factory methods ===========================================

  def apply(): CountVectorizer = {
    new CountVectorizer()
  }

  // ====================================== Operations =============================================

  implicit def fitCountVectorizer[T <: Vector] = new FitOperation[CountVectorizer, T] {
    override def fit(instance: CountVectorizer, fitParameters: ParameterMap, input: DataSet[T]): Unit = {

    }
  }

  private def createCountMatrix[T <: SparseMatrix](dataSet: DataSet[T]) : SparseMatrix = {
    
  }

}
