import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val limit = 1000
    val numbers: List<Int> = readLine()
        .split(" ")
        .map { it.toInt() }

    val prime = BooleanArray(limit + 1) { true }
    prime[0] = false
    prime[1] = false    //  not a prime number
    var i = 2
    while (i * i <= limit) {
        if (prime[i]) {
            for (j: Int in i * i..limit step i) {
                prime[j] = false
            }
        }
        i++
    }
    val bw = System.out.bufferedWriter()
    bw.write("${numbers.filter{ prime[it] }.size}")
    bw.flush()
    bw.close()
}