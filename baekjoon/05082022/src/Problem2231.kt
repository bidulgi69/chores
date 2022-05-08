import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val target: Int = readLine().toInt()

    bw.write("${getMinimumConstructor(target)}")
    bw.flush()
    bw.close()
}

fun getMinimumConstructor(target: Int): Int {
    for (i: Int in target / 2..target) {
        val sum = i + "$i".sumOf { it.digitToInt() }
        if (sum == target) return i
    }
    return 0
}