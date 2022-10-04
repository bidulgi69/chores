import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val k = nval.toInt()
    nextToken(); val n = nval.toInt()

    val cables = Array(k) { 0 }
    var lo = 1L
    var hi = 0L
    var pivot = 0L
    repeat(k) {
        nextToken()
        val len = nval.toInt()
        cables[it] = len
        pivot += len
        if (hi < len) hi = len.toLong()
    }

    //  binary search
    var ans = 0L
    while (hi - lo >= 0) {
        pivot = (lo+hi) / 2L
        var divided = 0L
        cables.forEach { cable ->
            divided += cable/pivot
        }

        if (divided < n) {
            hi = pivot - 1
        } else {
            lo = pivot + 1
            ans = pivot
        }
    }
    print(ans)
}