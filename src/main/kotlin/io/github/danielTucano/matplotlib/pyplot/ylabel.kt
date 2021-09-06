package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.emptyIfNullOrComma
import io.github.danielTucano.extensions.toPythonStringOrNone
import io.github.danielTucano.extensions.toPythonStringQuotedOrEmpty
import io.github.danielTucano.extensions.toPythonStringQuotedOrNone
import io.github.danielTucano.matplotlib.AxesBase
import io.github.danielTucano.matplotlib.KwargValue
import io.github.danielTucano.matplotlib.Text
import io.github.danielTucano.matplotlib.toKwargPythonStringOrEmpty
import io.github.danielTucano.python.PythonScriptBuilder

fun ylabel(
    ylabel: String,
    labelpad: Double = 4.0,
    loc: AxesBase.LabelLocOptions = AxesBase.LabelLocOptions.center,
    kwargs: Map<Text.TextKwargsKeys, KwargValue>? = null
) {
    PythonScriptBuilder.addCommand(
        "plt.ylabel(" +
                "ylabel=${ylabel.toPythonStringQuotedOrEmpty()}," +
                "labelpad=${labelpad.toPythonStringOrNone()}," +
                "loc=${loc.toPythonStringQuotedOrNone()}${kwargs.emptyIfNullOrComma()}" +
                kwargs.toKwargPythonStringOrEmpty() +
                ")"
    )
}