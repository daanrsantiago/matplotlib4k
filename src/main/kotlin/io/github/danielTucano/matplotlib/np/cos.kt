package io.github.danielTucano.matplotlib.np

import io.github.danielTucano.python.PythonScriptBuilder

fun cos(theta: NPVar): NPVar {
    return object : NPVar {
        override val variableName: String = "np_var_${NPVar.npVarNumber}"
        init {
            PythonScriptBuilder.addCommand("$variableName = np.cos(${theta.variableName})")
        }
    }
}