import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val costs = Array(n) { 0 }
    repeat(n) {
        nextToken()
        costs[it] = nval.toInt()
    }

    costs.sort()
    for (i: Int in 1 until n) {
        costs[i] += costs[i-1]
    }

    print(costs.sum())
}