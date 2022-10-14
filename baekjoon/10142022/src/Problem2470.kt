import java.io.StreamTokenizer
import kotlin.math.abs

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val liquids = Array(n) { 0 }
    repeat(n) {
        nextToken(); liquids[it] = nval.toInt()
    }

    liquids.sort()
    var l = 0
    var r = n-1
    var d: Int
    var minDiff = Int.MAX_VALUE
    val ans = intArrayOf(l, r)
    while (r > l) {
        d = liquids[l]+liquids[r]
        if (abs(d) < minDiff) {
            ans[0] = l
            ans[1] = r
            minDiff = abs(d)
        }

        if (d == 0) break
        else if (d < 0) l++
        else r--
    }
    print("${liquids[ans[0]]} ${liquids[ans[1]]}")
}
