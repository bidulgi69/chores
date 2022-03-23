import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in 0 until cases) {
        val scores = readLine()
            .split(" ")
            .map { it.toInt() }

        val average = scores
            .subList(1, scores[0]+1)
            .average()

        val pct = scores
            .subList(1, scores[0]+1)
            .filter { it > average }
            .size * 100f / scores[0]
        bw.write("${String.format("%.3f", pct)}%\n")
    }
    bw.flush()
}