import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val limit = 10000000
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
    var primeNumber = 2
    var n: Int = readLine().toInt()
    while (n > 1) {
        while (n % primeNumber == 0) {
            n /= primeNumber
            bw.write("$primeNumber\n")
        }
        primeNumber = findNextPrimeNumber(prime, primeNumber)
    }
    bw.flush()
    bw.close()
}

fun findNextPrimeNumber(prime: BooleanArray, current: Int): Int {
    for (i: Int in current + 1 until prime.size) {
        if (prime[i]) return i
    }
    return -1
}