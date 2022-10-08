import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val stack = Stack<Int>()
    val numbers = Array(n) { 0 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    for (i: Int in numbers.indices) {
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                numbers[stack.pop()] = numbers[i]
            }
            stack.push(i)
        }
    }
    while (!stack.isEmpty()) {
        numbers[stack.pop()] = -1
    }

    print(numbers.joinToString(" "))
}