package matplotlib.np

interface NPVar {
    val npVarName: String

    companion object {
        var npVarNumber: Int = 0
            get() {
                field++
                return field
            }
        private set
    }
}