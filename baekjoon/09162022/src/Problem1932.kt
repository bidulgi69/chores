package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val height = readLine().toInt()
    val leaves = Array(height) { 0 }
    leaves[0] = readLine().toInt()  //  save root
    repeat(height - 1) {

        val numbers = readLine()
            .split(" ")
            .map { it.toInt() }

        for (i: Int in numbers.indices.reversed()) {
            leaves[i] = numbers[i] + max(
                leaves[max(0, i-1)],
                leaves[i]
            )
        }
    }

    print(leaves.maxOf { it })
}
