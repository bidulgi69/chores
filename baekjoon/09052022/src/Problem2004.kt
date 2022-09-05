package src

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val numerator = getNumberOfTwosAndFives(n)
    val denominator1 = getNumberOfTwosAndFives(m)
    val denominator2 = getNumberOfTwosAndFives(n-m)
    //  nCr = n! / r!(n-r)!
    print(
        min(
            numerator.first - (denominator1.first + denominator2.first),
            numerator.second - (denominator1.second + denominator2.second)
        )
    )
}

fun getNumberOfTwosAndFives(n: Int): Pair<Int, Int> {
    var twos = 0
    var fives = 0
    val num = BigInteger("$n")
    var j = BigInteger("5")
    while (j <= num) {
        fives += num.divide(j).toInt()
        j = j.multiply(BigInteger("5"))
    }

    var i = BigInteger("2")
    while (i <= num) {
        twos += num.divide(i).toInt()
        i = i.multiply(BigInteger("2"))
    }
    return Pair(twos, fives)
}