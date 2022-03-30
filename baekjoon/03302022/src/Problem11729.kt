import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

val bw = System.out.bufferedWriter()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    bw.write("${2f.pow(n).toInt() - 1}\n")
    hanoi(n, 1, 3, 2)
    bw.flush()
    bw.close()
}

fun hanoi(n: Int, from: Int, to: Int, through: Int) {
    if (n == 1) {
        bw.write("$from $to\n")
    } else {
        hanoi(n - 1, from, through, to)
        bw.write("$from $to\n")
        hanoi(n - 1, through, to, from)
    }
}