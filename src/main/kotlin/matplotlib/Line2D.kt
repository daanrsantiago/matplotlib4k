package matplotlib

import python.PythonVariable

interface Line2D: PythonVariable {

    override val variableName: String

    companion object {
        var line2DNumber: Int = 0
            get() {
                field++
                return field
            }
        private set
    }

    enum class Line2DArgs: KwargKey {linewidth, linestyle, color, marker, markersize, markeredgewidth, markeredgecolor, markerfacecolor,
        markerfacecoloralt, fillstyle, antialiased, dash_capstyle, solid_capstyle, dash_joinstyle, solid_joinstyle, pickradius,
        drawstyle, markevery}

}