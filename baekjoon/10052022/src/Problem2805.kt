import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val trees = Array(n) { 0 }
    var lo = 1
    var hi = 0
    repeat(n) {
        nextToken(); val height = nval.toInt()
        trees[it] = height
        if (hi < height) hi = height
    }

    var ans = 0
    while (hi - lo >= 0) {
        val mid = (lo+hi) / 2
        var taken = 0L

        trees.forEach { height ->
            taken += max(height - mid, 0)
        }

        if (taken < m) {
            hi = mid-1
        } else {
            lo = mid+1
            ans = mid
        }
    }

    print(ans)
}