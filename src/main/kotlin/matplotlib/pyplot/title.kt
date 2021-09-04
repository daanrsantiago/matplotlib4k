package matplotlib.pyplot

import extensions.toPythonStringOrNone
import extensions.toPythonStringQuotedOrEmpty
import matplotlib.Axes
import python.PythonScriptBuilder

fun title(label: String = "", loc: Axes.TitleLocationOptions? = null, pad: Float? = null, y: Float? = null) {
    PythonScriptBuilder.addCommand(
        "plt.title(" +
                "${label.toPythonStringQuotedOrEmpty()}," +
                "loc=${loc.toPythonStringOrNone()}," +
                "pad=${pad.toPythonStringOrNone()}," +
                "y=${y.toPythonStringOrNone()}" +
                ")"
    )
}