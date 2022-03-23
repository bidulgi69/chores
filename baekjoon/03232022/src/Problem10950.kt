import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    for (i: Int in 0 until cases) {
        val numbers: Pair<Int, Int> = readLine()
            .split(" ")
            .let { array ->
                Pair(array[0].toInt(), array[1].toInt())
            }
        println(numbers.first + numbers.second)
    }
}