import java.io.StreamTokenizer
import java.util.Stack

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val commands = nval.toInt()
    val bw = System.out.bufferedWriter()
    val stack = Stack<Int>()

    repeat(commands) {
        nextToken();
        when (sval) {
            "push" -> {
                nextToken()
                stack.push(nval.toInt())
            }
            "pop" -> {
                bw.write("${
                    if (stack.isEmpty()) -1 else stack.pop()
                }\n")
            }
            "size" -> {
                bw.write("${stack.size}\n")
            }
            "empty" -> {
                bw.write("${
                    if (stack.isEmpty()) 1 else 0
                }\n")
            }
            "top" -> {
                bw.write("${
                    if (stack.isEmpty()) -1 else stack.peek()
                }\n")
            }
            else -> throw UnsupportedOperationException("Invalid command.")
        }
    }

    bw.flush()
    bw.close()
}