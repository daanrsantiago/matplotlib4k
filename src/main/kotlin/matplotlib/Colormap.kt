package matplotlib

import python.PythonVariable

interface Colormap: PythonVariable {

    override val variableName: String

    companion object {
        var colormapNumber = 0
            get() {
                field++
                return field
            }
        private set
    }

}