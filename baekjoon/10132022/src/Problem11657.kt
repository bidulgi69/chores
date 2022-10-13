import java.io.StreamTokenizer

private const val INF = 100000000L

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val edges = mutableListOf<Triple<Int, Int, Long>>()
    repeat(m) {
        nextToken(); val a = nval.toInt()-1
        nextToken(); val b = nval.toInt()-1
        nextToken(); val c = nval.toLong()

        edges.add(Triple(a, b, c))
    }

    //  bellman-ford
    var negativeCycle = false
    val distance = Array(n) { INF }
    distance[0] = 0
    for (i: Int in 0 until n) {
        edges.forEach { e ->
            val (u, v, c) = e
            if (distance[u] != INF && distance[v] > distance[u]+c) {
                if (i == n-1) { //  negative cycle
                    negativeCycle = true
                } else {
                    distance[v] = distance[u]+c
                }
            }
        }
    }

    val bw = System.out.bufferedWriter()
    if (negativeCycle) {
        bw.write("-1")
    } else {
        for (i: Int in 1 until n) {
            bw.write("${
                if (distance[i] == INF) -1
                else distance[i]
            }\n")
        }
    }
    bw.flush()
    bw.close()
}