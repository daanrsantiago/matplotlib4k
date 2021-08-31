package matplotlib.np

import python.PythonScriptBuilder

fun meshgrid(xMeshValues: NPVar, yMeshValues: NPVar): Pair<NPVar, NPVar> {
    val gridPair = Pair(
        object : NPVar {
            override val npVarName: String = "np_var_${NPVar.npVarNumber}"
        },
        object : NPVar {
            override val npVarName: String = "np_var_${NPVar.npVarNumber}"
        }
    )
    PythonScriptBuilder.addCommand(
        "${gridPair.first.npVarName}, ${gridPair.second.npVarName} =" +
                " np.meshgrid(${xMeshValues.npVarName},${yMeshValues.npVarName})"
    )

    return gridPair
}

fun meshgrid(xMeshValues: NPVar, yMeshValues: NPVar, zMeshValues: NPVar): Triple<NPVar, NPVar, NPVar> {
    val gridTriple = Triple(
        object : NPVar {
            override val npVarName: String = "np_var_${NPVar.npVarNumber}"
        },
        object : NPVar {
            override val npVarName: String = "np_var_${NPVar.npVarNumber}"
        },
        object : NPVar {
            override val npVarName: String = "np_var_${NPVar.npVarNumber}"
        }
    )
    PythonScriptBuilder.addCommand(
        "${gridTriple.first.npVarName}, ${gridTriple.second.npVarName}, ${gridTriple.third.npVarName} =" +
                " np.meshgrid(${xMeshValues.npVarName},${yMeshValues.npVarName},${zMeshValues.npVarName})"
    )

    return gridTriple
}