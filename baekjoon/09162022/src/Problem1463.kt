package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { 0 }

    try {
        dp[1] = 0
        dp[2] = 1
        dp[3] = 1

        for (i: Int in 4..n) {
            dp[i] = 1 + when {
                i % 3 == 0 && i % 2 == 0 -> {
                    min(min(dp[i / 3], dp[i / 2]), dp[i - 1])
                }
                i % 3 == 0 -> {
                    min(dp[i / 3], dp[i - 1])
                }
                i % 2 == 0 -> {
                    min(dp[i / 2], dp[i - 1])
                }
                else -> {
                    dp[i - 1]
                }
            }
        }
    } catch (ignored: IndexOutOfBoundsException) {}
//    println("dp: ${dp.take(n+1).toList()}")
    print(dp[n])
}