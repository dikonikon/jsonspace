package com.example

import play.api.libs.json._
import scala.reflect.runtime.universe._

object Hello {
  def main(args: Array[String]): Unit = {

  	val rawJson = """{"hello": "world", "age": 42}"""

  	val json = Json.parse(rawJson)

    println(s"json: $json")
  }
}
