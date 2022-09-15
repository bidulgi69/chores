package src

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var sequences: Array<Long>
const val len = 101

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val cases = readLine().toInt()
    val bw = System.out.bufferedWriter()

    sequences = Array(len) { 0 }
    sequences[1] = 1
    sequences[2] = 1
    sequences[3] = 1

    val numbers = Array(cases) { 0 }
    repeat(cases) { offset ->
        numbers[offset] = readLine().toInt()
    }

    for (i: Int in 4..numbers.maxOf { it }) {
        sequences[i] = sequences[i-3] + sequences[i-2]
    }

    numbers.forEach { n ->
        bw.write("${sequences[n]}\n")
    }
    bw.flush()
    bw.close()
}