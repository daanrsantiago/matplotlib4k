package matplotlib.np

import python.PythonScriptBuilder

fun meshgrid(xMeshValues: NPVar, yMeshValues: NPVar): Pair<NPVar, NPVar> {
    val gridPair = Pair(
        object : NPVar {
            override val variableName: String = "np_var_${NPVar.npVarNumber}"
        },
        object : NPVar {
            override val variableName: String = "np_var_${NPVar.npVarNumber}"
        }
    )
    PythonScriptBuilder.addCommand(
        "${gridPair.first.variableName}, ${gridPair.second.variableName} =" +
                " np.meshgrid(${xMeshValues.variableName},${yMeshValues.variableName})"
    )

    return gridPair
}

fun meshgrid(xMeshValues: NPVar, yMeshValues: NPVar, zMeshValues: NPVar): Triple<NPVar, NPVar, NPVar> {
    val gridTriple = Triple(
        object : NPVar {
            override val variableName: String = "np_var_${NPVar.npVarNumber}"
        },
        object : NPVar {
            override val variableName: String = "np_var_${NPVar.npVarNumber}"
        },
        object : NPVar {
            override val variableName: String = "np_var_${NPVar.npVarNumber}"
        }
    )
    PythonScriptBuilder.addCommand(
        "${gridTriple.first.variableName}, ${gridTriple.second.variableName}, ${gridTriple.third.variableName} =" +
                " np.meshgrid(${xMeshValues.variableName},${yMeshValues.variableName},${zMeshValues.variableName})"
    )

    return gridTriple
}