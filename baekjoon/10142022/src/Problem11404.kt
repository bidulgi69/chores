import java.io.StreamTokenizer

private const val INF = 100000000

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val graph = Array(n) { Array(n) { INF } }
    for (i: Int in 0 until n) {
        graph[i][i] = 0
    }
    //  edge
    repeat(m) {
        nextToken(); val a = nval.toInt()-1
        nextToken(); val b = nval.toInt()-1
        nextToken(); val c = nval.toInt()
        if (graph[a][b] > c) graph[a][b] = c
    }

    for (k: Int in 0 until n) {
        for (i: Int in 0 until n) {
            for (j: Int in 0 until n) {
                if (graph[i][j] > graph[i][k]+graph[k][j]) {
                    graph[i][j] = graph[i][k]+graph[k][j]
                }
            }
        }
    }

    val bw = System.out.bufferedWriter()
    for (i: Int in 0 until n) {
        for (j: Int in 0 until n) {
            bw.write("${
                if (graph[i][j] == INF) 0
                else graph[i][j]
            } ")
        }
        bw.appendLine()
    }
    bw.flush()
    bw.close()
}