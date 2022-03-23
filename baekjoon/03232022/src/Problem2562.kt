import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val numbers = mutableListOf<Int>(3, 29, 38, 12, 57, 74, 40, 85, 61)

    var max = -1
    var maxIndex = 0
    numbers
        .forEachIndexed { index, num ->
            if (num > max) {
                max = num
                maxIndex = index
            }
        }
    bw.write("$max\n$maxIndex")
    bw.flush()
}