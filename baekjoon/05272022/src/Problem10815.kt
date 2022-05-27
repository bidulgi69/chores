import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    val cards: Map<String, Boolean> = readLine()
        .split(" ")
        .associateWith { true }
    val m: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()

    readLine()
        .split(" ")
        .forEach { value ->
            bw.write("${if (cards.contains(value)) "1" else "0"} ")
        }

    bw.flush()
    bw.close()
}