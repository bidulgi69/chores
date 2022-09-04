package src

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var dp: Array<Array<Int>>
const val modulo = 10007

//  이항 연산에 대한 풀이법 정리
//  https://st-lab.tistory.com/159
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    dp = Array(n+1) { Array(k+1) { 0 } }

    //  파스칼 공식
    //  n+1 C r+1 = n C r + n C r+1
    //  n C r = n-1 C r-1 + n-1 C r
    print(explore(n, k))
}

fun explore(n: Int, k: Int): Int {
    //  memoization
    if (n == k || k == 0) {
        dp[n][k] = 1
    } else if (dp[n][k] == 0) {
        dp[n][k] = (explore(n-1, k-1) % modulo + explore(n-1, k) % modulo) % modulo
    }
    return dp[n][k]
}