import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val modulo = mutableSetOf<Int>()
    generateSequence { readLine() }
        .forEach {
            modulo.add(it.toInt() % 42)
        }
    bw.write("${modulo.toSet().size}")
    bw.flush()
}