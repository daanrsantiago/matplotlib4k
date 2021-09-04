package matplotlib

import python.PythonVariable

interface Colormap: PythonVariable {

    companion object {
        internal var colormapNumber = 0
            get() {
                field++
                return field
            }
        private set
    }

}