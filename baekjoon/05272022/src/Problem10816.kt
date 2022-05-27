import java.io.BufferedReader
import java.io.InputStreamReader

const val OFFSET = 10000000

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val array = IntArray(OFFSET * 2 + 1) { 0 }
    readLine()
        .split(" ")
        .forEach {
            array[it.toInt() + OFFSET]++
        }

    val m = readLine().toInt()
    val bw = System.out.bufferedWriter()
    readLine()
        .split(" ")
        .forEach { value ->
            bw.write("${array[value.toInt() + OFFSET]} ")
        }
    bw.flush()
    bw.close()
}