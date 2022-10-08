import java.io.StreamTokenizer
import java.util.LinkedList

val bw = System.out.bufferedWriter()
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()
    nextToken(); val here = nval.toInt()

    val visited = Array(n+1) { false }
    val edges = mutableMapOf<Int, MutableList<Int>>()
    repeat(m) {
        nextToken(); val v1 = nval.toInt()
        nextToken(); val v2 = nval.toInt()

        val v1Neighbors = edges.getOrDefault(v1, mutableListOf())
        val v2Neighbors = edges.getOrDefault(v2, mutableListOf())
        if (!v1Neighbors.contains(v2)) v1Neighbors.add(v2)
        if (!v2Neighbors.contains(v1)) v2Neighbors.add(v1)
        edges[v1] = v1Neighbors
        edges[v2] = v2Neighbors
    }

    for (i: Int in 1..n) {
        edges[i] ?. sort()
    }

    dfs(visited, edges, here)

    //  initialize
    bw.appendLine()
    for (i: Int in 1..n) visited[i] = false

    bfs(visited, edges, here)

    bw.flush()
    bw.close()
}

private fun dfs(visited: Array<Boolean>, edges: Map<Int, MutableList<Int>>, here: Int) {
    visited[here] = true
    bw.write("$here ")
    edges[here] ?. let { neighbors ->
        neighbors.forEach { neighbor ->
            if (!visited[neighbor]) {
                dfs(visited, edges, neighbor)
            }
        }
    }
}

private fun bfs(visited: Array<Boolean>, edges: Map<Int, MutableList<Int>>, here: Int) {
    val queue = LinkedList<Int>()
    queue.offer(here)
    visited[here] = true
    bw.write("$here ")
    while (!queue.isEmpty()) {
        val v = queue.poll()
        edges[v] ?. let { neighbors ->
            neighbors.forEach { neighbor ->
                if (!visited[neighbor]) {
                    queue.offer(neighbor)
                    visited[neighbor] = true
                    bw.write("$neighbor ")
                }
            }
        }
    }
}