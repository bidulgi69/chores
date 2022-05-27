import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val buffers = mutableMapOf<String, Boolean>()
    repeat(n) {
        buffers[readLine()] = true
    }

    val bw = System.out.bufferedWriter()
    var count = 0
    repeat(m) {
        if (buffers.containsKey(readLine())) count++
    }
    bw.write("$count")
    bw.flush()
    bw.close()
}