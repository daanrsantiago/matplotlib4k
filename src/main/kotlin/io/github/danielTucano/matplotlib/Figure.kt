package io.github.danielTucano.matplotlib

import io.github.danielTucano.extensions.toPythonBooleanOrNone
import io.github.danielTucano.extensions.toPythonStringQuotedOrEmpty
import io.github.danielTucano.extensions.toPythonStringQuotedOrNone
import io.github.danielTucano.matplotlib.Axes.Companion.axesNumber
import io.github.danielTucano.matplotlib.Axes3D.Companion.axes3DNumber
import io.github.danielTucano.python.PythonScriptBuilder
import io.github.danielTucano.python.PythonVariable

interface Figure: PythonVariable {

    companion object {
        internal var figureNumber: Int = 0
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

    fun add_subplot(projection: AddSubplotProjectionOptions? = null): Axes {
        return when(projection) {
            AddSubplotProjectionOptions.`3d` -> {
                object : Axes3D {
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
            else -> {
                object : Axes {
                    override val variableName: String = "axes_$axesNumber"

                    init {
                        PythonScriptBuilder.addCommand(
                            "$variableName = ${this@Figure.variableName}.add_subplot(" +
                                    "projection='rectilinear'" +
                                    ")"
                        )
                    }
                }
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