package matplotlib

fun <K: KwargKey, V: KwargValue> Map<K,V>?.toKwargPythonStringOrNone(): String {
    return if (this == null) "None" else "," + this.map { "${it.key}=${it.value}" }.joinToString(",")
}

fun  <K: KwargKey, V: KwargValue> Map<K,V>?.toKwargPythonStringOrEmpty(): String {
    return if (this == null) "" else this.map { "${it.key}=${it.value}" }.joinToString(",")
}

@JvmName("toKwargPythonStringOrNoneStringString")
fun Map<String,String>?.toKwargPythonStringOrNone(): String {
    return if (this == null) "None" else "," + this.map { "${it.key}=${it.value}" }.joinToString(",")
}

fun Map<String,String>?.toKwargPythonDictOrNone(): String {
    return if (this == null) "None" else ("{" + this.map { "\"${it.key}\": \"${it.value}\"" }.joinToString(",") + "}")
}