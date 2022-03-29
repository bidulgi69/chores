import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val r: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()

    val pow = r * r
    bw.write("${Math.PI * pow}\n")
    bw.write("${2 * pow}")

    bw.flush()
    bw.close()
}