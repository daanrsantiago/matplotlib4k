package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.toPythonBooleanOrNone
import io.github.danielTucano.extensions.toPythonStringOrNone
import io.github.danielTucano.python.PythonScriptBuilder

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