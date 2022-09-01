package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (width, height, x, y, p) = readLine()
        .split(" ")
        .map { it.toDouble() }
    val radius = height / 2

    val rectangle = Rectangle(x, y, width, height)
    val leftHalfCircle = HalfCircle(x, y + radius, radius)
    val rightHalfCircle = HalfCircle(x + width, y + radius, radius)
    var cnt = 0
    repeat(p.toInt()) {
        val (px, py) = readLine()
            .split(" ")
            .map { it.toInt() }

        if (rectangle.isInRectangle(px, py)
            || leftHalfCircle.isInHalfCircle(px, py)
            || rightHalfCircle.isInHalfCircle(px, py)) {
            cnt++
        }
    }

    val bw = System.out.bufferedWriter()
    bw.write("$cnt")
    bw.flush()
    bw.close()
}

data class Rectangle(
    val lx: Double,
    val ly: Double,
    val width: Double,
    val height: Double
) {

    fun isInRectangle(px: Int, py: Int): Boolean {
        return lx <= px && (lx + width) >= px && ly <= py && (ly + height) >= py
    }
}

data class HalfCircle(
    val cx: Double,
    val cy: Double,
    val radius: Double
) {

    fun isInHalfCircle(px: Int, py: Int): Boolean {
        return (px - cx).pow(2.0) + (py - cy).pow(2.0) <= radius.pow(2.0)
    }
}