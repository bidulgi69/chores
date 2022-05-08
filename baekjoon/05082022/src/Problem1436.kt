import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()

    val evil = "666"
    var cnt = 0
    var value = 0
    for (i: Int in 666..Int.MAX_VALUE) {
        if ("$i".contains(evil)) cnt++

        if (cnt == n) {
            value = i
            break
        }
    }

    bw.write("$value")
    bw.flush()
    bw.close()
}