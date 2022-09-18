package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val wires = mutableListOf<Pair<Int,Int>>()
    repeat(n) {
        wires.add(
            readLine()
                .split(" ")
                .let { values ->
                    Pair(values[0].toInt(), values[1].toInt())
                }
        )
    }
    //  LIS
    wires.sortBy { it.first }

    //  설치 가능한 전선의 수를 구한다.
    val dp = Array(n) { 1 }
    for (i: Int in 1 until n) {
        for (j: Int in 0 until i) {
            if (!isCrossed(wires[i], wires[j])) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    //  정렬된 마지막 wire 때문에 철거되야 하는 경우가 생길 수 있으므로,
    //  최댓값을 찾아줘야 한다.
    print(n - dp.maxOf { it })
}

fun isCrossed(wire1: Pair<Int, Int>, wire2: Pair<Int, Int>): Boolean {
    return when {
        wire1.first < wire2.first ->  wire1.second > wire2.second
        wire1.first > wire2.first -> wire1.second < wire2.second
        else -> false
    }
}
