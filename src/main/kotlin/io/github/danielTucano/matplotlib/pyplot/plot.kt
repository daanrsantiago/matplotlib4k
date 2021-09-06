package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.emptyIfNullOrComma
import io.github.danielTucano.extensions.toPythonNumberArrayStringOrEmpty
import io.github.danielTucano.extensions.toPythonStringQuotedOrEmpty
import io.github.danielTucano.matplotlib.KwargValue
import io.github.danielTucano.matplotlib.Line2D
import io.github.danielTucano.matplotlib.toKwargPythonStringOrEmpty
import io.github.danielTucano.python.PythonScriptBuilder

fun plot(
    x: List<Double>? = null,
    y: List<Double>,
    fmt: String? = null,
    kwargs: Map<Line2D.Line2DArgs, KwargValue>? = null
): Line2D {
    return object: Line2D {
        override val variableName: String = "line2D_${Line2D.line2DNumber}"
        init {
            PythonScriptBuilder.addCommand("$variableName = plt.plot(" +
                    "${x.toPythonNumberArrayStringOrEmpty()}${x.emptyIfNullOrComma()}" +
                    "${y.toPythonNumberArrayStringOrEmpty()}${fmt.emptyIfNullOrComma()}" +
                    "${fmt.toPythonStringQuotedOrEmpty()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")")
        }
    }
}