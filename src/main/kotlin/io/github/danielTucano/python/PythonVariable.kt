package io.github.danielTucano.python

interface PythonVariable {
    val variableName: String
}

fun PythonVariable?.toPythonVariableNameOrNone(): String {
    return this?.variableName ?: "None"
}