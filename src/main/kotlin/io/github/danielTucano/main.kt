import io.github.danielTucano.matplotlib.*
import io.github.danielTucano.matplotlib.pyplot.*
import io.github.danielTucano.python.pythonExecution
import java.awt.Color

/**
 * main function for demonstration porpouses
 */
fun main() {

    pythonExecution {
//        val fig1 = figure()
//        val ax1 = fig1.add_subplot(projection = Figure.AddSubplotProjectionOptions.`3d`)
//        val xValues = arange(-1.0, 1.0, 0.25)
//        val yValues = arange(-1.0, 1.0, 0.25)
//        val zValues = arange(-1.0, 1.0, 0.25)
//        val (X, Y, Z) = meshgrid(xValues, yValues, zValues)
//        val (U, V, W) = meshgrid(xValues, yValues, zValues)
//
//        ax1.quiver(X, Y, Z, U, V, W, normalize = true, length = 0.1)

//        val (fig2, ax2) = subplots()
//        ax2.plot(
//            x = listOf(0.0, 1.0, 2.0),
//            y = listOf(0.0, 1.0, 2.0),
//            kwargs = mapOf(Line2D.Line2DArgs.color to KwargValue.Quoted("r"), Line2D.Line2DArgs.linestyle to KwargValue.Quoted("--"), Line2D.Line2DArgs.marker to KwargValue.Quoted(
//                "o"
//            )
//            )
//        )
//        ax2.grid()

//        val fig3 = figure()
//        val ax3 = fig3.add_subplot(projection = Figure.AddSubplotProjectionOptions.`3d`)
//        val thetaRange = (0..40)
//        val theta = thetaRange.map { it * 4 * Math.PI / thetaRange.last }
//        val x = theta.map { cos(it) }
//        val y = theta.map { sin(it) }
//        val z = thetaRange.map { it * 1.0 / thetaRange.last }
//        ax3.plot(x, y, z, kwargs = mapOf(Line2D.Line2DArgs.color to KwargValue.Quoted("r"), Line2D.Line2DArgs.linestyle to KwargValue.Quoted(
//            "--"
//        )
//        ))
//
//        val fig4 = figure()
//        val ax4 = fig4.add_subplot(projection = Figure.AddSubplotProjectionOptions.`3d`) as Axes3D
//        val n = 100
//        for ((m, zlow, zhigh) in listOf(Triple("o", -50.0, -25.0), Triple("^", -30.0, -5.0))) {
//            val xs = randrange(n, 23.0, 32.0)
//            val ys = randrange(n, 0.0, 100.0)
//            val zs = randrange(n, zlow, zhigh)
//            ax4.scatter(xs,ys,zs, kwargs = mapOf(Axes3D.Scatter3DKwargsKeys.marker to m.quoted))
//        }

//        val fig5 = figure()
//        val ax5 = fig5.add_subplot(projection = Figure.AddSubplotProjectionOptions.`3d`)
//        val (X_5, Y_5) = meshgrid(arange(-10.0,10.0,0.1), arange(-10.0,10.0,0.1))
//        val R_5 = sqrt(X_5.pow(2) + Y_5.pow(2))
//        val Z_5 = io.github.danieltucano.matplotlib.np.sin(R_5)
//        ax5.plot_surface(X_5,Y_5,Z_5,cmap = ColorMaps.coolwarm)

//        val (_, ax) = subplots()
//        quiver(
//            listOf(0.0, 1.0),
//            listOf(0.0, 0.0),
//            listOf(0.0, 0.5),
//            listOf(1.0, 1.0),
//            scale = 1.0,
//            scale_units = Axes.QuiverScaleUnitsOptions.xy,
//            angles = Axes.QuiverAnglesOptions.xy,
//            color = listOf(Color.BLUE, Color.RED)
//        )
//        xlim(-0.1,2.0)
//        ylim(-1.0,1.0)
//        grid()

        val fig6 = figure()
        val ax6 = fig6.add_subplot(projection = Figure.AddSubplotProjectionOptions.`3d`) as Axes3D
        ax6.quiver(
            xValues = listOf(0.0),
            yValues = listOf(0.0),
            zValues = listOf(0.0),
            uValues = listOf(1.0),
            vValues = listOf(0.0),
            wValues = listOf(0.0),
            colors = listOf(
                Color.GREEN,
                Color.BLUE
            )
        )
        xlabel("X")
        ylabel("Y")
        ax6.set_zlabel("Z")
        xlim(-1.0, 1.0)
        ylim(-1.0, 1.0)
        ax6.set_zlim3d(-1.0, 1.0)

        show()
    }

//    pythonExecution {
//        val (_, ax) = subplots()
//        ax.plot(listOf(0.0,1.0,2.0,3.0), listOf(1.0,3.0,0.5,2.0))
//        ax.grid()
//        title("Title")
//        show()
//    }

}