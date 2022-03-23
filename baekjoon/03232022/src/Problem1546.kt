import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val size: Int = readLine().toInt()
    val numbers = readLine()
        .split(" ")
        .map { it.toDouble() }
        .toMutableList()

    val max = numbers.maxOf { it }
    bw.write("${numbers.map {
        it / max * 100
    }.average()}")
    bw.flush()
}