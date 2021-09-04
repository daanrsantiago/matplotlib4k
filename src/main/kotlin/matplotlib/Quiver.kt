package matplotlib

interface Quiver: Artist {

    companion object {
        internal var quiverNumber: Int = 0
            get() {
                field++
                return field
            }
            private set
    }

}