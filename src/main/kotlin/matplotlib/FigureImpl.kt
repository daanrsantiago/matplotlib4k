package matplotlib

import matplotlib.Figure.Companion.figureNumber
import python.PythonScriptBuilder
import java.awt.Color

class FigureImpl(
    figsize: Pair<Float, Float>? = null,
    dpi: Float? = null,
    faceColor: Color? = null,
    edgeColor: Color? = null,
    lineWidth: Double = 0.0,
    frameOn: Boolean? = null,
    tightLayout: Boolean? = null,
    constrainedLayout: Boolean? = null
): Figure {

    override val figureName: String = "figure_${Figure.figureNumber}"

    init {
        PythonScriptBuilder.addCommand(
            """$figureName = Figure(
            |figsize = ${figsize ?: "(${figsize?.first},${figsize?.second})"},
            |dpi = $dpi,
            |facecolor = ${faceColor.toPythonTupleString()},
            |edgecolor = ${edgeColor.toPythonTupleString()},
            |lineWidth = $lineWidth,
            |frameon = ${frameOn ?: "None"},
            |tight_layout = ${tightLayout ?: "None"},
            |constrained_layout = ${constrainedLayout ?: "None"}
            |)""".trimMargin()
        )
    }

}

