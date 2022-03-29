import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val goal = readLine().toInt()
    val bw = System.out.bufferedWriter()
    var i = 1
    var offset = 6
    var iter = 1
    while (i < goal) {
        i += offset
        offset += 6
        iter++
    }

    bw.write("$iter")
    bw.flush()
}
//  1 7 19 37 61
//   6 12 18 24