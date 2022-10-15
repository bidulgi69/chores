import java.io.StreamTokenizer
import kotlin.math.min

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val s = nval.toInt()

    val numbers = Array(n+1) { 0 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    var i = 0
    var j = 0
    var sum = numbers[0]
    var ans = n+1
    while (j < n) {
        if (sum < s) {
            sum += numbers[++j]
        } else {
            ans = min(ans, j-i+1)
            sum -= numbers[i++]
        }
    }

    print(if (ans == n+1) 0 else ans)
}

//  O(n^2)
//val sums = Array(n+1) { 0 }
//    nextToken()
//    sums[1] = nval.toInt()
//    repeat(n-1) {
//        nextToken()
//        sums[it+2] = nval.toInt() + sums[it+1]
//    }
//var i = 0
//var j = 1
//var sum: Int
//var ans = n+1
//while (j <= n) {
//    sum = sums[j]-sums[i]
//    if (sum >= s) {
//        ans = min(ans, j-i)
//        i++
//        j = i+1
//    } else {
//        j++
//    }
//}