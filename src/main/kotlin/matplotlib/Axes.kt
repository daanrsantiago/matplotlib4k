package matplotlib

import extensions.*
import matplotlib.Line2D.Companion.line2DNumber
import matplotlib.np.NPVar
import matplotlib.pyplot.gridAxis
import matplotlib.pyplot.gridWhich
import python.PythonScriptBuilder
import java.awt.Color

interface Axes {

    val axesName: String

    companion object {
        var axesNumber: Int = 0
            get() {
                field++
                return field
            }
            private set
    }

    fun plot(
        x: List<Double>? = null,
        y: List<Double>,
        fmt: String? = null,
        kwargs: Map<Line2D.Line2DArgs, KwargValue>? = null
    ): Line2D {
        return object : Line2D {
            override val line2DName: String = "line2D_$line2DNumber"

            init {
                PythonScriptBuilder.addCommand(
                    "$line2DName = $axesName.plot(" +
                            "${x.toPythonNumberArrayString()}${x.emptyIfNullOrComma()}" +
                            "${y.toPythonNumberArrayString()}${fmt.emptyIfNullOrComma()}" +
                            "${fmt.toPythonStringQuotedOrEmpty()}${kwargs.emptyIfNullOrComma()}" +
                            "${kwargs.toKwargPythonStringOrEmpty()}" +
                            ")"
                )
            }
        }
    }

    fun grid(
        b: Boolean? = null,
        which: gridWhich = gridWhich.major,
        axis: gridAxis = gridAxis.both
    ) {
        PythonScriptBuilder.addCommand("$axesName.grid(b=${b.toPythonBooleanOrNone()},which=${which.toPythonStringQuotedOrEmpty()},axis=${axis.toPythonStringQuotedOrEmpty()})")
    }

    fun scatter(
        x: List<Double>,
        y: List<Double>,
        s: Double? = null,
        c: String? = null,
        marker: String? = null,
        cmap: String? = null,
        norm: String? = null,
        vmin: Double? = null,
        vmax: Double? = null,
        alpha: Double? = null,
        linewidths: Double? = null,
        edgecolors: Color? = null,
        plotnonfinite: Boolean = false
    ) {
        PythonScriptBuilder.addCommand("$axesName.scatter(" +
                "${x.toPythonNumberArrayString()}," +
                "${y.toPythonNumberArrayString()}," +
                "s=${s.toPythonStringOrNone()}," +
                "c=${c.toPythonStringQuotedOrNone()}," +
                "marker=${marker.toPythonStringOrNone()}," +
                "cmap=${cmap.toPythonStringQuotedOrNone()}," +
                "norm=${norm.toPythonStringOrNone()}," +
                "vmin=${vmin.toPythonStringOrNone()}," +
                "vmax=${vmax.toPythonStringOrNone()}," +
                "alpha=${alpha.toPythonStringOrNone()}," +
                "linewidths=${linewidths.toPythonStringOrNone()}," +
                "edgecolors=${edgecolors.toPythonTupleString()}," +
                "plotnonfinite=${plotnonfinite.toPythonBooleanOrNone()}" +
                ")")
    }

    fun quiver(xValues: NPVar, yValues: NPVar, uValues: NPVar, vValues: NPVar) {
        PythonScriptBuilder.addCommand(
            "$axesName.quiver(${xValues.npVarName},${yValues.npVarName}," +
                    "${uValues.npVarName},${vValues.npVarName})"
        )
    }

    fun set_title(label: String = "", loc: TitleLocation? = null, pad: Float? = null, y: Float? = null) {
        PythonScriptBuilder.addCommand(
            "$axesName.set_title(" +
                    "${label.toPythonStringQuotedOrEmpty()}," +
                    "loc=${loc.toPythonStringOrNone()}," +
                    "pad=${pad.toPythonStringOrNone()}," +
                    "y=${y.toPythonStringOrNone()}" +
                    ")"
        )
    }

    enum class TitleLocation { center, left, right }

    fun legend() {
        PythonScriptBuilder.addCommand("$axesName.legend()")
    }

    fun legend(legends: List<String>) {
        PythonScriptBuilder.addCommand(
            "$axesName.legend([${
                legends.joinToString(
                    separator = ",",
                    prefix = "'",
                    postfix = "'"
                )
            }])"
        )
    }

}