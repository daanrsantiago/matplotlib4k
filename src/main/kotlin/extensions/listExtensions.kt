package extensions

fun <T: Number> List<T>?.toPythonNumberArrayString(): String {
    return if (this == null) "" else "[${this.joinToString(separator = ",")}]"
}