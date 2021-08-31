package matplotlib

sealed interface KwargValue {
    val value: String
    class Quoted(override val value: String): KwargValue {
        override fun toString(): String {
            return "'$value'"
        }
    }

    class Unquoted(override val value: String): KwargValue {
        override fun toString(): String {
            return value
        }
    }
}