import java.io.StreamTokenizer
import java.util.LinkedList

private val dx = intArrayOf(-2,-1,1,2,2,1,-1,-2)
private val dy = intArrayOf(-1,-2,-2,-1,1,2,2,1)

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        nextToken(); val len = nval.toInt()
        val board = Array(len) { Array(len) { 0 } }
        //  시작 지점
        nextToken(); val i1 = nval.toInt()
        nextToken(); val j1 = nval.toInt()
        //  도착 지점
        nextToken(); val i2 = nval.toInt()
        nextToken(); val j2 = nval.toInt()

        bfs(board, i1, j1, i2, j2)
        bw.write("${board[i2][j2] - 1}\n")
    }
    bw.flush()
    bw.close()
}

private fun bfs(board: Array<Array<Int>>, i1: Int, j1: Int, i2: Int, j2: Int) {
    val len = board.size
    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(i1, j1))
    board[i1][j1] = 1

    while (!queue.isEmpty()) {
        val (i, j) = queue.poll()
        if (i == i2 && j == j2) break
        for (m: Int in dx.indices) {
            val nextI = i+dx[m]
            val nextJ = j+dy[m]
            if (nextI in 0 until len && nextJ in 0 until len && board[nextI][nextJ] == 0) {
                board[nextI][nextJ] = board[i][j] + 1
                queue.offer(Pair(nextI, nextJ))
            }
        }
    }
}
/*
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1

 */