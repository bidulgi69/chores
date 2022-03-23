import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in 1..n) {
        val blank = " ".repeat(n - i)
        val stars = "*".repeat(i)
        bw.write("$blank$stars\n")
    }
    bw.flush()
}