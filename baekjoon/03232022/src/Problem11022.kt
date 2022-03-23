import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in 1..cases) {
        val numbers: Pair<Int, Int> = readLine()
            .split(" ")
            .let { array ->
                Pair(array[0].toInt(), array[1].toInt())
            }
        bw.write("Case #$i: ${numbers.first} + ${numbers.second} = ${numbers.first + numbers.second}\n")
    }
    bw.flush()
}