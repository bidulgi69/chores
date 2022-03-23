import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val a: Int = readLine().toInt()
    val b: Int = readLine().toInt()
    val c: Int = readLine().toInt()

    val mul = "${a*b*c}"
    val digits = IntArray(10)
    mul.map {
        digits[it.digitToInt()]++
    }

    digits.forEach {
        bw.write("$it\n")
    }
    bw.flush()
}