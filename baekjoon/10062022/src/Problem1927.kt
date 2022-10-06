import java.io.StreamTokenizer
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val commands = nval.toInt()
    val minHeap = PriorityQueue<Int>()
    val bw = System.out.bufferedWriter()
    repeat(commands) {
        nextToken(); val n = nval.toInt()
        if (n == 0) {
            bw.write("${
                if (minHeap.isEmpty()) 0 else minHeap.poll()
            }\n")
        } else {
            minHeap.offer(n)
        }
    }
    bw.flush()
    bw.close()
}