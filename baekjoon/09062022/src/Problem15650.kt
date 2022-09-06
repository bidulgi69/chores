package src

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var numbers: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    if (n == m) {
        repeat(n) { print("${it + 1} ") }
    } else {
        numbers = Array(n + 1) { 0 }
        repeat(n) { numbers[it + 1] = it + 1 }
        dfs(m * 2, 0, "")
    }
}

fun dfs(m: Int, here: Int, str: String) {
    val newStr = if (here != 0) "$str${numbers[here]} " else str
    if (newStr.length == m) println(newStr)
    else {
        for (i: Int in here + 1 until numbers.size) {
            dfs(m, i, newStr)
        }
    }
}
