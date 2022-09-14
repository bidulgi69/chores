package src

import java.io.BufferedReader
import java.io.InputStreamReader

const val len = 1000001
const val modulo = 15746
lateinit var dp: Array<Int>
//lateinit var factorials: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    dp = Array(len) { 0 }
//    factorials = Array(len) { 0 }

    dp[1] = 1
    dp[2] = 2
//    factorials[0] = 1
//    factorials[1] = 1

    //  dp[i] = dp[i-1] + dp[i-2] 임을 알 수 있다.
    /*
    for (i: Int in 3..n) {
        var cases = 0
        for (q: Int in 0..i / 2) {
            for (p: Int in 0..i) {
                if (2 * q + p == i) {
                    cases += combo(q + p, min(q, p))
                }
            }
        }
        dp[i] = cases
    }
     */

    for (i: Int in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % modulo
    }
    print(dp[n] % modulo)
}

/*
fun combo(n: Int, r: Int): Int {
    return factorial(n) / (factorial(r) * factorial(n - r))
}

fun factorial(n: Int): Int {
    return if (n <= 1) 1
    else {
        factorials[n] = n * factorial(n - 1)
        return factorials[n]
    }
}
*/