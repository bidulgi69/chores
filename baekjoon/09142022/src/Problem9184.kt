//package src
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//
//lateinit var dp: Array<Array<Array<Int>>>
//const val len = 21
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    dp = Array(len) { Array(len) { Array(len) { 0 } } }
//    for (i: Int in 0 until len) {
//        for (j: Int in 0 until len) {
//            for (k: Int in 0 until len) {
//                if (i == 0 || j == 0 || k == 0) dp[i][j][k] = 1
//                else if (j in (i + 1) until k) dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k]
//                else dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1]
//            }
//        }
//    }
//    val bw = System.out.bufferedWriter()
//    var line = readLine()
//    while (line != "-1 -1 -1") {
//        val (a, b, c) = line
//            .split(" ")
//            .map { it.toInt() }
//        val (i, j, k) = adjust(a, b, c)
//        bw.write("w($a, $b, $c) = ${dp[i][j][k]}\n")
//        bw.flush()
//        line = readLine()
//    }
//
//    bw.close()
//}
//
//fun adjust(a: Int, b: Int, c: Int): List<Int> {
//    return if (a <= 0 || b <= 0 || c <= 0) listOf(0, 0, 0)
//    else if (a > 20 || b > 20 || c > 20) listOf(20, 20, 20)
//    else return listOf(a, b, c)
//}