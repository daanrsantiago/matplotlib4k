package io.github.danielTucano.extensions

import io.github.danielTucano.matplotlib.KwargValue

fun Any?.toPythonStringOrNone(): String = this?.toString() ?: "None"

fun Any?.toPythonStringQuotedOrEmpty(): String = if (this == null) "" else "'${this.toString()}'"

fun Any?.toPythonStringQuotedOrNone(): String = if (this == null) "None" else "'${this.toString()}'"

fun Any?.emptyIfNullOrComma(): String = if (this == null) "" else ","

val Any?.quoted get() = KwargValue.Quoted(this.toString())