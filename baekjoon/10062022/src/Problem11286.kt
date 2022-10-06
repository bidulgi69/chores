import java.io.StreamTokenizer
import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val commands = nval.toInt()
    //  p.first = 원래 값
    //  p.second = 절대값
    val minHeap = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        if (p1.second == p2.second) {
            p1.first.compareTo(p2.first)
        } else p1.second.compareTo(p2.second)
    }

    val bw = System.out.bufferedWriter()
    repeat(commands) {
        nextToken(); val n = nval.toInt()
        if (n == 0) {
            bw.write("${
                if (minHeap.isEmpty()) 0 else minHeap.poll().first
            }\n")
        } else {
            minHeap.offer(Pair(n, abs(n)))
        }
    }
    bw.flush()
    bw.close()
}