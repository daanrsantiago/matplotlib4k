package io.github.danielTucano.matplotlib

import io.github.danielTucano.python.PythonVariable

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