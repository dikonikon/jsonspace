package com.example

import com.isomorphicdata.transform._

class MyModelSource extends ModelSource {
	override def next(): String = {
		return """{ "id": 1; "name": "Steve" } """;
	}

	override def  hasNext(): java.lang.Boolean = java.lang.Boolean.TRUE;

	override def reset(fileName: String) = {
		
	}
}

