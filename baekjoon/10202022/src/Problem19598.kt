import java.io.StreamTokenizer
import java.util.PriorityQueue
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        if (p1.first == p2.first) p1.second - p2.second
        else p1.first - p2.first
    }

    var s: Int
    var e: Int
    repeat(n) {
        nextToken(); s = nval.toInt()
        nextToken(); e = nval.toInt()
        pq.offer(Pair(s, e))
    }

    var ans = 0
    val rooms = PriorityQueue<Int>()
    while (!pq.isEmpty()) {
        val (start, end) = pq.poll()
        ans = if (rooms.isEmpty()) {
            rooms.offer(end)
            1
        } else {
            while (!rooms.isEmpty() && start >= rooms.peek()) {
                rooms.poll()
            }
            rooms.offer(end)
            max(ans, rooms.size)
        }
    }

    print(ans)
}