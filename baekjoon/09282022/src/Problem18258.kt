import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val commands = nval.toInt()
    val queue = LinkedList<Int>()

    val bw = System.out.bufferedWriter()
    repeat(commands) {
        nextToken(); val command = sval

        when (command) {
            "push" -> {
                nextToken()
                queue.offer(nval.toInt())
            }
            "pop" -> {
                bw.write("${
                    if (queue.isNotEmpty()) queue.pop()
                    else -1
                }\n")
            }
            "size" -> {
                bw.write("${queue.size}\n")
            }
            "empty" -> {
                bw.write("${if (queue.isEmpty()) 1 else 0}\n")
            }
            "front" -> {
                bw.write("${
                    if (queue.isNotEmpty()) queue.peek()
                    else -1
                }\n")
            }
            "back" -> {
                bw.write("${
                    if (queue.isNotEmpty()) queue.peekLast()
                    else -1
                }\n")
            }
        }
    }
    bw.flush()
    bw.close()
}