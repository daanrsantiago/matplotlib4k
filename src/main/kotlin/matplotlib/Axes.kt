package matplotlib

import extensions.*
import matplotlib.Line2D.Companion.line2DNumber
import matplotlib.Quiver.Companion.quiverNumber
import matplotlib.np.NPVar
import matplotlib.pyplot.GridAxisOptions
import matplotlib.pyplot.GridWhichOptions
import python.PythonScriptBuilder
import java.awt.Color

/**
 * Axes class methods signatures from matplotlib
 */
interface Axes : AxesBase {

    override val variableName: String

    companion object {
        internal var axesNumber: Int = 0
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
            override val variableName: String = "line2D_$line2DNumber"

            init {
                PythonScriptBuilder.addCommand(
                    "$variableName = ${this@Axes.variableName}.plot(" +
                            "${x.toPythonNumberArrayStringOrEmpty()}${x.emptyIfNullOrComma()}" +
                            "${y.toPythonNumberArrayStringOrEmpty()}${fmt.emptyIfNullOrComma()}" +
                            "${fmt.toPythonStringQuotedOrEmpty()}${kwargs.emptyIfNullOrComma()}" +
                            kwargs.toKwargPythonStringOrEmpty() +
                            ")"
                )
            }
        }
    }

    fun grid(
        b: Boolean? = null,
        which: GridWhichOptions = GridWhichOptions.major,
        axis: GridAxisOptions = GridAxisOptions.both
    ) {
        PythonScriptBuilder.addCommand("$variableName.grid(b=${b.toPythonBooleanOrNone()},which=${which.toPythonStringQuotedOrEmpty()},axis=${axis.toPythonStringQuotedOrEmpty()})")
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
        PythonScriptBuilder.addCommand(
            "$variableName.scatter(" +
                    "${x.toPythonNumberArrayStringOrEmpty()}," +
                    "${y.toPythonNumberArrayStringOrEmpty()}," +
                    "s=${s.toPythonStringOrNone()}," +
                    "c=${c.toPythonStringQuotedOrNone()}," +
                    "marker=${marker.toPythonStringOrNone()}," +
                    "cmap=${cmap.toPythonStringQuotedOrNone()}," +
                    "norm=${norm.toPythonStringOrNone()}," +
                    "vmin=${vmin.toPythonStringOrNone()}," +
                    "vmax=${vmax.toPythonStringOrNone()}," +
                    "alpha=${alpha.toPythonStringOrNone()}," +
                    "linewidths=${linewidths.toPythonStringOrNone()}," +
                    "edgecolors=${edgecolors.toPythonTupleStringOrNone()}," +
                    "plotnonfinite=${plotnonfinite.toPythonBooleanOrNone()}" +
                    ")"
        )
    }

    fun quiver(
        xValues: NPVar,
        yValues: NPVar,
        uValues: NPVar,
        vValues: NPVar,
        units: QuiverUnitsOptions? = QuiverUnitsOptions.width,
        angles: QuiverAnglesOptions? = null,
        scale: Double? = null,
        scale_units: QuiverScaleUnitsOptions? = null,
        width: Double? = null,
        headwidth: Double = 3.0,
        headlength: Double = 5.0,
        headaxislength: Double = 4.5,
        minshaft: Double = 1.0,
        minlength: Double = 1.0,
        pivot: QuiverPivotOptions = QuiverPivotOptions.tail,
        colors: List<Color> = listOf(Color.BLACK),
        zorder: Double = 3.0
    ): Quiver {
        return object : Quiver {
            override val variableName: String = "quiver_$quiverNumber"

            init {
                PythonScriptBuilder.addCommand(
                    "${this.variableName} = ${this@Axes.variableName}.quiver(" +
                            "${xValues.variableName}," +
                            "${yValues.variableName}," +
                            "${uValues.variableName}," +
                            "${vValues.variableName}," +
                            "units=${units.toPythonStringQuotedOrNone()}," +
                            "angles=${angles.toPythonStringQuotedOrNone()}," +
                            "scale=${scale.toPythonStringOrNone()}," +
                            "scale_units=${scale_units.toPythonStringQuotedOrNone()}," +
                            "width=${width.toPythonStringOrNone()}," +
                            "headwidth=${headwidth.toPythonStringOrNone()}," +
                            "headlength=${headlength.toPythonStringOrNone()}," +
                            "headaxislength=${headaxislength.toPythonStringOrNone()}," +
                            "minshaft=${minshaft.toPythonStringOrNone()}," +
                            "minlength=${minlength.toPythonStringOrNone()}," +
                            "pivot=${pivot.toPythonStringQuotedOrNone()}," +
                            "colors=${colors.toPythonColorTupleArrayOrNone()}," +
                            "zorder=${zorder.toPythonStringOrNone()}" +
                            ")"
                )
            }
        }
    }

    fun quiver(
        xValues: List<Double>,
        yValues: List<Double>,
        uValues: List<Double>,
        vValues: List<Double>,
        units: QuiverUnitsOptions? = QuiverUnitsOptions.width,
        angles: QuiverAnglesOptions? = null,
        scale: Double? = null,
        scale_units: QuiverScaleUnitsOptions? = null,
        width: Double? = null,
        headwidth: Double = 3.0,
        headlength: Double = 5.0,
        headaxislength: Double = 4.5,
        minshaft: Double = 1.0,
        minlength: Double = 1.0,
        pivot: QuiverPivotOptions = QuiverPivotOptions.tail,
        colors: List<Color> = listOf(Color.BLACK),
        zorder: Double = 3.0
    ): Quiver {
        return object : Quiver {
            override val variableName: String = "quiver_$quiverNumber"
            init {
                PythonScriptBuilder.addCommand(
                    "${this.variableName} = ${this@Axes.variableName}.quiver(" +
                            "${xValues.toPythonNumberArrayStringOrEmpty()}," +
                            "${yValues.toPythonNumberArrayStringOrEmpty()}," +
                            "${uValues.toPythonNumberArrayStringOrEmpty()}," +
                            "${vValues.toPythonNumberArrayStringOrEmpty()}," +
                            "units=${units.toPythonStringQuotedOrNone()}," +
                            "angles=${angles.toPythonStringQuotedOrNone()}," +
                            "scale=${scale.toPythonStringOrNone()}," +
                            "scale_units=${scale_units.toPythonStringQuotedOrNone()}," +
                            "width=${width.toPythonStringOrNone()}," +
                            "headwidth=${headwidth.toPythonStringOrNone()}," +
                            "headlength=${headlength.toPythonStringOrNone()}," +
                            "headaxislength=${headaxislength.toPythonStringOrNone()}," +
                            "minshaft=${minshaft.toPythonStringOrNone()}," +
                            "minlength=${minlength.toPythonStringOrNone()}," +
                            "pivot=${pivot.toPythonStringQuotedOrNone()}," +
                            "colors=${colors.toPythonColorTupleArrayOrNone()}," +
                            "zorder=${zorder.toPythonStringOrNone()}" +
                            ")"
                )
            }
        }
    }

    enum class QuiverUnitsOptions { width, height, dots, inces, x, y, xy }

    enum class QuiverAnglesOptions { uv, xy }

    enum class QuiverScaleUnitsOptions { wigth, height, dots, inches, x, y, xy }

    enum class QuiverPivotOptions { tail, middle, tip }

    fun set_title(label: String = "", loc: TitleLocationOptions? = null, pad: Float? = null, y: Float? = null) {
        PythonScriptBuilder.addCommand(
            "$variableName.set_title(" +
                    "${label.toPythonStringQuotedOrEmpty()}," +
                    "loc=${loc.toPythonStringOrNone()}," +
                    "pad=${pad.toPythonStringOrNone()}," +
                    "y=${y.toPythonStringOrNone()}" +
                    ")"
        )
    }

    enum class TitleLocationOptions { center, left, right }


    fun legend() {
        PythonScriptBuilder.addCommand("$variableName.legend()")
    }

    fun legend(legends: List<String>) {
        PythonScriptBuilder.addCommand(
            "$variableName.legend([${
                legends.joinToString(
                    separator = ",",
                    prefix = "'",
                    postfix = "'"
                )
            }])"
        )
    }

}