import java.io.StreamTokenizer
import java.util.PriorityQueue

const val INF = 10000000

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val v = nval.toInt()
    nextToken(); val e = nval.toInt()
    nextToken(); val start = nval.toInt()-1

    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    repeat(e) {
        nextToken(); val x = nval.toInt()-1
        nextToken(); val y = nval.toInt()-1
        nextToken()
        //  directed graph
        val vertexes = graph.getOrDefault(x, mutableListOf())
        vertexes.add(Pair(nval.toInt(), y))
        graph[x] = vertexes
    }
    
    val distance = Array(v) { INF }
    distance[start] = 0
    val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        p1.first.compareTo(p2.first)
    }
    pq.offer(Pair(0, start))
    while (!pq.isEmpty()) {
        val (w, cursor) = pq.poll()
        if (distance[cursor] < w) continue
        graph[cursor] ?. let { adjacent ->
            adjacent.forEach { p ->
                val next = w + p.first
                if (next < distance[p.second]) {
                    distance[p.second] = next
                    pq.offer(Pair(next, p.second))
                }
            }
        }
    }

    val bw = System.out.bufferedWriter()
    distance.forEach { d ->
        bw.write("${
            if (d == INF) "INF"
            else d
        }\n")
    }
    bw.flush()
    bw.close()
}