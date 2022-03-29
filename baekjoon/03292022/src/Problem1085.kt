import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tokens = StringTokenizer(readLine())
    val x: Int = tokens.nextToken().toInt()
    val y: Int = tokens.nextToken().toInt()
    val w: Int = tokens.nextToken().toInt()
    val h: Int = tokens.nextToken().toInt()

    val distances = mutableListOf<Int>().apply {
        add(x - 0)
        add(y - 0)
        add(w - x)
        add(h - y)
    }
    val bw = System.out.bufferedWriter()
    bw.write("${distances.minOf { it }}")
    bw.flush()
    bw.close()
}