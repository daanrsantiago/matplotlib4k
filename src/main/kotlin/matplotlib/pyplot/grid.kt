package matplotlib.pyplot

import extensions.toPythonBooleanOrNone
import extensions.toPythonStringQuotedOrEmpty
import python.PythonScriptBuilder

fun grid(
    b: Boolean? = null,
    which: gridWhich = gridWhich.major,
    axis: gridAxis = gridAxis.both
) {
    PythonScriptBuilder.addCommand("plt.grid(b=${b.toPythonBooleanOrNone()},which=${which.toPythonStringQuotedOrEmpty()},axis=${axis.toPythonStringQuotedOrEmpty()})")
}

enum class gridWhich { major, minor, both }
enum class gridAxis { both, x, y }