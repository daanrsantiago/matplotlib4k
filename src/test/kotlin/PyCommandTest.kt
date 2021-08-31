import org.junit.jupiter.api.Test
import python.PyCommand
import python.PythonConfig

internal class PyCommandTest {

    @Test
    fun execute() {

        val pycommand =  PyCommand(PythonConfig.systemDefaultPythonConfig())

        pycommand.execute("print(\"test1\")\nprint(\"test2\")")

    }
}