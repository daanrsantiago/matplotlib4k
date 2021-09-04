package extensions

fun <T: Number> List<T>?.toPythonNumberArrayStringOrEmpty(): String {
    return if (this == null) "" else "[${this.joinToString(separator = ",")}]"
}