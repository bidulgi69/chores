import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val number: String = readLine()
    val digits = IntArray(10)   //  0~9

    number
        .forEach { n ->
            digits[n.digitToInt()]++
        }

    val sb = StringBuilder()
    digits
        .forEachIndexed { index, size ->
            repeat(size) {
                sb.append("$index")
            }
        }
    bw.write("${sb.reverse()}")
    bw.flush()
    bw.close()
}