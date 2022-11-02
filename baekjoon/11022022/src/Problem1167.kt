import java.io.StreamTokenizer
import java.util.Arrays

lateinit var edges: Array<MutableList<Pair<Int, Int>>>
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    var v: Int
    var u: Int
    var w: Int
    edges = Array(n) { mutableListOf() }
    repeat(n) {
        nextToken(); v = nval.toInt()-1
        nextToken(); u = nval.toInt()-1
        while (u != -2) {
            nextToken(); w = nval.toInt()
            //  이후에 u, v 가 뒤집힌채로 한번 더 등장하기 때문에
            //  v->u 에 대한 간선 정보만 저장해주면 된다.
            edges[v].add(Pair(u, w))
            nextToken(); u = nval.toInt()-1
        }
    }
    //  leaf node 를 찾은 뒤,
    val visited = Array(n) { false }
    visited[0] = true
    val (leaf, _) = dfs(0, 0, visited)

    //  해당 leaf node 에서 가장 먼 node 를 찾으면 트리의 지름이 된다.
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

//  시간초과 풀이
//  모든 정점에 대해 계산해보기 때문에, 중복된 경로를 거치는 경우가 많아진다.
/*
static var max = 0
for (i: Int in 0 until n) {
    val visited = Array(n) { false }
    visited[i] = true
    dfs(0, i, visited)
}
private fun dfs(distance: Int, node: Int, visited: Array<Boolean>) {
    edges[node].forEach { adj ->
        if (!visited[adj.first]) {
            visited[adj.first] = true
            dfs(distance + adj.second, adj.first, visited)
        }
    }
    max = kotlin.math.max(max, distance)
}
 */