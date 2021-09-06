package io.github.danielTucano.matplotlib.np

import io.github.danielTucano.matplotlib.np.NPVar.Companion.npVarNumber
import io.github.danielTucano.python.PythonScriptBuilder

fun sin(theta: NPVar): NPVar {
    return object : NPVar {
        override val variableName: String = "np_var_$npVarNumber"
        init {
            PythonScriptBuilder.addCommand("$variableName = np.sin(${theta.variableName})")
        }
    }
}