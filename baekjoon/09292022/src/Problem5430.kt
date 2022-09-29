import java.io.StreamTokenizer
import java.util.Deque
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    wordChars('['.code, '['.code)
    wordChars(']'.code, ']'.code)
    wordChars(','.code, ','.code)

    nextToken(); val cases = nval.toInt()
    val deque: Deque<Int> = LinkedList()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        nextToken(); val commands = sval
        nextToken(); val n = nval.toInt()
        nextToken(); val array = sval.substring(1, sval.length-1).split(",").filter { it.isNotEmpty() }

        array.forEach {
            deque.add(it.toInt())
        }

        var reverseCommands = 0
        try {
            commands.forEach { command ->
                when (command) {
                    'R' -> reverseCommands++
                    'D' -> {
                        if (reverseCommands % 2 == 0) {
                            deque.poll() ?: throw IndexOutOfBoundsException()
                        } else deque.pollLast() ?: throw IndexOutOfBoundsException()
                    }
                }
            }

            bw.write("${
                if (reverseCommands % 2 == 0) {
                    deque.toList().toString().replace(" ", "")
                } else {
                    deque.reversed().toString().replace(" ", "")
                }
            }\n")
        } catch (e: IndexOutOfBoundsException) {
            bw.write("error\n")
        }
        deque.clear()
    }
    bw.flush()
    bw.close()
}