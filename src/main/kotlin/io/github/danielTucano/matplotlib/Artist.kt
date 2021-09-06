package io.github.danielTucano.matplotlib

import io.github.danielTucano.extensions.toPythonBooleanOrNone
import io.github.danielTucano.extensions.toPythonStringOrNone
import io.github.danielTucano.extensions.toPythonStringQuotedOrEmpty
import io.github.danielTucano.python.PythonScriptBuilder
import io.github.danielTucano.python.PythonVariable

interface Artist : PythonVariable {

    fun set_zorder(level: Double) {
        PythonScriptBuilder.addCommand("$variableName.set_zorder(${level.toPythonStringOrNone()})")
    }

    fun set_label(s: String) {
        PythonScriptBuilder.addCommand("$variableName.set_label(${s.toPythonStringQuotedOrEmpty()})")
    }

    fun set_alpha(alpha: Double) {
        if (alpha !in 0.0..1.0) throw IllegalArgumentException("alpha must be between 0 and 1")
        PythonScriptBuilder.addCommand("$variableName.set_alpha(${alpha.toPythonStringOrNone()})")
    }

    fun set_visible(b: Boolean) {
        PythonScriptBuilder.addCommand("$variableName.set_visible(${b.toPythonBooleanOrNone()})")
    }

}