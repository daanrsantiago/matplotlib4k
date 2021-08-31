package extensions

fun Boolean?.toPythonBooleanOrNone(): String = if (this == null) "None" else if (this) "True" else "False"