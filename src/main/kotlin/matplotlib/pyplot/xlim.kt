package matplotlib.pyplot

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringOrNone
import python.PythonScriptBuilder

fun xlim(left: Double? = null, right: Double? = null, xmin: Double? = null, xmax: Double? = null, emit: Boolean = true, auto: Boolean = false) {
    PythonScriptBuilder.addCommand("plt.xlim(" +
            "left=${left.toPythonStringOrNone()}," +
            "right=${right.toPythonStringOrNone()}," +
            "emit=${emit.toPythonBooleanOrNone()}," +
            "auto=${auto.toPythonBooleanOrNone()}," +
            "xmin=${xmin.toPythonStringOrNone()}," +
            "xmax=${xmax.toPythonStringOrNone()}" +
            ")")
}