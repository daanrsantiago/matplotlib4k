package matplotlib.pyplot

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringOrNone
import python.PythonScriptBuilder

fun ylim(bottom: Double? = null, top: Double? = null, ymin: Double? = null, ymax: Double? = null, emit: Boolean = true, auto: Boolean = false) {
    PythonScriptBuilder.addCommand("plt.ylim(" +
            "bottom=${bottom.toPythonStringOrNone()}," +
            "top=${top.toPythonStringOrNone()}," +
            "emit=${emit.toPythonBooleanOrNone()}," +
            "auto=${auto.toPythonBooleanOrNone()}," +
            "ymin=${ymin.toPythonStringOrNone()}," +
            "ymax=${ymax.toPythonStringOrNone()}" +
            ")")
}