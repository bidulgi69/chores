package src

import java.io.BufferedReader
import java.io.InputStreamReader

//lateinit var numbers: Array<Int>
//val bw = System.out.bufferedWriter()
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//
//    val (n, m) = readLine()
//        .split(" ")
//        .map { it.toInt() }
//
//    numbers = Array(n + 1) { 0 }
//    repeat(n) { numbers[it + 1] = it + 1 }
//
//    dfs(m * 2, 0, "")
//    bw.flush()
//    bw.close()
//}
//
//fun dfs(m: Int, here: Int, str: String) {
//    val newStr = if (here != 0) "$str${numbers[here]} " else str
//    if (newStr.length == m) bw.write("$newStr\n")
//    else {
//        for (i: Int in 1 until numbers.size)
//            dfs(m, i, newStr)
//    }
//}