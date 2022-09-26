import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val distances = Array(n-1) { 0L }
    val oils = Array(n) { 0L }
    repeat(n-1) {
        nextToken(); distances[it] = nval.toLong()
    }
    repeat(n) {
        nextToken(); oils[it] = nval.toLong()
    }

    var cost = oils[0] * distances[0]
    var minOil = oils[0]
    for (i: Int in 1 until n-1) {
        if (oils[i] < minOil) minOil = oils[i]
        cost += minOil * distances[i]
    }

    print(cost)
}