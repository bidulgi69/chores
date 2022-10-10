import java.io.StreamTokenizer
import java.util.LinkedList

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val farm = Array(m) { Array(n) { 0 } }
    //  시작점 저장
    val matureTomatoes = LinkedList<Pair<Int, Int>>()
    repeat(m) { r ->
        repeat(n) { c ->
            nextToken(); farm[r][c] = nval.toInt()
            if (nval == 1.0) {
                matureTomatoes.offer(Pair(r, c))
            }
        }
    }
    print(bfs(farm, matureTomatoes))
}

private fun bfs(farm: Array<Array<Int>>, matureTomatoes: LinkedList<Pair<Int, Int>>): Int {
    val n = farm.size
    val m = farm[0].size
    val queue = LinkedList<Triple<Int, Int, Int>>()
    while (!matureTomatoes.isEmpty()) {
        val (i, j) = matureTomatoes.poll()
        queue.offer(Triple(i, j, 0))
    }

    var days = 0
    while (!queue.isEmpty()) {
        val (i, j, d) = queue.poll()
        for (k: Int in dx.indices) {
            val nextI = i+dx[k]
            val nextJ = j+dy[k]
            if (nextI in 0 until n && nextJ in 0 until m && farm[nextI][nextJ] == 0) {
                farm[nextI][nextJ] = 1
                queue.offer(Triple(nextI, nextJ, d+1))
            }
        }
        days = d
    }

    var isPremature = false
    for (i: Int in 0 until n) {
        for (j: Int in 0 until m) {
            if (farm[i][j] == 0) {
                isPremature = true
                break
            }
        }
    }

    return if (isPremature) -1 else days
}