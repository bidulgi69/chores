package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val houses = readLine().toInt()
    val dp = Array(houses) { Array(3) { 0 } }
    repeat(houses) { house ->
        val (r, g, b) = readLine()
            .split(" ")
            .map { it.toInt() }
        dp[house][0] = r
        dp[house][1] = g
        dp[house][2] = b
    }

    for (i: Int in 1 until houses) {
        dp[i][0] = dp[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = dp[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = dp[i][2] + min(dp[i-1][0], dp[i-1][1])
    }
    print(dp[houses-1].minOf { it })
}