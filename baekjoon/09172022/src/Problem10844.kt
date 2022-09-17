package src

import java.io.BufferedReader
import java.io.InputStreamReader

const val modulo = 1000000000
const val digit = 10

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    //  가장 뒷자리가 n으로 끝나는 숫자들을 각각 카운팅하기 위해 2차원 배열로 선언.
    val dp = Array(n + 1) { Array(digit) { 0L } }
    try {
        for (i: Int in 1 until digit) {
            dp[0][i] = 1L
        }

        for (i: Int in 1..n) {
            //  0으로 끝나도록 만들어지기 위해선 뒷자리가 1로 끝났어야 함.
            dp[i][0] = dp[i-1][1] % modulo
            //  9로 끝나도록 만들어지기 위해선 뒷자리가 8로 끝났어야 함.
            dp[i][9] = dp[i-1][8] % modulo
            for (j: Int in 1..8) {
                //  j로 끝나도록 만들어지기 위해선 j-1 또는 j+1로 끝났어야 함.
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % modulo
            }
        }
    } catch (ignored: IndexOutOfBoundsException) {}
    print(dp[n-1].sumOf { it } % modulo)
}