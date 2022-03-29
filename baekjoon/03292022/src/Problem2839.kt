import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val kilo: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()

    var bags = Int.MAX_VALUE
    for (i: Int in kilo / 5 downTo 0) {
        for (j: Int in 0..kilo / 3) {
            if (5 * i + 3 * j == kilo) bags = min(bags, i + j)
        }
    }

    bw.write("${if (bags == Int.MAX_VALUE) -1 else bags}")
    bw.flush()
    bw.close()
}