import java.io.StreamTokenizer
import java.util.EmptyStackException
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val stack = Stack<Int>()
    val numbers = Array(n) { 0 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    val op = StringBuilder()
    var c = 1
    var cursor = 0
    try {
        while (cursor < n) {
            val elem = numbers[cursor]
            if (elem == c) {
                c++
                op.append("+\n-\n")
            } else if (elem > c) {
                while (c <= elem) {
                    stack.push(c++)
                    op.append("+\n")
                }

                //  check next
                if (cursor + 1 < n && elem < numbers[cursor + 1]) {
                    stack.pop()
                    op.append("-\n")
                }
            } else if (stack.peek() == elem) {
                stack.pop()
                op.append("-\n")
            } else if (stack.peek() > elem) {
                while (stack.isNotEmpty() && stack.peek() >= elem) {
                    stack.pop()
                    op.append("-\n")
                }
            } else if (stack.peek() < elem) {
                op.clear()
                op.append("NO")
                break
            }
            cursor++
        }

    } catch (e: EmptyStackException) {
        op.clear()
        op.append("NO")
    }
    print(op.toString())
}