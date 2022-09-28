import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()
    val weights = PriorityQueue<Int> { i1, i2 -> i2.compareTo(i1) } //  desc
    val queue = LinkedList<Document>()
    val bw = System.out.bufferedWriter()

    repeat(cases) {
        nextToken(); val n = nval.toInt()
        nextToken(); val query = nval.toInt()

        repeat(n) {
            nextToken(); val weight = nval.toInt()
            weights.offer(weight)
            queue.offer(Document(it, weight))
        }

        var printedOut = 1
        while (weights.isNotEmpty()) {
            val weight = weights.poll()
            while (queue.peek().weight != weight) {
                queue.offer(
                    queue.poll()
                )
            }

            val doc = queue.poll()
            if (doc.index == query) {
                bw.write("$printedOut\n")
            } else {
                printedOut++
            }
        }

        weights.clear()
        queue.clear()
    }

    bw.flush()
    bw.close()
}

data class Document(
    val index: Int,
    val weight: Int,
)
