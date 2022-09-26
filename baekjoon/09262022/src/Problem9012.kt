import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StreamTokenizer
import java.util.EmptyStackException
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases = readLine().toInt()
    val stack = Stack<Char>()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        try {
            readLine()
                .forEach { c ->
                    if (c == '(') stack.push(c)
                    else if (c == ')') stack.pop()
                }
            if (stack.isEmpty()) {
                bw.write("YES\n")
            } else {
                bw.write("NO\n")
                stack.clear()
            }
        } catch (ignored: EmptyStackException) {
            bw.write("NO\n")
        }
    }
    bw.flush()
    bw.close()
}