package io.github.danielTucano.python

import io.github.danielTucano.python.PythonScriptBuilder.Companion.addCommand
import io.github.danielTucano.python.PythonScriptBuilder.Companion.commandsString
import io.github.danielTucano.python.PythonScriptBuilder.Companion.eraseCommands

/**
 * Erase all commands in memory, fill memory with new commands in "pythonCommands" provided function and execute them
 */
fun pythonExecution(pythonConfig: PythonConfig = PythonConfig.systemDefaultPythonConfig(), pythonCommands: () -> Unit) {
    eraseCommands()
    val pyCommand = PyCommand(pythonConfig)
    addCommand("import matplotlib.pyplot as plt")
    addCommand("import numpy as np")

    pythonCommands()

    pyCommand.execute(commandsString())
}