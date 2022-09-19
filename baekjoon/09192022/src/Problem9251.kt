package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s1 = readLine()
    val s2 = readLine()

    val dp = Array(s1.length + 1) { Array(s2.length + 1) { 0 } }
    var longest = 0
    for (i: Int in dp.indices) {
        for (j: Int in dp[i].indices) {
            if (i > 0 && j > 0) {
                if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                }
                longest = max(longest, dp[i][j])
            }
        }
    }
    print(longest)
}