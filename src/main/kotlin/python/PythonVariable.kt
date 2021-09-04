package python

interface PythonVariable {
    val variableName: String
}

fun PythonVariable?.toPythonVariableNameOrNone(): String {
    return this?.variableName ?: "None"
}