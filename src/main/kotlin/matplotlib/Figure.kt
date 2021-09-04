package matplotlib

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringQuotedOrEmpty
import extensions.toPythonStringQuotedOrNone
import matplotlib.Axes3D.Companion.axes3DNumber
import python.PythonScriptBuilder
import python.PythonVariable

interface Figure: PythonVariable {

    override val variableName: String

    companion object {
        var figureNumber: Int = 0
            get() {
                return field++
            }
            private set
    }

    enum class FigureArgs : KwargKey {
        figsize, dpi, faceColor, edgeColor, lineWidth,
        frameOn, tightLayout, constrainedLayout
    }

    // TODO add_subplot(projection='3d') -> Should return Axis3D

    fun add_subplot(projection: AddSubplotProjectionOptions? = null): Axes3D {
        return object : Axes3D {
            override val variableName: String = "axes3d_$axes3DNumber"

            init {
                PythonScriptBuilder.addCommand(
                    "$variableName = ${this@Figure.variableName}.add_subplot(" +
                            "projection=${projection.toPythonStringQuotedOrNone()}" +
                            ")"
                )
            }
        }
    }

    enum class AddSubplotProjectionOptions { aitoff, hammer, lambert, mollweide, polar, rectilinear, `3d` }

    fun show() {
        PythonScriptBuilder.addCommand("$variableName.show()")
    }

    /**
     *  Figure.savefig(self, fname, *, transparent=None, **kwargs):
     */
    fun saveFig(
        fname: String,
        transparent: Boolean = false,
        saveFigKwargs: Map<SaveFigKwargsKeys, KwargValue>? = null
    ) {
        PythonScriptBuilder.addCommand("$variableName.savefig(${fname.toPythonStringQuotedOrEmpty()}, transparent=${transparent.toPythonBooleanOrNone()} ${saveFigKwargs.toKwargPythonStringOrEmpty()} )")
    }

    enum class SaveFigKwargsKeys : KwargKey {
        dpi, quality, optimize, progressive, facecolor, edgecolor, orientation, papertype, format, bbox_inches,
        pad_inches, bbox_extra_artists, backend, metadata, pil_kwargs
    }
}