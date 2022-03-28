import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numbers: List<Int> = readLine().split(" ")
        .map {
            it.reversed().toInt()
        }
    val bw = System.out.bufferedWriter()
    bw.write("${max(numbers[0], numbers[1])}")
    bw.flush()
}