//package src
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//
//lateinit var dp: Array<Int>
//var recursiveCalled = 1
//var dpCalled = 0
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//
//    val n = readLine().toInt()
//    dp = Array(n + 1) { 0 }
//
//    recursive(n)    //  recursive
//    solve(n)    //  dp
//    print("$recursiveCalled\n$dpCalled")
//}
//
//fun recursive(n: Int): Int {
//    return if (n == 1 || n == 2) 1
//    else {
//        recursiveCalled++
//        recursive(n - 1) + recursive(n - 2)
//    }
//}
//
////  dp
//fun solve(n: Int): Int {
//    dp[1] = 1
//    dp[2] = 2
//    for (i: Int in 3..n) {
//        dpCalled++
//        dp[i] = dp[i - 1] + dp[i - 2]
//    }
//    return dp[n]
//}