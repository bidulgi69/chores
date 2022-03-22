import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val a = token.nextToken().toInt()
    val b = token.nextToken().toInt()
    val c = token.nextToken().toInt()

    print("${(a+b)%c}\n" +
            "${((a%c)+(b%c))%c}\n" +
            "${(a*b)%c}\n" +
            "${((a%c)*(b%c))%c}")
}