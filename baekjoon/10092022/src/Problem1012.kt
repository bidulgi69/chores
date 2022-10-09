import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        nextToken(); val n = nval.toInt()
        nextToken(); val m = nval.toInt()
        nextToken(); val k = nval.toInt()
        val farm = Array(n) { Array(m) { 0 } }

        repeat(k) {
            nextToken(); val i = nval.toInt()
            nextToken(); val j = nval.toInt()
            farm[i][j] = 1
        }

        var worms = 0
        for (i: Int in 0 until n) {
            for (j: Int in 0 until m) {
                if (farm[i][j] == 1) {
                    bfs(farm, i, j)
                    worms++
                }
            }
        }

        bw.write("$worms\n")
    }

    bw.flush()
    bw.close()
}

private fun bfs(farm: Array<Array<Int>>, i: Int, j: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(i, j))
    farm[i][j] = 0
    while (!queue.isEmpty()) {
        val cursor = queue.poll()
        if (cursor.first-1 >= 0 && farm[cursor.first-1][cursor.second] == 1) {
            farm[cursor.first-1][cursor.second] = 0
            queue.offer(Pair(cursor.first-1, cursor.second))
        }
        if (cursor.first+1 < farm.size && farm[cursor.first+1][cursor.second] == 1) {
            farm[cursor.first+1][cursor.second] = 0
            queue.offer(Pair(cursor.first+1, cursor.second))
        }
        if (cursor.second-1 >= 0 && farm[cursor.first][cursor.second-1] == 1) {
            farm[cursor.first][cursor.second-1] = 0
            queue.offer(Pair(cursor.first, cursor.second-1))
        }
        if (cursor.second+1 < farm[0].size && farm[cursor.first][cursor.second+1] == 1) {
            farm[cursor.first][cursor.second+1] = 0
            queue.offer(Pair(cursor.first, cursor.second+1))
        }
    }
}