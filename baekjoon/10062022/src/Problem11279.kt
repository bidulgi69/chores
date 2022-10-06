import java.io.StreamTokenizer
import java.util.Comparator
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val commands = nval.toInt()
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    val bw = System.out.bufferedWriter()
    repeat(commands) {
        nextToken(); val n = nval.toInt()
        if (n == 0) {
            bw.write("${
                if (maxHeap.isEmpty()) 0 else maxHeap.poll()
            }\n")
        } else {
            maxHeap.offer(n)
        }
    }
    bw.flush()
    bw.close()
}