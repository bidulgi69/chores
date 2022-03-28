import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sentence = readLine()
    val bw = System.out.bufferedWriter()

    bw.write("${sentence.split(" ")
        .filter { it.isNotBlank() }
        .size}")
    bw.flush()
}