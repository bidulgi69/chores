import java.io.StreamTokenizer
import java.util.Comparator
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val bw = System.out.bufferedWriter()
    val minHeap = PriorityQueue<Int>()  //  larger than median
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder()) //  smaller than median

    var num: Int
    repeat(n) {
        nextToken(); num = nval.toInt()
        minHeap.offer(num)
        maxHeap.offer(minHeap.poll())
        if (maxHeap.size > minHeap.size) {
            minHeap.offer(maxHeap.poll())
        }

        bw.write("${
            if (it % 2 == 0) minHeap.peek()
            else maxHeap.peek()
        }\n")
    }

    bw.flush()
    bw.close()
}