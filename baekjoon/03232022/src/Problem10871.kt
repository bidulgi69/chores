import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val size: Int = token.nextToken().toInt()
    val n: Int = token.nextToken().toInt()

    val bw = System.out.bufferedWriter()
    for (i: Int in readLine()
        .split(" ")
        .map { it.toInt() }) {
        if (i < n)
            bw.write("$i ")
    }
    bw.flush()
}