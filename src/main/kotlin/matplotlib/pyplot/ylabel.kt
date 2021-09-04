package matplotlib.pyplot

import extensions.emptyIfNullOrComma
import extensions.toPythonStringOrNone
import extensions.toPythonStringQuotedOrEmpty
import extensions.toPythonStringQuotedOrNone
import matplotlib.AxesBase
import matplotlib.KwargValue
import matplotlib.Text
import matplotlib.toKwargPythonStringOrEmpty
import python.PythonScriptBuilder

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