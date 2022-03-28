import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val alphabets = readLine().toCharArray()
    val bw = System.out.bufferedWriter()
    bw.write("${alphabets[0].code}")
    bw.flush()
}