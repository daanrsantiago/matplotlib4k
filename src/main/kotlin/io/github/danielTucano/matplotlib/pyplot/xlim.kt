package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.toPythonBooleanOrNone
import io.github.danielTucano.extensions.toPythonStringOrNone
import io.github.danielTucano.python.PythonScriptBuilder

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