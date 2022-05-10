import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val len = readLine().toInt()
    val numbers = readLine()
        .split(" ")
        .map { it.toInt() }

    val dict: Map<Int, Int> = numbers
        .toMutableSet()
        .sorted()
        .let { values ->
            val d = mutableMapOf<Int, Int>()
            values
                .forEachIndexed { index, value ->
                    d[value] = index
                }
            d
        }

    numbers
        .forEach {
            bw.write("${dict[it]} ")
        }
    bw.flush()
    bw.close()
}