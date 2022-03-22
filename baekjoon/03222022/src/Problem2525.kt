import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    var hour: Int = token.nextToken().toInt()
    var minute: Int = token.nextToken().toInt() + readLine().toInt()

    if (minute > 59) {
        hour = (hour + minute / 60) % 24
        minute %= 60
    }
    print("$hour $minute")
}