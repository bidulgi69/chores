import java.io.StreamTokenizer
import java.util.Arrays

private lateinit var edges: Array<MutableList<Pair<Int, Int>>>
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    edges = Array(n) { mutableListOf() }
    var v: Int
    var u: Int
    var w: Int
    repeat(n-1) {
        nextToken(); v = nval.toInt()-1
        nextToken(); u = nval.toInt()-1
        nextToken(); w = nval.toInt()
        edges[v].add(Pair(u, w))
        edges[u].add(Pair(v, w))
    }

    val visited = Array(n) { false }
    visited[0] = true
    val (leaf, _) = dfs(0, 0, visited)
    Arrays.fill(visited, false)
    visited[leaf] = true
    val ret = dfs(0, leaf, visited)
    print(ret.second)
}

private fun dfs(distance: Int, node: Int, visited: Array<Boolean>): Pair<Int, Int> {
    var i = node
    var depth = distance
    for (adj: Pair<Int, Int> in edges[node]) {
        if (!visited[adj.first]) {
            visited[adj.first] = true
            val ret = dfs(distance+adj.second, adj.first, visited)
            if (ret.second > depth) {
                i = ret.first
                depth = ret.second
            }
        }
    }
    return Pair(i, depth)
}