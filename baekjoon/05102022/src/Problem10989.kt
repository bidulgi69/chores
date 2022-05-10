import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val repeats = readLine().toInt()

    val counts = mutableMapOf<Int, Int>()
    var max = -1
    repeat(repeats) {
        val number = readLine().toInt()
        counts[number] = counts.getOrDefault(number, 0) + 1
        max = max(max, number)
    }

    counts
        .entries
        .sortedBy { it.key }
        .forEach { entry ->
            repeat(entry.value) {
                bw.write("${entry.key}\n")
            }
        }
    bw.flush()
    bw.close()
}