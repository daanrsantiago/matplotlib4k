package utils

fun randrange(n: Int, vmin: Double, vmax: Double): List<Double> {
    val range = 0..n
    return range.map { (vmax - vmin) * Math.random() + vmin}
}