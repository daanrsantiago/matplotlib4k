package matplotlib.np

import matplotlib.np.NPVar.Companion.npVarNumber
import python.PythonScriptBuilder

fun sqrt(value: NPVar): NPVar {
    return object : NPVar {
        override val variableName: String = "np_var_$npVarNumber"
        init {
            PythonScriptBuilder.addCommand("$variableName = np.sqrt(${value.variableName})")
        }
    }
}