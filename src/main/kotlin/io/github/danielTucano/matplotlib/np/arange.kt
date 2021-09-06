package io.github.danielTucano.matplotlib.np

import io.github.danielTucano.matplotlib.np.NPVar.Companion.npVarNumber
import org.ejml.simple.SimpleMatrix
import io.github.danielTucano.python.PythonScriptBuilder

fun arange(limInf: Double, limSup: Double, step: Double): NPVar {
    return object : NPVar {
        override val variableName: String = "np_var_$npVarNumber"
        init {
            PythonScriptBuilder.addCommand("$variableName = np.arange($limInf,$limSup,$step)")
        }
    }
}

fun meshgrid(xValues: List<Double>, yValues: List<Double>): Pair<SimpleMatrix, SimpleMatrix> {
    val X = SimpleMatrix(
        yValues.map {
            xValues.toDoubleArray()
        }.toTypedArray()
    )

    val Y = SimpleMatrix(
        yValues.mapIndexed { index, _ ->
            DoubleArray(xValues.size) {yValues[index]}
        }.toTypedArray()
    )

    return X to Y
}