import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val p = (2.0.pow(n)).toInt() + 1
    println(p*p)
}