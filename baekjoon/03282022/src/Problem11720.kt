import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size: Int = readLine().toInt()
    val numbers: List<Int> = readLine().map {
        it.digitToInt()
    }
    val bw = System.out.bufferedWriter()
    bw.write("${numbers.sum()}")
    bw.flush()
}