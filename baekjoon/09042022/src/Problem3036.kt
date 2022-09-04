package src

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val cases = readLine().toInt()
    val rings = readLine()
        .split(" ")
        .map { it.toInt() }

    val bw = System.out.bufferedWriter()
    for (i: Int in 1 until rings.size) {
        var n1 = rings[0]
        var n2 = rings[i]
        var gcd = getGcd(rings[0], rings[i])
        while (gcd > 1) {
            n1 /= gcd
            n2 /= gcd
            gcd = getGcd(n1, n2)
        }
        bw.write("$n1/$n2\n")
    }

    bw.flush()
    bw.close()
}

fun getGcd(n1: Int, n2: Int): Int {
    var a = n1
    var b = n2
    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }
    return a
}