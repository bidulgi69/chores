import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var line: String = readLine()
    val bw = System.out.bufferedWriter()
    while (line != "0 0 0") {
        val sides: List<Float> = line
            .split(" ")
            .map { it.toFloat() }
            .sorted()

        bw.write(
            if (sides[0].pow(2) + sides[1].pow(2) == sides[2].pow(2))
                "right\n"
            else "wrong\n"
        )
        line = readLine()
    }
    bw.flush()
    bw.close()
}