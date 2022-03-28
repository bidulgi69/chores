import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i: Int in 0 until cases) {
        val case: List<String> = readLine().split(" ")
        val repeat = case[0].toInt()
        bw.write("${case[1].map {
            "$it".repeat(repeat)
        }.joinToString(prefix = "", postfix = "", separator = "")}\n")
    }
    bw.flush()
}