import java.io.StreamTokenizer

private var order = 1
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()
    nextToken(); val here = nval.toInt() - 1

    val visited = Array(n) { 0 }
    val edges = mutableMapOf<Int, MutableList<Int>>()
    repeat(m) {
        nextToken(); val v1 = nval.toInt() - 1
        nextToken(); val v2 = nval.toInt() - 1

        val v1Neighbors = edges.getOrDefault(v1, mutableListOf())
        val v2Neighbors = edges.getOrDefault(v2, mutableListOf())
        v1Neighbors.add(v2)
        v2Neighbors.add(v1)
        edges[v1] = v1Neighbors
        edges[v2] = v2Neighbors
    }

    for (i: Int in 0 until n) {
        edges[i]?.sortDescending()
    }

    dfs(visited, edges, here)
    val bw = System.out.bufferedWriter()
    visited.forEach {
        bw.write("$it\n")
    }
    bw.flush()
    bw.close()
}

private fun dfs(visited: Array<Int>, edges: Map<Int, MutableList<Int>>, here: Int) {
    visited[here] = order++
    edges[here] ?. let { neighbors ->
        neighbors.forEach { neighbor ->
            if (visited[neighbor] == 0) {
                dfs(visited, edges, neighbor)
            }
        }
    }
}