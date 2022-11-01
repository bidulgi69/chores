import java.io.StreamTokenizer
import java.util.Deque
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val numbers = IntArray(n)
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    val dp = Array(n) { Array(2) { 0 } }
    for (i: Int in 0 until n) {
        dp[i][0] = 1
    }
    var of = 0
    var ans = 1
    for (i: Int in 1 until n) {
        for (j: Int in 0 until i) {
            if (numbers[i] > numbers[j] && dp[i][0] < dp[j][0]+1) {
                dp[i][0] = dp[j][0]+1
                dp[i][1] = j
            }
            if (dp[i][0] > ans) {
                ans = dp[i][0]
                of = i
            }
        }
    }

    val bw = System.out.bufferedWriter()
    var len = 0
    val deque: Deque<Int> = LinkedList()
    while (len < ans) {
        deque.offerFirst(numbers[of])
        of = dp[of][1]
        len++
    }
    bw.write("$ans\n")
    while (!deque.isEmpty()) {
        bw.write("${deque.poll()} ")
    }
    bw.flush()
    bw.close()
}
