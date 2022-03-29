import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val limit = 10000
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

    val m: Int = readLine().toInt()
    val n: Int = readLine().toInt()
    var sum = 0
    var min = n + 1
    for (q: Int in m..n) {
        if (prime[q]) {
            sum += q
            min = min(min, q)
        }
    }
    val bw = System.out.bufferedWriter()
    bw.write("${if (sum == 0) -1 else "$sum\n$min"}")
    bw.flush()
    bw.close()
}