import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val stack = Stack<Int>()
    val frequencies = mutableMapOf<Int, Int>()
    val numbers = Array(n) { 0 }
    repeat(n) {
        nextToken(); val num = nval.toInt()
        numbers[it] = num
        frequencies[num] = frequencies.getOrDefault(num, 0) + 1
    }

    for (i: Int in numbers.indices) {
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            while (!stack.isEmpty() && frequencies[numbers[stack.peek()]]!! < frequencies[numbers[i]]!!) {
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