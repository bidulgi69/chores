import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val num1 = token.nextToken().toInt()
    val num2 = token.nextToken().toInt()
    print("${num1 + num2}\n" +
            "${num1 - num2}\n" +
            "${num1 * num2}\n" +
            "${num1 / num2}\n" +
            "${num1 % num2}")
}