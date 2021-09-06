package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.toPythonBooleanOrNone
import io.github.danielTucano.matplotlib.Axes
import io.github.danielTucano.matplotlib.Axes.Companion.axesNumber
import io.github.danielTucano.matplotlib.Figure
import io.github.danielTucano.matplotlib.Figure.Companion.figureNumber
import io.github.danielTucano.matplotlib.toKwargPythonDictOrNone
import io.github.danielTucano.python.PythonScriptBuilder

fun subplots(
    nrows: Int = 1,
    ncols: Int = 1,
    sharex: Boolean = false,
    sharey: Boolean = false,
    squeeze: Boolean = true,
    subplot_kw: Map<String, String>? = null,
    gridspec_kw: Map<String, String>? = null
): Pair<Figure, Axes> {
    val figAxes = Pair(
        object : Figure {
            override val variableName: String = "figure_$figureNumber"
        },
        object : Axes {
            override val variableName: String = "axes_$axesNumber"
        }
    )
    PythonScriptBuilder.addCommand(
        "${figAxes.first.variableName}, ${figAxes.second.variableName} = plt.subplots(" +
                "nrows=$nrows," +
                "ncols=$ncols," +
                "sharex=${sharex.toPythonBooleanOrNone()}," +
                "sharey=${sharey.toPythonBooleanOrNone()}," +
                "squeeze=${squeeze.toPythonBooleanOrNone()}," +
                "subplot_kw=${subplot_kw.toKwargPythonDictOrNone()}," +
                "gridspec_kw=${gridspec_kw.toKwargPythonDictOrNone()}" +
                ")"
    )
    return figAxes
}