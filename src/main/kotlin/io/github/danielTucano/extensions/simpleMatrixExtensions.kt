package io.github.danielTucano.extensions
import org.ejml.simple.SimpleMatrix

fun SimpleMatrix?.toPythonArrayStringOrEmpty(): String {
    return if (this == null) "" else {
        var result = "["
        result += this[0]
        (1 until (this.numElements - 1)).forEach {
            result += "," + this[it]
        }
        result += ",${this[this.numElements-1]}" + "]"
        result
    }
}

fun SimpleMatrix?.toPythonMatrixStringOrNone(): String {
    return if (this == null) "None" else "np.array([${(0 until this.numRows()).joinToString(separator = ",") { this.rows(it,it+1).toPythonArrayStringOrEmpty() }}])"
}