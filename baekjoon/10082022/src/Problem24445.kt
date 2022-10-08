import java.io.StreamTokenizer
import java.util.LinkedList

private var order = 1

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()
    nextToken(); val here = nval.toInt()-1

    val visited = Array(n) { 0 }
    val edges = mutableMapOf<Int, MutableList<Int>>()
    repeat(m) {
        nextToken(); val v1 = nval.toInt()-1
        nextToken(); val v2 = nval.toInt()-1

        val v1Neighbors = edges.getOrDefault(v1, mutableListOf())
        val v2Neighbors = edges.getOrDefault(v2, mutableListOf())
        v1Neighbors.add(v2)
        v2Neighbors.add(v1)

        edges[v1] = v1Neighbors
        edges[v2] = v2Neighbors
    }

    for (i: Int in 0 until n) {
        edges[i] ?. sortDescending()
    }

    bfs(visited, edges, here)
    val bw = System.out.bufferedWriter()
    visited.forEach {
        bw.write("$it\n")
    }
    bw.flush()
    bw.close()
}

private fun bfs(visited: Array<Int>, edges: Map<Int, MutableList<Int>>, here: Int) {
    val queue = LinkedList<Int>()
    queue.offer(here)
    visited[here] = order++
    while (!queue.isEmpty()) {
        val v = queue.poll()
        edges[v] ?. let { neighbors ->
            neighbors.forEach { neighbor ->
                if (visited[neighbor] == 0) {
                    queue.offer(neighbor)
                    visited[neighbor] = order++
                }
            }
        }
    }
}