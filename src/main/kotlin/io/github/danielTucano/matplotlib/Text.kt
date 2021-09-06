package io.github.danielTucano.matplotlib

interface Text {

    enum class TextKwargsKeys : KwargKey {
        x, y, text, color, verticalalignment, horizontalignment, multialignment,
        fontproperties, rotation, linespacing, rotation_mode, usetex, wrap, transform_rotates_text,
        fontfamily, fontstyle, fontvariant, fontweight, fontstretch, unit
    }

    enum class TextVerticalAlignmentOptions : KwargValue {
        center, top, bottom, baseline, center_baseline;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextHorizontalAlignmentOptions : KwargValue {
        center, right, left;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextFontFamilyOptions : KwargValue {
        serif, `sans-serif`, cursive, fantasy, monospace;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextFontStyleOptions : KwargValue {
        normal, italic, oblique;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextFontVariantOptions : KwargValue {
        normal, `small-caps`;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextFontWeightOptions : KwargValue {
        ultralight, light, normal, regular, book, medium, roman,
        semibold, demibold, demi, bold, heavy, `extra bold`, black;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextFontStretchOptions : KwargValue {
        `ultra-condensed`, `extra-condensed`, condensed, `semi-condensed`,
        normal, `semi-expanded`, expanded, `extra-expanded`, `ultra-expanded`;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextRotationOptions : KwargValue {
        vertical, horizontal;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

    enum class TextUnitOptions : KwargValue {
        points, pixels;

        override fun toString(): String {
            return "'${this.name}'"
        }
    }

}