package matplotlib

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringQuotedOrEmpty
import extensions.toPythonStringQuotedOrNone
import matplotlib.Axes3D.Companion.axes3DNumber
import python.PythonScriptBuilder

interface Figure {

    val figureName: String

    companion object {
        var figureNumber: Int = 0
            get() {
                return field++
            }
            private set
    }

    // TODO add_subplot(projection='3d') -> Should return Axis3D

    fun add_suplot(projection: AddSubplotProjection? = null): Axes3D {
        return object: Axes3D {
            override val axes3DName: String = "axes3d_$axes3DNumber"
            init {
                PythonScriptBuilder.addCommand("$axes3DName = $figureName.add_subplot(" +
                        "projection=${projection.toPythonStringQuotedOrNone()}" +
                        ")")
            }
        }
    }

    enum class AddSubplotProjection {aitoff, hammer, lambert, mollweide, polar, rectilinear, `3d`}

    fun show() {
        PythonScriptBuilder.addCommand("$figureName.show()")
    }

    /**
     *  Figure.savefig(self, fname, *, transparent=None, **kwargs):
     */
    fun saveFig(fname: String, transparent: Boolean = false, saveFigKwargs: Map<SaveFigKwargs, KwargValue>? = null) {
        PythonScriptBuilder.addCommand("$figureName.savefig(${fname.toPythonStringQuotedOrEmpty()}, transparent=${transparent.toPythonBooleanOrNone()} ${saveFigKwargs.toKwargPythonStringOrEmpty()} )")
    }

    enum class SaveFigKwargs: KwargKey {
        dpi, quality, optimize, progressive, facecolor, edgecolor, orientation, papertype, format, bbox_inches,
                pad_inches, bbox_extra_artists, backend, metadata, pil_kwargs
    }
}