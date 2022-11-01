import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val buffer = nval.toInt()
    var n: Double
    var size = 0
    nextToken(); n = nval
    val queue: Queue<Int> = LinkedList()
    while (n != -1.0) {
        if (n == 0.0) {
            queue.poll()
            size--
        } else if (size < buffer) {
            queue.offer(n.toInt())
            size++
        }
        nextToken(); n = nval
    }

    val bw = System.out.bufferedWriter()
    if (queue.isEmpty()) {
        bw.write("empty")
    } else {
        while (!queue.isEmpty()) {
            bw.write("${queue.poll()} ")
        }
    }
    bw.flush()
    bw.close()
}