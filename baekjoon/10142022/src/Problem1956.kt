import java.io.StreamTokenizer

private const val INF = 100000000

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val v = nval.toInt()
    nextToken(); val e = nval.toInt()

    val graph = Array(v) { Array(v) { INF } }
    repeat(e) {
        nextToken(); val a = nval.toInt()-1
        nextToken(); val b = nval.toInt()-1
        nextToken(); val c = nval.toInt()
        //  directed graph
        graph[a][b] = c
    }

    for (k: Int in 0 until v) {
        for (i: Int in 0 until v) {
            for (j: Int in 0 until v) {
                if (graph[i][j] > graph[i][k]+graph[k][j]) {
                    graph[i][j] = graph[i][k]+graph[k][j]
                }
            }
        }
    }

    //  사이클 존재 유무 확인
    //  자신에게 돌아오는 경로가 있는지 확인하면 된다. (graph[i][i])
    var d = INF
    for (i: Int in 0 until v) {
        if (d > graph[i][i]) d = graph[i][i]
    }

    print(if (d == INF) -1 else d)
}