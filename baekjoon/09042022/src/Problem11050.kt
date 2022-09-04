package src

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    print(factorial(n) / (factorial(k) * factorial(n - k)))
}

fun factorial(n: Int): Int {
    var num = n
    var factorial = n
    while (--num > 1) {
        factorial *= num
    }
    return if (factorial == 0) 1 else factorial
}