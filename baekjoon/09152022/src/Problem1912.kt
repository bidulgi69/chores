package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val numbers = readLine()
        .split(" ")
        .map { it.toInt() }

    val dp = Array(n) { 0 }
    dp[0] = numbers[0]
    for (i: Int in 1 until n) {
        dp[i] = max(dp[i-1] + numbers[i], numbers[i])
    }

    print(dp.maxOf { it })
}