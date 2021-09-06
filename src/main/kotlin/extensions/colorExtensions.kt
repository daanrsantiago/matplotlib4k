package matplotlib

import java.awt.Color

fun Color?.toPythonTupleStringOrNone(): String {
    return if (this == null) "None" else "(${this.red / 255},${this.green / 255},${this.blue / 255},${this.alpha / 255})"
}

fun List<Color>?.toPythonColorTupleArrayOrNone(): String {
    return if (this == null) "None" else "[${this.joinToString(separator = ",") { "(${it.red / 255},${it.green / 255},${it.blue / 255},${it.alpha / 255})" }}]"
}