package io.github.danielTucano.matplotlib.pyplot

import io.github.danielTucano.extensions.toPythonBooleanOrNone
import io.github.danielTucano.extensions.toPythonStringQuotedOrEmpty
import io.github.danielTucano.python.PythonScriptBuilder

fun grid(
    b: Boolean? = null,
    which: GridWhichOptions = GridWhichOptions.major,
    axis: GridAxisOptions = GridAxisOptions.both
) {
    PythonScriptBuilder.addCommand("plt.grid(b=${b.toPythonBooleanOrNone()},which=${which.toPythonStringQuotedOrEmpty()},axis=${axis.toPythonStringQuotedOrEmpty()})")
}

enum class GridWhichOptions { major, minor, both }
enum class GridAxisOptions { both, x, y }