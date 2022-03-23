import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Stream

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in 1..n) {
        bw.write("${"*".repeat(i)}\n")
    }
    bw.flush()
}