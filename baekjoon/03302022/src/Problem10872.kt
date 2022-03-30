import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val bw = System.out.bufferedWriter()
    bw.write("${factorial(n)}")
    bw.flush()
    bw.close()
}

fun factorial(n: Int): Int {
    return if (n == 0) 1;
    else n * factorial(n - 1)
}