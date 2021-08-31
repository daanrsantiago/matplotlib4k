package matplotlib

import java.awt.Color

fun Color?.toPythonTupleString():String {
    return if (this == null) "None" else "(${this.red},${this.green},${this.blue},${this.alpha})"
}