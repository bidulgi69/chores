import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val a: Int = token.nextToken().toInt()
    val b: Int = token.nextToken().toInt()

    when {
        a < b -> print("<")
        a > b -> print(">")
        else -> print("==")
    }
}