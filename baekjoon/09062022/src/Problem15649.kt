package src

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val numbers = mutableListOf<Int>()
    repeat(n) { numbers.add(it + 1) }

    //  dfs
    dfs(m, numbers, "")
}

fun dfs(m: Int, neighbors: List<Int>, str: String) {
    if (str.length == m * 2 || neighbors.isEmpty()) {
        println(str)
        return
    } else {
        neighbors.forEach { here ->
            val newNeighbors = neighbors.filter { it != here }
            dfs(m, newNeighbors, "$str$here ")
        }
    }
}