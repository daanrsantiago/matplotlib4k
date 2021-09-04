package matplotlib

import python.PythonScriptBuilder

fun show() {
    PythonScriptBuilder.addCommand("plt.show()")
}