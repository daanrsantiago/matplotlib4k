package matplotlib.np

import matplotlib.np.NPVar.Companion.npVarNumber
import python.PythonScriptBuilder

fun arange(limInf: Double, limSup: Double, step: Double): NPVar {
    return object : NPVar {
        override val npVarName: String = "np_var_$npVarNumber"
        init {
            PythonScriptBuilder.addCommand("$npVarName = np.arange($limInf,$limSup,$step)")
        }
    }
}