import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var line: String?
    val bw = System.out.bufferedWriter()
    while (true) {
        line = readLine() ?: break
        val numbers: Pair<Int, Int> = line
            .split(" ")
            .let { array ->
                Pair(array[0].toInt(), array[1].toInt())
            }
        bw.write("${numbers.first + numbers.second}\n")
    }
    bw.flush()
}