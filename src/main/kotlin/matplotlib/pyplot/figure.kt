package matplotlib.pyplot

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringOrNone
import extensions.toPythonTupleString
import matplotlib.Figure
import matplotlib.toPythonTupleStringOrNone
import python.PythonScriptBuilder
import java.awt.Color

fun figure(
    num: Int? = null,
    figsize: Pair<Float, Float>? = null,
    dpi: Float? = null,
    facecolor: Color? = null,
    edgecolor: Color? = null,
    frameon: Boolean? = null,
    clear: Boolean = false,
): Figure {
    return object : Figure {
        override val variableName: String = "figure_${Figure.figureNumber}"

        init {
            PythonScriptBuilder.addCommand(
                "$variableName = plt.figure(" +
                        "num=${num.toPythonStringOrNone()}," +
                        "figsize=${figsize.toPythonTupleString()}," +
                        "dpi=${dpi.toPythonStringOrNone()}," +
                        "facecolor=${facecolor.toPythonTupleStringOrNone()}," +
                        "edgecolor=${edgecolor.toPythonTupleStringOrNone()}," +
                        "frameon=${frameon.toPythonBooleanOrNone()}," +
                        "clear=${clear.toPythonBooleanOrNone()}" +
                        ")"
            )
        }
    }
}