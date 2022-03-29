import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.ceil

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tokens = StringTokenizer(readLine())
    val velocity = tokens.nextToken().toInt()
    val slip = tokens.nextToken().toInt()
    val height = tokens.nextToken().toInt()

    var days = 1

    days += ceil((height - velocity) / (velocity - slip).toDouble()).toInt()
    val bw = System.out.bufferedWriter()
    bw.write("$days")
    bw.flush()
}