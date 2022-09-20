import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

//  0-1 knapsack
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    val dp = Array(n+1) { Array(k+1) { 0 } }
    val items = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        items.add(
            readLine()
                .split(" ")
                .map { it.toInt() }
                .let { values ->
                    //  w, v
                    Pair(values[0], values[1])
                }
        )
    }

    for (i: Int in dp.indices) {
        for (j: Int in dp[i].indices) {
            if (i > 0 && j > 0) {
                if (items[i-1].first <= j) {
                    dp[i][j] = max(dp[i-1][j], items[i-1].second + dp[i-1][j - items[i-1].first])
                } else {
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
    }

    print(dp[n][k])
}

//  dp 를 1차원 배열로 해서 풀 수도 있다.
/*
fun solve() {
    val cache = IntArray(k + 1)

    for (p in products) {
        for (i in k downTo p.first) {
            cache[i] = max(cache[i], cache[i - p.first] + p.second)
        }
    }

    println(cache[k])
}
 */