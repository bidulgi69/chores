import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    var hour: Int = token.nextToken().toInt()
    var minute: Int = token.nextToken().toInt() - 45

    if (minute < 0) {
        minute += 60
        if (hour - 1 < 0) hour = 23
        else hour -= 1
    }
    print("$hour $minute")
}