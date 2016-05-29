package com.example

import play.api.libs.json._
import scala.reflect.runtime.universe._



object Main {

	def getType[T: TypeTag](obj: T) = typeOf[T]

	def testJsObject(args: Array[String]): Unit = {
		import com.isomorphicdata.JsonOps.JsonValueMatcher

		// where template prop exists it is equal so true

		val rawJson1 = """{"hello": "world", "age": 42}"""

		val json1 = Json.parse(rawJson1)

		val jsonObj: JsObject = json1.as[JsObject]

		val templateS = """{"hello": "world"}"""

		val template = Json.parse(templateS)

		val templateObj: JsObject = template.as[JsObject]

		println(jsonObj >> templateObj)

		// where template prop exists its name is the same and is equal or null, so true

		val templateS1 = """{"hello": "world", "age": null}"""

		val template1 = Json.parse(templateS1)

		val templateObj1: JsObject = template1.as[JsObject]

		println(jsonObj >> templateObj1)

		// at least one template prop has same name, but different value, so false

		val templateS2 = """{"hello": "world", "age": 41}"""

		val template2 = Json.parse(templateS2)

		val templateObj2: JsObject = template2.as[JsObject]

		println(jsonObj >> templateObj2)

		// at least one template prop has same name but different type, so false

		val templateS3 = """{"hello": "world", "age": "old"}"""

		val template3 = Json.parse(templateS3)

		val templateObj3: JsObject = template3.as[JsObject]

		println(jsonObj >> templateObj3)

	}

  def runTypeExample(args: Array[String]): Unit = {

  	val rawJson = """{"hello": "world", "age": 42}"""

  	val json = Json.parse(rawJson)

  	// create second json object with different values, then compare
  	// properties name by name and check for same type

  	val rawJson1 = """{"hello": "world", "age": 42}"""

  	val json1 = Json.parse(rawJson1)

  	val jsonObj: JsObject = json1.as[JsObject]

  	val fields = jsonObj.fields

  	val keys = jsonObj.keys

    println(s"fields: $fields")

    println(s"keys: $keys")

		val hello = (jsonObj \ "hello").get

    println(s"hello: $hello")

		println(s"type of hello: " + getType(hello))

		val age = (jsonObj \ "age").get

    println(s"age: $age" )

		println(s"type of age: " + getType(age))

		val ageVal = age.as[JsNumber]

		println(s"type of age JsValue: " + getType(ageVal))

		val helloVal = hello.asOpt[JsNumber]

		println(s"type of hello JsValue: " + getType(helloVal))

		println("and helloVal is: " + helloVal)
  }
}
