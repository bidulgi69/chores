package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val numbers = readLine()
        .split(" ")
        .map { it.toInt()
        }

    val dp = Array(n) { Array(3) { 1 } }
    //  오름차순 계산
    for (i: Int in 1 until n) {
        for (j: Int in 0 until i) {
            if (numbers[i] > numbers[j] && dp[i][0] < dp[j][0] + 1) {
                dp[i][0] = dp[j][0] + 1
            }
        }
    }
    //  내림차순 계산
    for (i: Int in n-2 downTo 0) {
        for (j: Int in n-1 downTo i) {
            if (numbers[i] > numbers[j] && dp[i][1] < dp[j][1] + 1) {
                dp[i][1] = dp[j][1] + 1
            }
        }
    }
    //  사이에 낀 경우 계산
    for (i: Int in 1 until n-1) {
        dp[i][2] = dp[i][0] + dp[i][1] - 1  //  현재 인덱스가 겹치므로 1 빼줌.
    }

    var longest = 0
    dp.forEach { values ->
        longest = max(longest, values.maxOf { it })
    }
    print(longest)
}