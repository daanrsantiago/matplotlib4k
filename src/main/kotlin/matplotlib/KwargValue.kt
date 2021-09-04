package matplotlib

sealed interface KwargValue {
    open class Quoted(private val value: String): KwargValue {
        override fun toString(): String {
            return "'$value'"
        }
    }

    class Unquoted(private val value: String): KwargValue {
        override fun toString(): String {
            return value
        }
    }
}