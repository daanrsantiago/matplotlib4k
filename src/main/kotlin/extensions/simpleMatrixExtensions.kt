package extensions
import org.ejml.simple.SimpleMatrix

fun SimpleMatrix?.toPythonArrayStringOrEmpty(): String {
    return if (this == null) "\'\'" else "[${(0..this.numCols()).joinToString(separator = ",")}]"
}

fun SimpleMatrix?.toPythonMatrixStringOrNone(): String {
    return if (this == null) "None" else "[${(0..this.numRows()).joinToString(separator = ",") { this.rows(it,it).toPythonArrayStringOrEmpty() }}]"
}