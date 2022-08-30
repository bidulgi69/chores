package src

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.System
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numOfMelons = readLine().toInt()
    var maxWidth = 0
    var maxHeight = 0
    var maxWidthIndex = 0
    var maxHeightIndex = 0

    val moves = mutableListOf<Int>()

    //  두 번 반복된 방향에서 작은 사각형의 너비, 높이를 계산해 낼 수 있다.
    repeat(6) {
        val values = readLine()
            .split(" ")
            .map { value -> value.toInt() }
        val direction = values[0]
        val length = values[1]
        moves.add(length)

        when (direction) {
            1, 2 -> {
                if (maxWidth < length) {
                    maxWidth = length
                    maxWidthIndex = it
                }
            }
            3, 4 -> {
                if (maxHeight < length) {
                    maxHeight = length
                    maxHeightIndex = it
                }
            }
        }
    }
    val benchmark = getBenchmark(maxWidthIndex, maxHeightIndex)
    val excludedArea = moves[(benchmark + 2) % 6] * moves[(benchmark + 3) % 6]
    val bw = System.out.bufferedWriter()
    bw.write("${(maxWidth * maxHeight - excludedArea) * numOfMelons}")
    bw.flush()
    bw.close()
}

fun getBenchmark(mw: Int, mh: Int): Int {
    return if (abs(mw - mh) == 1) max(mw, mh) else min(mw, mh)
}