package matplotlib.pyplot

import extensions.emptyIfNullOrComma
import extensions.toPythonNumberArrayStringOrEmpty
import extensions.toPythonStringQuotedOrEmpty
import matplotlib.KwargValue
import matplotlib.Line2D
import matplotlib.toKwargPythonStringOrEmpty
import python.PythonScriptBuilder

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