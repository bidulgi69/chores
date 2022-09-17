package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val glasses = Array(n) { 0 }
    val dp = Array(n) { 0 }
    repeat(n) {
        glasses[it] = readLine().toInt()
    }

    try {
        dp[0] = glasses[0]
        dp[1] = glasses[0] + glasses[1]
        dp[2] = max(dp[1], glasses[2] + max(glasses[0], glasses[1]))
        for (i: Int in 3 until n) {
            dp[i] = max(
                dp[i-1],    //  현재 위치의 포도주는 마시지 않음, 이전 까지의 dp 값을 저장.
                glasses[i] + max(   //  현재 위치의 포도주를 마심. dp 값 갱신이 이뤄짐.
                    dp[i-2],
                    dp[i-3] + glasses[i-1]
                )
            )
        }
    } catch (ignored: IndexOutOfBoundsException) {}
    print(dp[n-1])
}
