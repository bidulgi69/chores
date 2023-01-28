import java.io.InputStreamReader
import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(InputStreamReader(System.`in`))) {
    nextToken(); var hour = nval.toInt()
    nextToken(); var minute = nval.toInt()
    nextToken(); var second = nval.toInt()
    nextToken(); var takes = nval.toInt()

    hour += takes / 3600
    takes %= 3600
    minute += takes / 60
    second += takes % 60

    minute += second / 60
    second %= 60

    hour += minute / 60
    minute %= 60

    hour %= 24
    print("$hour $minute $second")
}