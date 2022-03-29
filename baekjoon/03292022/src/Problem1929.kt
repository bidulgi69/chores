import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val limit = 1000000
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
    val numbers: List<Int> = readLine()
        .split(" ")
        .map { it.toInt() }

    for (i: Int in numbers[0]..numbers[1]) {
        if (prime[i]) bw.write("$i\n")
    }
    bw.flush()
    bw.close()
}