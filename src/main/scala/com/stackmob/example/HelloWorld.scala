/**
 * Copyright 2012 StackMob
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stackmob.example

import com.stackmob.core.customcode.CustomCodeMethod
import com.stackmob.sdkapi.SDKServiceProvider
import com.stackmob.core.rest.{ResponseToProcess, ProcessedAPIRequest}
import java.util.{List => JList}
import java.net.HttpURLConnection
import scala.collection.JavaConverters._

class HelloWorld extends CustomCodeMethod {

  override def getMethodName: String = "hello_orld"

  override def getParams: JList[String] = List[String]().asJava

  override def execute(request: ProcessedAPIRequest, serviceProvider: SDKServiceProvider): ResponseToProcess = {
    new ResponseToProcess(HttpURLConnection.HTTP_OK, Map("msg" -> request.getLoggedInUser, "verb" -> request.getVerb.toString, "params" -> request.getParams).asJava)
  }

}
