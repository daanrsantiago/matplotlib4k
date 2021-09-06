package io.github.danielTucano.matplotlib

import io.github.danielTucano.extensions.*
import io.github.danielTucano.python.PythonScriptBuilder
import io.github.danielTucano.python.PythonVariable

interface AxesBase: PythonVariable {

    fun set_xlabel(
        xlabel: String,
        labelpad: Double = 4.0,
        loc: LabelLocOptions = LabelLocOptions.center,
        kwargs: Map<Text.TextKwargsKeys, KwargValue>?
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.set_xlabel(" +
                    "xlabel=${xlabel.toPythonStringQuotedOrEmpty()}," +
                    "labelpad=${labelpad.toPythonStringOrNone()}," +
                    "loc=${loc.toPythonStringQuotedOrNone()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }

    fun set_ylabel(
        ylabel: String,
        labelpad: Double = 4.0,
        loc: LabelLocOptions = LabelLocOptions.center,
        kwargs: Map<Text.TextKwargsKeys, KwargValue>?
    ) {
        PythonScriptBuilder.addCommand(
            "$variableName.set_xlabel(" +
                    "ylabel=${ylabel.toPythonStringQuotedOrEmpty()}," +
                    "labelpad=${labelpad.toPythonStringOrNone()}," +
                    "loc=${loc.toPythonStringQuotedOrNone()}${kwargs.emptyIfNullOrComma()}" +
                    kwargs.toKwargPythonStringOrEmpty() +
                    ")"
        )
    }

    enum class LabelLocOptions { left, center, right }


    fun set_xlim(left: Double? = null, right: Double? = null, xmin: Double? = null, xmax: Double? = null, emit: Boolean = true, auto: Boolean = false) {
        PythonScriptBuilder.addCommand("$variableName.set_xlim(" +
                "left=${left.toPythonStringOrNone()}," +
                "right=${right.toPythonStringOrNone()}," +
                "emit=${emit.toPythonBooleanOrNone()}," +
                "auto=${auto.toPythonStringOrNone()}," +
                "xmin=${xmin.toPythonStringOrNone()}," +
                "xmax=${xmax.toPythonStringOrNone()}" +
                ")")
    }

    fun set_ylim(bottom: Double? = null, top: Double? = null, ymin: Double? = null, ymax: Double? = null, emit: Boolean = true, auto: Boolean = false) {
        PythonScriptBuilder.addCommand("$variableName.set_ylim(" +
                "bottom=${bottom.toPythonStringOrNone()}," +
                "top=${top.toPythonStringOrNone()}," +
                "emit=${emit.toPythonBooleanOrNone()}," +
                "auto=${auto.toPythonStringOrNone()}," +
                "ymin=${ymin.toPythonStringOrNone()}," +
                "ymax=${ymax.toPythonStringOrNone()}" +
                ")")
    }

    fun set_aspect(aspect: AspectOptions, adjustable: AjustableOptions? = null, anchor: AnchorOptions? = null, share: Boolean = false) {
        PythonScriptBuilder.addCommand("$variableName.set_aspect(" +
                "aspect=${aspect.toPythonStringQuotedOrNone()}," +
                "adjustable=${adjustable.toPythonStringQuotedOrNone()}," +
                "anchor=${anchor.toPythonStringQuotedOrNone()}," +
                "share=${share.toPythonBooleanOrNone()}" +
                ")")
    }

    enum class AspectOptions {auto, equal}

    enum class AjustableOptions {box, datalim}

    enum class AnchorOptions {C, SW, S, SE, NW, N, NE, W, E}
}