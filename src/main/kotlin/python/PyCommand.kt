package python

import com.google.common.base.Strings
import com.google.common.io.Files
import org.slf4j.LoggerFactory
import java.io.*
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import java.util.regex.Pattern
import kotlin.concurrent.thread

class PyCommand(private val pythonConfig: PythonConfig) {

    private fun buildCommandArgs(scriptPath: String): List<String> {
        val shell = StringBuilder()

        if (!pythonConfig.pyenv.isNullOrEmpty()) {
            shell.append("pyenv shell ").append(pythonConfig.pyenv).append("; ")
            if (!Strings.isNullOrEmpty(pythonConfig.virtualenv)) {
                shell.append("export PYENV_VIRTUALENV_DISABLE_PROMPT=1; ")
                shell.append("pyenv activate ").append(pythonConfig.virtualenv).append("; ")
            }
            shell.append("python ").append(scriptPath)
        }

        val commands: List<String> = if (!pythonConfig.pythonBinPath.isNullOrEmpty()) {
            listOf(pythonConfig.pythonBinPath, scriptPath)
        } else if (shell.isNotEmpty()) {
            // -l: Use login shell
            listOf("bash", "-l", "-c", shell.toString())
        } else {
            // system's default
            listOf("python", scriptPath)
        }
        LOGGER.debug("Commands... : {}", commands)
        return commands
    }

    /**
     * Execute the Python script and print its outputs and errors
     */
    @Throws(IOException::class, PythonExecutionException::class)
    private fun command(commands: List<String>) {
        val processBuilder = ProcessBuilder(commands)
        val process = processBuilder.start()

        thread (start = true) {
            // stdout
            var bufferedReader = BufferedReader(InputStreamReader(process.inputStream))
            bufferedReader.forEachLine { line ->
                println(line)
            }

            // stderr
            bufferedReader = BufferedReader(InputStreamReader(process.errorStream))
            val stringBuilder = StringBuilder()
            var hasError = false
            bufferedReader.forEachLine { line ->
                stringBuilder.append(line).append('\n')
                val matcher = ERROR_PAT.matcher(line)
                if (matcher.find()) {
                    hasError = true
                }

                val msg = stringBuilder.toString()
                if (hasError) {
                    LOGGER.error(msg)
                    throw PythonExecutionException("Python execution error: $msg")
                } else {
                    LOGGER.warn(msg)
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun writePythonScriptToFile(pythonScript: String, script: File) {
        val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(script), StandardCharsets.UTF_8))
        bufferedWriter.write(pythonScript)
        bufferedWriter.close()
    }

    /**
     * Write script to temporary file, execute it and exclude it
     */
    @Throws(IOException::class, PythonExecutionException::class)
    fun execute(pythonScript: String) {
        val tmpDir = Files.createTempDir()
        tmpDir.deleteOnExit()
        val scriptFile = File(tmpDir, "exec.py")
        writePythonScriptToFile(pythonScript, scriptFile)
        val scriptPath = Paths.get(scriptFile.toURI()).toAbsolutePath().toString()
        try {
            command(buildCommandArgs(scriptPath))
        } finally {
            tmpDir.delete()
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PyCommand::class.java)
        private val ERROR_PAT = Pattern.compile("^.+Error:")
    }
}