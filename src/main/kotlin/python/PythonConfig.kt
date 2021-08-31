package python

class PythonConfig private constructor(val pyenv: String?, val virtualenv: String?, val pythonBinPath: String?) {

    companion object {
        @JvmStatic
        fun systemDefaultPythonConfig(): PythonConfig {
            return PythonConfig(null, null, null)
        }

        @JvmStatic
        fun pyenvConfig(pyenv: String?): PythonConfig {
            return PythonConfig(pyenv, null, null)
        }

        @JvmStatic
        fun pyenvVirtualenvConfig(pyenv: String?, virtualenv: String?): PythonConfig {
            return PythonConfig(pyenv, virtualenv, null)
        }

        @JvmStatic
        fun pythonBinPathConfig(pythonBinPath: String?): PythonConfig {
            return PythonConfig(null, null, pythonBinPath)
        }
    }
}