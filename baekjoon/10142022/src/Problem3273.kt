import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val numbers = Array(n) { 0 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    nextToken(); val x = nval.toInt()
    numbers.sort()
    var ans = 0
    var l = 0
    var r = n-1
    var sum: Int
    while (r > l) {
        sum = numbers[l] + numbers[r]
        if (sum == x) {
            ans++
            l++
            r--
        } else if (sum < x) {
            l++
        } else {    //  sum > x
            r--
        }
    }
    print(ans)
}