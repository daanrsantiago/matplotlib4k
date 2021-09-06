package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.toPythonStringOrNone
import io.github.danielTucano.extensions.toPythonStringQuotedOrEmpty
import io.github.danielTucano.matplotlib.Axes
import io.github.danielTucano.python.PythonScriptBuilder

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