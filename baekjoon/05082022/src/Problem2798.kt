import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = System.out.bufferedWriter()
    val tokens: List<Int> = readLine()
        .split(" ")
        .map { it.toInt() }

    val cards: List<Int> = readLine()
        .split(" ")
        .map { it.toInt() }

    var nearest = -1

    for (i: Int in cards.indices) {
        for (j: Int in i + 1 until tokens[0]) {
            for (k: Int in j + 1 until tokens[0]) {
                val sum: Int = cards[i] + cards[j] + cards[k]
                if (sum <= tokens[1] &&
                    tokens[1] - nearest > tokens[1] - sum)
                    nearest = sum
            }
        }
    }
    bw.write("$nearest")

    bw.flush()
    bw.close()
}