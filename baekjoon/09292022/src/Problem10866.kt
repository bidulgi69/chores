import java.io.StreamTokenizer
import java.util.Deque
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    wordChars('_'.code, '_'.code)   //  allow underscore
    nextToken(); val commands = nval.toInt()
    val deque: Deque<Int> = LinkedList()
    val bw = System.out.bufferedWriter()
    repeat(commands) {
        nextToken()
        when (sval) {
            "push_back" -> {
                nextToken()
                deque.offer(nval.toInt())
            }
            "push_front" -> {
                nextToken()
                deque.offerFirst(nval.toInt())
            }
            "pop_back" -> {
                bw.write("${
                    if (deque.isEmpty()) -1 
                    else deque.pollLast()
                }\n")
            }
            "pop_front" -> {
                bw.write("${
                    if (deque.isEmpty()) -1
                    else deque.poll()
                }\n")
            }
            "size" -> {
                bw.write("${deque.size}\n")
            }
            "empty" -> {
                bw.write("${
                    if (deque.isEmpty()) 1 else 0
                }\n")
            }
            "front" -> {
                bw.write("${
                    if (deque.isEmpty()) -1
                    else deque.peek()
                }\n")
            }
            "back" -> {
                bw.write("${
                    if (deque.isEmpty()) -1
                    else deque.peekLast()
                }\n")
            }
        }
    }
    bw.flush()
    bw.close()
}