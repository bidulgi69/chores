import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val edges = mutableMapOf<Int, MutableList<Int>>()
    var i: Int
    var j: Int
    repeat(n-1) {
        nextToken(); i = nval.toInt()
        nextToken(); j = nval.toInt()
        val iNeighbors = edges.getOrDefault(i, mutableListOf())
        val jNeighbors = edges.getOrDefault(j, mutableListOf())
        iNeighbors.add(j)
        jNeighbors.add(i)
        edges[i] = iNeighbors
        edges[j] = jNeighbors
    }

    //  bfs
    val nodes = Array(n+1) { 0 }
    val visited = Array(n+1) { false }
    nodes[1] = 1
    visited[1] = true
    val queue: Queue<Int> = LinkedList()
    queue.offer(1)
    var node: Int
    var adjacent: MutableList<Int>
    while (!queue.isEmpty()) {
        node = queue.poll()
        adjacent = edges[node]!!
        for (adj: Int in adjacent) {
            if (!visited[adj]) {
                visited[adj] = true
                nodes[adj] = node
                queue.offer(adj)
            }
        }
    }
    val bw = System.out.bufferedWriter()
    for (k: Int in 2..n) {
        bw.write("${nodes[k]}\n")
    }
    bw.flush()
    bw.close()
}
//