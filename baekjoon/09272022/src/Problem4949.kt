import java.io.StreamTokenizer
import java.util.EmptyStackException
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    val stack = Stack<Char>()

    val bw = System.out.bufferedWriter()
    var sentence = readLine()
    while (sentence != null && sentence != ".") {
        try {
            for (c: Char in sentence) {
                if (c == '(' || c == '[') {
                    stack.push(c)
                } else if (c == ')') {
                    if (stack.peek() == '(') stack.pop()
                    else break
                } else if (c == ']') {
                    if (stack.peek() == '[') stack.pop()
                    else break
                }
            }
            bw.write("${
                if (stack.isEmpty()) "yes" else "no"
            }\n")
        } catch (e: EmptyStackException) {
            bw.write("no\n")
        }

        sentence = readLine()
        stack.clear()
    }
    bw.flush()
    bw.close()
}