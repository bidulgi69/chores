import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = System.out.bufferedWriter()
    while (true) {
        val numbers: Pair<Int, Int> = readLine()
            .split(" ")
            .let { array ->
                Pair(array[0].toInt(), array[1].toInt())
            }
        if (numbers.first == 0 && numbers.second == 0) break
        else bw.write("${numbers.first + numbers.second}\n")
    }
    bw.flush()
}