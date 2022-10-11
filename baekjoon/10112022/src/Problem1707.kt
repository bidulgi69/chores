import java.io.StreamTokenizer
import java.util.PriorityQueue

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val k = nval.toInt()
    val bw = System.out.bufferedWriter()
    val queue = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        p1.second.compareTo(p2.second)
    }
    repeat(k) {
        nextToken(); val v = nval.toInt()
        nextToken(); val e = nval.toInt()

        val vertexes = Array(v+1) { -1 }
        val edges = mutableMapOf<Int, MutableList<Int>>()
        repeat(e) {
            nextToken(); val v1 = nval.toInt()
            nextToken(); val v2 = nval.toInt()

            val v1Neighbors = edges.getOrDefault(v1, mutableListOf())
            val v2Neighbors = edges.getOrDefault(v2, mutableListOf())
            v1Neighbors.add(v2)
            v2Neighbors.add(v1)

            edges[v1] = v1Neighbors
            edges[v2] = v2Neighbors
        }

        //  vertex, weight
        for (i: Int in 1..v) {
            queue.offer(Pair(i, 1))
        }

        try {
            while (!queue.isEmpty()) {
                val (vertex, _) = queue.poll()
                val adjColor = (vertexes[vertex]+1) % 2
                edges[vertex]?.let { adjacent ->
                    adjacent.forEach { adj ->
                        if (vertexes[adj] == -1) {
                            vertexes[adj] = adjColor
                            queue.offer(Pair(adj, 0))
                        } else if (vertexes[vertex] + vertexes[adj] != 1) {
                            throw RuntimeException()
                        }
                    }
                }
            }
            bw.write("YES\n")
        } catch (e: RuntimeException) {
            bw.write("NO\n")
        } finally {
            queue.clear()
        }
    }
    bw.flush()
    bw.close()
}

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2

1
6 6
1 3
3 4
4 2
2 5
5 6
6 1

1
5 4
1 2
3 4
4 5
3 5
NO
 */