package matplotlib.pyplot

import extensions.emptyIfNullOrComma
import extensions.toPythonNumberArrayString
import extensions.toPythonStringQuotedOrEmpty
import matplotlib.Line2D
import python.PythonScriptBuilder

fun plot(
    x: List<Double>? = null,
    y: List<Double>,
    fmt: String? = null
): Line2D {
    return object: Line2D {
        override val line2DName: String = "line2D_${Line2D.line2DNumber}"
        init {
            PythonScriptBuilder.addCommand("$line2DName = plt.plot(" +
                    "${x.toPythonNumberArrayString()}${x.emptyIfNullOrComma()}" +
                    "${y.toPythonNumberArrayString()}${fmt.emptyIfNullOrComma()}" +
                    "${fmt.toPythonStringQuotedOrEmpty()}" +
                    ")")
        }
    }
}