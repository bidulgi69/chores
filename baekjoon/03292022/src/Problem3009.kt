import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val pointX = IntArray(1001) { 0 }
    val pointY = IntArray(1001) { 0 }
    repeat(3) {
        with(readLine()) {
            split(" ")
                .map { it.toInt() }
                .let { point ->
                    pointX[point[0]]++
                    pointY[point[1]]++
                }
        }
    }

    val bw = System.out.bufferedWriter()
    bw.write("${pointX.indexOf(1)} ${pointY.indexOf(1)}")
    bw.flush()
    bw.close()
}