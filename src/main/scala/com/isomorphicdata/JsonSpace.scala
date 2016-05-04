

package com.isomorphicdata

import play.api.libs.json.JsObject
import play.api.libs.json.JsNull

object JsonOps {


  implicit class JsonValueMatcher(js: JsObject) {

    /**
     * true if each of the properties of template:
     * <li>exists in js</li>
     * <li>has the same type as in js</li>
     * <li>has the value null or the same value as js</li>
     * @param template
     * @return
     */
    def >> (template: JsObject): Boolean = {
      val templateValue = template.value
      val jsValue = js.value
      templateValue.keys./: (true)( (b: Boolean, key: String) => {
              val thisResult = jsValue.get(key) match {
              case None => false
              case Some(jsProp) => {
                val templateProp = templateValue.get(key).get
                templateProp.equals(JsNull) || templateProp.equals(jsProp)
                }
              }
              b && thisResult
            })
    }
  }
}

