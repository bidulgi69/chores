import java.io.StreamTokenizer
import java.util.Arrays
import java.util.PriorityQueue
import kotlin.math.min

private const val INF=10000000
lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val e = nval.toInt()

    //  pair: <weight, vertex>
    graph = Array(n) { mutableListOf<Pair<Int, Int>>() }

    repeat(e) {
        nextToken(); val u = nval.toInt()-1
        nextToken(); val v = nval.toInt()-1
        nextToken(); val w = nval.toInt()
        //  undirected graph
        graph[u].add(Pair(w, v))
        graph[v].add(Pair(w, u))
    }

    //  dijkstra
    val distance = Array(n) { INF }
    //  1번 정점으로 부터의 최단거리 계산
    dijkstra(0, distance)


    nextToken(); val v1 = nval.toInt()-1
    nextToken(); val v2 = nval.toInt()-1
    //  1 -> v1 -> v2 -> n
    var v1v2n = distance[v1]
    //  1 -> v2 -> v1 -> n
    var v2v1n = distance[v2]

    //  v1 정점으로 부터의 최단거리 계산
    dijkstra(v1, distance)
    v1v2n = min(INF, v1v2n + distance[v2])
    v2v1n = min(INF, v2v1n + distance[n-1])

    dijkstra(v2, distance)
    v2v1n = min(INF, v2v1n + distance[v1])
    v1v2n = min(INF, v1v2n + distance[n-1])

    if (v1v2n == INF && v2v1n == INF) print(-1)
    else print(min(v1v2n, v2v1n))
}

fun dijkstra(departure: Int, distance: Array<Int>) {
    val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        p1.first.compareTo(p2.first)
    }
    Arrays.fill(distance, INF)
    distance[departure] = 0
    pq.offer(Pair(0, departure))

    while (!pq.isEmpty()) {
        val (weight, vertex) = pq.poll()
        with(graph[vertex]) {
            forEach { adj ->
                val next = weight + adj.first
                if (next < distance[adj.second]) {
                    distance[adj.second] = next
                    pq.offer(Pair(next, adj.second))
                }
            }
        }
    }
}