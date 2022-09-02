package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n1, n2) = readLine()
        .split(" ")
        .map { it.toInt() }
    val bw = System.out.bufferedWriter()

    //  최소 공배수
    var ld = 1
    var x = min(n1, n2)
    while (x != 1) {
        if (n1 % x == 0 && n2 % x == 0) {
            n1 /= x
            n2 /= x
            ld *= x
            x = min(n1, n2)
        } else {
            x--
        }
    }
    bw.write("$ld\n${ld * n1 * n2}")

    bw.flush()
    bw.close()
}