package src

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val factors = readLine()
        .split(" ")
        .map { it.toInt() }

    val min = factors.minOf { it }
    val max = factors.maxOf { it }
    val bw = System.out.bufferedWriter()
    bw.write("${min * max}")
    bw.flush()
    bw.close()
}