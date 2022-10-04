import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toLong()
    nextToken(); val k = nval.toLong()

    //  B[k]=x
    //  x 보다 작거나 같은 원소의 개수 = k
    var lo = 1L
    var hi = n*n

    var x: Long
    var cnt: Long
    var ans = 0L
    while (hi - lo >= 0) {
        x = (hi+lo) / 2
        cnt = 0L
        for (l: Long in 1..n ) {
            cnt += min(x/ l, n)
        }

        if (cnt < k) {
            lo = x+1
        } else {
            hi = x-1
            ans = x
        }
    }
    print(ans)
}