import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val x: Int = readLine().toInt()
    val y: Int = readLine().toInt()
    when {
        x > 0 && y > 0 -> print("1")
        x < 0 && y > 0 -> print("2")
        x < 0 && y < 0 -> print("3")
        x > 0 && y < 0 -> print("4")
    }
}