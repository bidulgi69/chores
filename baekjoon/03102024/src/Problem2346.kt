import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Deque
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val deque: Deque<Pair<Int, Int>> = LinkedList()
    readLine().split(" ")
        .forEachIndexed { i, v ->
            var m = v.toInt()
            if (m > 0) m--
            deque.offer(
                Pair(i+1, m)
            )
        }

    val bw = System.out.bufferedWriter()
    var cursor: Pair<Int, Int>
    var move: Int
    while (!deque.isEmpty()) {
        cursor = deque.poll()
        move = cursor.second
        if (deque.isNotEmpty()) move %= deque.size
        bw.write("${cursor.first} ")

        if (!deque.isEmpty()) {
            while (move != 0) {
                if (move > 0) {
                    deque.offer(deque.poll())
                    move--
                } else {
                    deque.offerFirst(deque.pollLast())
                    move++
                }
            }
        }
    }

    bw.flush()
}