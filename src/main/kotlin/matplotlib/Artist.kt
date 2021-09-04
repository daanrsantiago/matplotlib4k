package matplotlib

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringOrNone
import extensions.toPythonStringQuotedOrEmpty
import python.PythonScriptBuilder
import python.PythonVariable

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