package extensions

fun Any?.toPythonStringOrNone(): String = this?.toString() ?: "None"

fun Any?.toPythonStringQuotedOrEmpty(): String = if (this == null) "" else "'${this.toString()}'"

fun Any?.toPythonStringQuotedOrNone(): String = if (this == null) "None" else "'${this.toString()}'"

fun Any?.emptyIfNullOrComma(): String = if (this == null) "" else ","