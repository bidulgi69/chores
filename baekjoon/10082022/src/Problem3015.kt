import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val heights = Array(n) { 0 }
    val stack = Stack<CustomPair<Int, Int>>()
    repeat(n) {
        nextToken(); heights[it] = nval.toInt()
    }

    var ans = 0L
    for (height: Int in heights) {
        val current = CustomPair(height, 1)
        //  새로 줄을 선 사람의 키가 제일 뒤의 사람(A)보다 크다면,
        //  A는 그 뒤의 사람과는 짝을 이룰 수 없음.
        //  따라서 stack 에서 지워준다.
        while (!stack.isEmpty() && stack.peek().first < height) {
            ans += stack.pop().second
        }

        //  줄에 남은 사람은 새로운 사람의 키보다 크거나 같은 사람들.
        if (!stack.isEmpty()) {
            if (stack.peek().first == height) {
                val sameHeights = stack.pop()    //  키가 같은 경우에도 서로 볼 수 있음
                ans += sameHeights.second
                current.second += sameHeights.second
            }

            if (!stack.isEmpty()) ans++
        }
        stack.push(current)
    }

    print(ans)
}

data class CustomPair<A, B>(
    val first: A,
    var second: B   //  updatable
)