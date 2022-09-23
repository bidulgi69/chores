import java.io.InputStreamReader
import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(InputStreamReader(System.`in`))) {
    nextToken(); val n = nval.toInt()
    nextToken(); val k = nval.toInt()

    val coins = Array(n) { 0 }
    repeat(n) {
        nextToken(); coins[it] = nval.toInt()
    }

    var min = Int.MAX_VALUE
    for (i: Int in coins.indices) {
        if (coins[i] > k) break
        var usedCoins = 0
        var left = k
        for (j: Int in i downTo 0) {
            if (left != 0) {
                usedCoins += left / coins[j]
                left %= coins[j]
            } else break
        }

        if (left == 0 && usedCoins < min) {
            min = usedCoins
        }
    }
    print(min)
}