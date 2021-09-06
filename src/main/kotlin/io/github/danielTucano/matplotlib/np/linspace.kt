package io.github.danielTucano.matplotlib.np

/**
 * Creates a list of Doubles equally spaced with "num" number of elements, witch includes "start" and "stop" elements
 */
fun linspace(start: Double, stop: Double, num: Int): List<Double> {

    if (num <= 1) throw IllegalArgumentException("num must be greater then 1")

    val array = MutableList(size = num) { 0.0 }
    val increment = (stop - start)/(num - 1)

    for (i in 0 until num) {
        array[i] = start + i * increment
    }

    return  array.toList()
}