import java.io.StreamTokenizer
import java.util.Stack
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val stack = Stack<Int>()
    val heights = Array(n+2) { 0 }

    repeat(n) {
        nextToken(); heights[it+1] = nval.toInt()
    }

    var ans = 0
    stack.push(0)
    for (i: Int in 1..n+1) {
        while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
            val h = heights[stack.pop()]
            val w = i-1-stack.peek()
            ans = max(ans, h*w)
        }

        stack.push(i)
    }

    print(ans)
}