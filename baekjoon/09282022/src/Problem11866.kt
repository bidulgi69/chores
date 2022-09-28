import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val k = nval.toInt() - 1

    val queue = LinkedList<Int>()
    for (i: Int in 1..n) {
        queue.offer(i)
    }

    val out = mutableListOf<Int>()
    var cur = 0
    while (queue.isNotEmpty()) {
        cur = (cur+k) % queue.size
        out.add(
            queue.removeAt(cur)
        )
    }
    print("<${out.toString().trim { c -> c == '[' || c == ']' }}>")
}