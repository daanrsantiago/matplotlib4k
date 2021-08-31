package matplotlib

import extensions.*
import matplotlib.np.NPVar
import python.PythonScriptBuilder

interface Axes3D {
    val axes3DName: String

    companion object {
        var axes3DNumber: Int = 0
            get() {
                field++
                return field
            }
            private set
    }

    fun quiver(
        xValues: NPVar, yValues: NPVar, zValues: NPVar,
        uValues: NPVar, vValues: NPVar, wValues: NPVar,
        length: Double = 1.0, arrow_length_ratio: Double = 0.3, pivot: QuiverPivot = QuiverPivot.tail,
        normalize: Boolean = false
    ) {
        PythonScriptBuilder.addCommand(
            "$axes3DName.quiver(${xValues.npVarName}, ${yValues.npVarName}, ${zValues.npVarName}," +
                    "${uValues.npVarName}, ${vValues.npVarName}, ${wValues.npVarName}, length=$length," +
                    " arrow_length_ratio=$arrow_length_ratio, pivot=${pivot.toPythonStringQuotedOrEmpty()},normalize=${normalize.toPythonBooleanOrNone()})"
        )
    }

    enum class QuiverPivot { tail, middle, tip }

    fun plot(
        xs: List<Double>,
        ys: List<Double>,
        zs: List<Double>,
        zDir: PlotZDirOptions = PlotZDirOptions.z,
        kwargs: Map<Line2D.Line2DArgs, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand(
            "$axes3DName.plot(${xs.toPythonNumberArrayString()}," +
                    "${ys.toPythonNumberArrayString()}," +
                    "${zs.toPythonNumberArrayString()}," +
                    "zdir=${zDir.toPythonStringQuotedOrEmpty()}${kwargs.emptyIfNullOrComma()}" +
                    "${kwargs.toKwargPythonStringOrEmpty()})"
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
            "$axes3DName.scatter(" +
                    "${xs.toPythonNumberArrayString()}," +
                    "${ys.toPythonNumberArrayString()}," +
                    "${zs.toPythonNumberArrayString()}," +
                    "zdir=${zDir.toPythonStringQuotedOrNone()}," +
                    "s=${s.toPythonStringOrNone()}," +
                    "c=${c.toPythonStringOrNone()}," +
                    "depthshade=${depthshade.toPythonBooleanOrNone()}${kwargs.emptyIfNullOrComma()}" +
                    "${kwargs.toKwargPythonStringOrEmpty()}" +
                    ")"
        )
    }

    enum class Scatter3DZDirOptions { x, y, z, `-x`, `-y`, `-z` }
    enum class Scatter3DKwargsKeys :
        KwargKey { marker, cmap, norm, vmin, vmax, alpha, linewidths, edgecolors, plotnonfinite }
}