import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val visited = Array(n) { false }
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

    dfs(visited, edges, 0)
    print(visited.filter { it }.size - 1)   //  1번 컴퓨터는 빼줌
}

private fun dfs(visited: Array<Boolean>, edges: Map<Int, MutableList<Int>>, here: Int) {
    visited[here] = true
    edges[here] ?. let { neighbors ->
        neighbors.forEach { neighbor ->
            if (!visited[neighbor]) {
                dfs(visited, edges, neighbor)
            }
        }
    }
}