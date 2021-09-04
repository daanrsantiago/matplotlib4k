package matplotlib

import java.awt.Color

fun Color?.toPythonTupleString():String {
    return if (this == null) "None" else "(${this.red/255},${this.green/255},${this.blue/255},${this.alpha/255})"
}