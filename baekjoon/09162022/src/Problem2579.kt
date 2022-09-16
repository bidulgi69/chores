package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val stairs = Array(n) { 0 }
    val dp = Array(n) { 0 }
    repeat(n) {
        stairs[it] = readLine().toInt()
    }

    try {
        dp[0] = stairs[0]
        dp[1] = stairs[1] + stairs[0]
        //  0 -> 2 or 1 -> 2
        dp[2] = stairs[2] + max(stairs[0], stairs[1])
        for (i: Int in 3 until n) {
            dp[i] = stairs[i] + max(
                //  누적된 최고 값을 사용해 하위 문제들을 해결한다.
                dp[i - 3] + stairs[i - 1],  //  연속된 계단을 밟는 경우 (이 전 계단 값은 dp 사용하면 안됨)
                dp[i - 2] //  점프해서 현재 계단으로 온 경우
            )
        }
    } catch (ignored: IndexOutOfBoundsException) { }
    print(dp[n-1])
}