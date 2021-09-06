package matplotlib

import extensions.*
import matplotlib.np.NPVar
import python.PythonScriptBuilder
import org.ejml.simple.SimpleMatrix
import python.toPythonVariableNameOrNone
import java.awt.Color

interface Axes3D : Axes {

    companion object {
        internal var axes3DNumber: Int = 0
            get() {
                field++
                return field
            }
            private set
    }

    fun set_zlim3d(
        bottom: Double? = null,
        top: Double? = null,
        emit: Boolean = true,
        auto: Boolean = false,
        zmin: Double? = null,
        zmax: Double? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.set_zlim3d(" +
                    "bottom=${bottom.toPythonStringOrNone()}," +
                    "top=${top.toPythonStringOrNone()}," +
                    "emit=${emit.toPythonBooleanOrNone()}," +
                    "auto=${auto.toPythonBooleanOrNone()}," +
                    "zmin=${zmin.toPythonStringOrNone()}," +
                    "zmax=${zmax.toPythonStringOrNone()}," +
                    ")"
        )
    }

    fun set_zlabel(
        zlabel: String,
        labelpad: Double = 4.0,
        kwargs: Map<Text.TextKwargsKeys, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.set_zlabel(" +
                    "zlabel=${zlabel.toPythonStringQuotedOrEmpty()}," +
                    "labelpad=${labelpad.toPythonStringOrNone()}," +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }

    fun quiver(
        xValues: NPVar,
        yValues: NPVar,
        zValues: NPVar,
        uValues: NPVar,
        vValues: NPVar,
        wValues: NPVar,
        length: Double = 1.0,
        arrow_length_ratio: Double = 0.3,
        pivot: Axes.QuiverPivotOptions = Axes.QuiverPivotOptions.tail,
        normalize: Boolean = false,
        kwargs: Map<KwargKey, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.quiver(${xValues.variableName}, ${yValues.variableName}, ${zValues.variableName}," +
                    "${uValues.variableName}, ${vValues.variableName}, ${wValues.variableName}," +
                    "length=$length," +
                    "arrow_length_ratio=$arrow_length_ratio," +
                    "pivot=${pivot.toPythonStringQuotedOrEmpty()}," +
                    "normalize=${normalize.toPythonBooleanOrNone()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }

    fun quiver(
        xValues: List<Double>,
        yValues: List<Double>,
        zValues: List<Double>,
        uValues: List<Double>,
        vValues: List<Double>,
        wValues: List<Double>,
        length: Double = 1.0,
        arrow_length_ratio: Double = 0.3,
        pivot: Axes.QuiverPivotOptions = Axes.QuiverPivotOptions.tail,
        normalize: Boolean = false,
        colors: List<Color> = listOf(Color.BLUE),
        kwargs: Map<KwargKey, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.quiver(${xValues.toPythonNumberArrayStringOrEmpty()}, ${yValues.toPythonNumberArrayStringOrEmpty()}, ${zValues.toPythonNumberArrayStringOrEmpty()}," +
                    "${uValues.toPythonNumberArrayStringOrEmpty()}, ${vValues.toPythonNumberArrayStringOrEmpty()}, ${wValues.toPythonNumberArrayStringOrEmpty()}," +
                    "length=$length," +
                    "arrow_length_ratio=$arrow_length_ratio," +
                    "pivot=${pivot.toPythonStringQuotedOrEmpty()}," +
                    "normalize=${normalize.toPythonBooleanOrNone()}," +
                    "colors=${colors.toPythonColorTupleArrayOrNone()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }


    fun plot(
        xs: List<Double>,
        ys: List<Double>,
        zs: List<Double>,
        zDir: PlotZDirOptions = PlotZDirOptions.z,
        kwargs: Map<Line2D.Line2DArgs, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.plot(${xs.toPythonNumberArrayStringOrEmpty()}," +
                    "${ys.toPythonNumberArrayStringOrEmpty()}," +
                    "${zs.toPythonNumberArrayStringOrEmpty()}," +
                    "zdir=${zDir.toPythonStringQuotedOrEmpty()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }

    enum class PlotZDirOptions { x, y, z }

    fun scatter(
        xs: List<Double>,
        ys: List<Double>,
        zs: List<Double>,
        zDir: Scatter3DZDirOptions = Scatter3DZDirOptions.z,
        s: Int = 20,
        c: KwargValue.Quoted? = null,
        depthshade: Boolean = true,
        kwargs: Map<Scatter3DKwargsKeys, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.scatter(" +
                    "${xs.toPythonNumberArrayStringOrEmpty()}," +
                    "${ys.toPythonNumberArrayStringOrEmpty()}," +
                    "${zs.toPythonNumberArrayStringOrEmpty()}," +
                    "zdir=${zDir.toPythonStringQuotedOrNone()}," +
                    "s=${s.toPythonStringOrNone()}," +
                    "c=${c.toPythonStringOrNone()}," +
                    "depthshade=${depthshade.toPythonBooleanOrNone()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }

    enum class Scatter3DZDirOptions { x, y, z, `-x`, `-y`, `-z` }
    enum class Scatter3DKwargsKeys :
        KwargKey { marker, cmap, norm, vmin, vmax, alpha, linewidths, edgecolors, plotnonfinite }


    fun plot_surface(X: SimpleMatrix, Y: SimpleMatrix, Z: SimpleMatrix, cmap: Colormap? = null) {
        PythonScriptBuilder.addCommand(
            "$variableName.plot_surface(" +
                    "X=${X.toPythonMatrixStringOrNone()}," +
                    "Y=${Y.toPythonMatrixStringOrNone()}," +
                    "Z=${Z.toPythonMatrixStringOrNone()}${cmap.emptyIfNullOrComma()}" +
                    "cmap=${cmap.toPythonVariableNameOrNone()}" +
                    ")"
        )
    }

    fun plot_surface(X: NPVar, Y: NPVar, Z: NPVar, cmap: Colormap? = null) {
        PythonScriptBuilder.addCommand(
            "$variableName.plot_surface(" +
                    "X=${X.variableName}," +
                    "Y=${Y.variableName}," +
                    "Z=${Z.variableName}${cmap.emptyIfNullOrComma()}" +
                    "cmap=${cmap.toPythonVariableNameOrNone()}" +
                    ")"
        )
    }
}