import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val calls = nval.toInt()
    val stack = Stack<Int>()

    repeat(calls) {
        nextToken()
        val num = nval.toInt()
        if (num == 0 && stack.isNotEmpty()) {
            stack.pop()
        } else {
            stack.push(num)
        }
    }

    var sum = 0
    while (stack.isNotEmpty()) sum += stack.pop()
    print(sum)
}