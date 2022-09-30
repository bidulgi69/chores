import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var pixels: Array<Array<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    pixels = Array(n) { Array(n) { 0 } }
    repeat(n) { row ->
        readLine()
            .forEachIndexed { col, c ->
                pixels[row][col] = c.digitToInt()
            }
    }

    print(dq(n, 0, 0))
}

private fun dq(n: Int, i: Int, j: Int): String {
    var sum = 0
    for (q: Int in i until i+n) {
        for (p: Int in j until j+n) {
            sum += pixels[q][p]
        }
    }

    return if (sum != 0 && sum != n*n) {
        //  divide
        val window = n/2
        "(${dq(window, i, j)}${dq(window, i, j+window)}${dq(window, i+window, j)}${dq(window, i+window, j+window)})"
    } else {
        if (sum == 0) "0"
        else "1"
    }
}