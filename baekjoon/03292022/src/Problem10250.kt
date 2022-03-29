import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in 0 until cases) {
        val variables: List<String> = readLine()
            .split(" ")
        val height: Int = variables[0].toInt()
        val width: Double = variables[1].toDouble()
        val order: Int = variables[2].toInt()

        val X = ceil(order / height.toDouble()).toInt()
        val Y = order % height

        bw.write("${if (Y == 0) height else Y}${if (X < 10) "0$X" else X}\n")
    }
    bw.flush()
}