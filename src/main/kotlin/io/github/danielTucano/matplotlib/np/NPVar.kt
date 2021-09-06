package io.github.danielTucano.matplotlib.np

import io.github.danielTucano.python.PythonScriptBuilder
import io.github.danielTucano.python.PythonVariable

interface NPVar: PythonVariable {
    companion object {
        var npVarNumber: Int = 0
            get() {
                field++
                return field
            }
        private set
    }

    fun pow(value: Number): NPVar {
        return object : NPVar {
            override val variableName: String = "np_var_$npVarNumber"
            init {
                PythonScriptBuilder.addCommand("$variableName = ${this@NPVar.variableName}**$value")
            }
        }
    }

    operator fun plus(value: NPVar): NPVar {
        return object : NPVar {
            override val variableName: String = "np_var_$npVarNumber"
            init {
                PythonScriptBuilder.addCommand("$variableName = ${this@NPVar.variableName} + ${value.variableName}")
            }
        }
    }

    operator fun minus(value: NPVar): NPVar {
        return object : NPVar {
            override val variableName: String = "np_var_$npVarNumber"
            init {
                PythonScriptBuilder.addCommand("$variableName = ${this@NPVar.variableName} - ${value.variableName}")
            }
        }
    }

    operator fun times(value: NPVar): NPVar {
        return object : NPVar {
            override val variableName: String = "np_var_$npVarNumber"
            init {
                PythonScriptBuilder.addCommand("$variableName = ${this@NPVar.variableName} * ${value.variableName}")
            }
        }
    }

    operator fun div(value: NPVar): NPVar {
        return object : NPVar {
            override val variableName: String = "np_var_$npVarNumber"
            init {
                PythonScriptBuilder.addCommand("$variableName = ${this@NPVar.variableName} / ${value.variableName}")
            }
        }
    }
}