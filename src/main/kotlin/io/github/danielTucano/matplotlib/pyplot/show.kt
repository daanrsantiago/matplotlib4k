package io.github.danielTucano.matplotlib

import io.github.danielTucano.python.PythonScriptBuilder

fun show() {
    PythonScriptBuilder.addCommand("plt.show()")
}