import java.io.StreamTokenizer
import java.util.Arrays
import java.util.PriorityQueue

private const val INF = 100000000
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
    p1.first.compareTo(p2.first)
}

//  후보 도착 지점에 대해서 주어진 시작 지점으로 부터의 최단 거리를 먼저 계산.
//  이후 g, h 를 경유해 가는 최단 거리를 계산해서 만약 위의 값과 다를 경우 최단 거리가 아님을 알 수 있다.
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        nextToken(); val n = nval.toInt()   //  vertex
        nextToken(); val m = nval.toInt()   //  edge
        nextToken(); val t = nval.toInt()
        nextToken(); val s = nval.toInt()-1   //  출발지
        nextToken(); val g = nval.toInt()-1
        nextToken(); val h = nval.toInt()-1

        graph = Array(n) { mutableListOf() }
        var ghWeight = 0
        repeat(m) {
            nextToken(); val a = nval.toInt()-1
            nextToken(); val b = nval.toInt()-1
            nextToken(); val d = nval.toInt()
            //  undirected graph
            graph[a].add(Pair(d, b))
            graph[b].add(Pair(d, a))
            //  g, h 사이의 도로는 1개만 존재한다.
            if ((a == g && b == h) || (a == h && b == g)) ghWeight = d
        }
        //  도착 후보지
        val destinations = Array(t) { 0 }
        repeat(t) {
            nextToken(); destinations[it] = nval.toInt()-1
        }

        val distance = Array(n) { INF }
        //  시작 지점으로 부터의 최단 거리 계산
        dijkstra(s, distance)
        val fastest = Array(t) { 0 }
        val optimized = mutableSetOf<Int>()
        for (i: Int in destinations.indices) {
            fastest[i] = distance[destinations[i]]
        }
        val toG = distance[g]   //  시작점으로 부터 g 까지의 최적 거리
        val toH = distance[h]   //  시작점으로 부터 h 까지의 최적 거리

        //  g, h 를 경유해서 가는 경우 최단 거리 계산
        //  1. g->h
        dijkstra(h, distance)
        for (i: Int in destinations.indices) {
            if (fastest[i] == distance[destinations[i]] + toG + ghWeight) optimized.add(destinations[i]+1)
        }

        //  2. h->g
        dijkstra(g, distance)
        for (i: Int in destinations.indices) {
            if (fastest[i] == distance[destinations[i]] + toH + ghWeight) optimized.add(destinations[i]+1)
        }

        optimized.sorted()
            .forEach {
                bw.write("$it ")
            }
        bw.appendLine()
    }
    bw.flush()
    bw.close()
}

fun dijkstra(start: Int, distance: Array<Int>) {
    Arrays.fill(distance, INF)
    distance[start] = 0
    pq.offer(Pair(0, start))

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

/*
1
5 4 2
1 2 3
1 2 1
2 3 1
3 4 1
2 5 1
4
5
 */