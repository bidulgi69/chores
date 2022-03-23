import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in n downTo 1)
        bw.write("$i\n")
    bw.flush()
}