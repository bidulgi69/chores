package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val numbers = readLine()
        .split(" ")
        .map { it.toInt() }

    val dp = Array(n) { 1 }
    for (i: Int in 1 until n) {
        for (j: Int in 0 until i) {
            if (numbers[i] > numbers[j]) {
                //  이전 인덱스의 LIS 값을 살펴보면서, 현재 값까지 LIS 가 적용될 수 있는지 여부를 검사한다.
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    print(dp.maxOf { it })
}