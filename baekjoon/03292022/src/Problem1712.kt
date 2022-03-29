import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.ceil

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tokens = StringTokenizer(readLine())
    val bw = System.out.bufferedWriter()
    val fixed: Long = tokens.nextToken().toLong()
    val production: Long = tokens.nextToken().toLong()
    val price: Long = tokens.nextToken().toLong()

    //  판매 대수 = x
    //  fixed + x * production < x * price
    //  x(price - production) > fixed
    //  x > fixed / (price - production)
    if (price - production <= 0) bw.write("-1")
    else {
        var breakPoint = ceil(fixed.toDouble() / (price - production))
        if (breakPoint * (price - production) <= fixed) breakPoint++
        bw.write("${breakPoint.toInt()}")
    }
    bw.flush()
}