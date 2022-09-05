package src

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val cases = readLine().toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        val clothes = readLine().toInt()
        val closets = mutableMapOf<String, MutableList<String>>()
        repeat(clothes) {
            val (clothe, category) = readLine()
                .split(" ")

            val closet = closets.getOrDefault(category, mutableListOf())
            closet.add(clothe)
            closets.putIfAbsent(category, closet)
        }
        val n = try {
            closets.values.map { it.size + 1 }.reduce { acc, i ->  acc * i } - 1
        } catch (e: UnsupportedOperationException) {
            closets.values.map { it.size }.size
        }
        bw.write("${n}\n")
    }
    bw.flush()
    bw.close()
}