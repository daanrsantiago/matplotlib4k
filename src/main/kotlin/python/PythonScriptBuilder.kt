package python

class PythonScriptBuilder {

    companion object {
        private val commandLines = mutableListOf<String>()

        fun getCommandLines (): List<String> = this.commandLines

        fun addCommand(command: String) {
            this.commandLines.add(command)
        }

        fun commandsString(): String {
            return commandLines.joinToString(separator = "\n")
        }

        fun eraseCommands() {
            this.commandLines.removeAll {true}
        }
    }

}