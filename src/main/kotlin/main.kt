import matplotlib.Axes3D
import matplotlib.Axes3D.Scatter3DKwargsKeys
import matplotlib.Figure
import matplotlib.KwargValue.*
import matplotlib.Line2D.Line2DArgs.*
import matplotlib.np.arange
import matplotlib.np.meshgrid
import matplotlib.pyplot.figure
import matplotlib.pyplot.subplots
import matplotlib.show
import python.pythonExecution
import utils.randrange

fun main() {

    pythonExecution {
//        val fig1 = figure()
//        val ax1 = fig1.add_suplot(projection = Figure.AddSubplotProjection.`3d`)
//        val xValues = arange(-1.0, 1.0, 0.25)
//        val yValues = arange(-1.0, 1.0, 0.25)
//        val zValues = arange(-1.0, 1.0, 0.25)
//        val (X, Y, Z) = meshgrid(xValues, yValues, zValues)
//        val (U, V, W) = meshgrid(xValues, yValues, zValues)
//
//        ax1.quiver(X, Y, Z, U, V, W, normalize = true, length = 0.1)
//
//        val (fig2, ax2) = subplots()
//        ax2.plot(
//            x = listOf(0.0, 1.0, 2.0),
//            y = listOf(0.0, 1.0, 2.0),
//            kwargs = mapOf(color to Quoted("r"), linestyle to Quoted("--"), marker to Quoted("o"))
//        )
//        ax2.grid()
//
//        val fig3 = figure()
//        val ax3 = fig3.add_suplot(projection = Figure.AddSubplotProjection.`3d`)
//        val thetaRange = (0..40)
//        val theta = thetaRange.map { it * 4 * Math.PI / thetaRange.last }
//        val x = theta.map { Math.cos(it) }
//        val y = theta.map { Math.sin(it) }
//        val z = thetaRange.map { it * 1.0 / thetaRange.last }
//        ax3.plot(x, y, z, kwargs = mapOf(color to Quoted("r"), linestyle to Quoted("--")))

        val fig4 = figure()
        val ax4 = fig4.add_suplot(projection = Figure.AddSubplotProjection.`3d`)
        val n = 100
        for ((m, zlow, zhigh) in listOf(Triple("o", -50.0, -25.0), Triple("^", -30.0, -5.0))) {
            val xs = randrange(n, 23.0, 32.0)
            val ys = randrange(n, 0.0, 100.0)
            val zs = randrange(n, zlow, zhigh)
            ax4.scatter(xs,ys,zs, kwargs = mapOf(Scatter3DKwargsKeys.marker to Quoted(m)))
        }

        show()
    }

}