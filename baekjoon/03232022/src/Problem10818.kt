import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val size = readLine().toInt()
    val array: List<Int> = readLine()
        .split(" ")
        .map { it.toInt() }

    bw.write("${array.minOf { it }} ${array.maxOf { it }}")
    bw.flush()
}