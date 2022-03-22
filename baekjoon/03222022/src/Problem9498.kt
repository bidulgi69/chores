import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val score: Int = readLine().toInt()
    when {
        90 <= score -> print("A")
        80 <= score -> print("B")
        70 <= score -> print("C")
        60 <= score -> print("D")
        else -> print("F")
    }
}