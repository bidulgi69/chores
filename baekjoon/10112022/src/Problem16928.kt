import java.io.StreamTokenizer
import java.util.LinkedList

const val max = 101
const val dices = 6

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val l = nval.toInt()
    nextToken(); val s = nval.toInt()

    val ladders = mutableMapOf<Int, Int>()
    val snakes = mutableMapOf<Int, Int>()

    var from: Int
    var to: Int
    repeat(l) {
        nextToken(); from = nval.toInt()
        nextToken(); to = nval.toInt()
        ladders[from] = to
    }
    repeat(s) {
        nextToken(); from = nval.toInt()
        nextToken(); to = nval.toInt()
        snakes[from] = to
    }

    val visited = Array(max) { 0 }
    val queue = LinkedList<Int>()
    queue.offer(1)
    visited[1] = 1
    while (!queue.isEmpty()) {
        val cursor = queue.poll()
        for (i: Int in 1..dices) {
            val next = cursor+i
            if (next < max && visited[next] == 0) {
                visited[next] = visited[cursor] + 1
                if (ladders.containsKey(next)) {
                    if (visited[ladders[next]!!] == 0) visited[ladders[next]!!] = visited[next]
                    queue.offer(ladders[next])
                } else if (snakes.containsKey(next)) {
                    if (visited[snakes[next]!!] == 0) visited[snakes[next]!!] = visited[next]
                    queue.offer(snakes[next])
                } else {
                    queue.offer(next)
                }
            }
        }
    }
    print(visited[max-1]-1)
}