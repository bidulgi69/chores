import java.io.StreamTokenizer
import java.util.LinkedList

const val max = 200001
val visited = Array(max) { 0 }

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val k = nval.toInt()
    bfs(n, k)
    print(visited[k])
}

private fun bfs(n: Int, k: Int) {
    val queue = LinkedList<Int>()
    queue.offer(n)
    while (!queue.isEmpty()) {
        val x = queue.poll()
        if (x == k) {
            break
        } else {
            val next = visited[x]+1
            val forward = x+1
            val back = x-1
            val teleport = x*2

            if (teleport < max && visited[teleport] == 0) {
                visited[teleport] = next
                queue.offer(teleport)
            }
            if (forward < max && visited[forward] == 0) {
                visited[forward] = next
                queue.offer(forward)
            }
            if (back >= 0 && visited[back] == 0) {
                visited[back] = next
                queue.offer(back)
            }
        }
    }
}