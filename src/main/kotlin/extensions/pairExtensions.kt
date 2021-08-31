package extensions

fun Pair<Any,Any>?.toPythonTupleString(): String = if (this == null) "None" else "(${this.first}, ${this.second}"