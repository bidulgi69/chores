import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val limit = 123456 * 2
    val prime = BooleanArray(limit + 1) { true }
    prime[0] = false
    prime[1] = false

    var i = 2
    while (i * i <= limit) {
        if (prime[i]) {
            for (j: Int in i*i..limit step i)
                prime[j] = false
        }
        i++
    }

    val bw = System.out.bufferedWriter()
    var line: Int = readLine().toInt()
    while (line != 0) {
        bw.write("${getNumberOfPrimesBetween(prime, line, line * 2)}\n")
        line = readLine().toInt()
    }
    bw.flush()
    bw.close()
}

fun getNumberOfPrimesBetween(prime: BooleanArray, from: Int, to: Int): Int {
    var numbers = 0
    for (i: Int in from + 1..to)
        if (prime[i]) numbers++
    return numbers
}