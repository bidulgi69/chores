import java.io.StreamTokenizer
import java.util.LinkedList

private val dx = intArrayOf(0, 1, 0, -1, 0, 0)
private val dy = intArrayOf(1, 0, -1, 0, 0, 0)
private val dz = intArrayOf(0, 0, 0, 0, 1, -1)

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()
    nextToken(); val h = nval.toInt()

    val farm = Array(h) { Array(m) { Array(n) { 0 }}}
    val matureTomatoes = mutableListOf<Triple<Int, Int, Int>>()
    repeat(h) { k ->
        repeat(m) { i ->
            repeat(n) { j ->
                nextToken(); farm[k][i][j] = nval.toInt()
                if (nval == 1.0) {
                    matureTomatoes.add(Triple(i, j, k))
                }
            }
        }
    }
    print(bfs(farm, matureTomatoes))
}

private fun bfs(farm: Array<Array<Array<Int>>>, matureTomatoes: List<Triple<Int, Int, Int>>): Int {
    val h = farm.size
    val n = farm[0].size
    val m = farm[0][0].size
    val queue = LinkedList<Tomato>()
    matureTomatoes.forEach {
        queue.offer(Tomato(it.first, it.second, it.third))
    }

    var days = 0
    while (!queue.isEmpty()) {
        val (i, j, k, d) = queue.poll()
        for (l: Int in dx.indices) {
            val nextK = k+dz[l]
            val nextI = i+dx[l]
            val nextJ = j+dy[l]

            if (nextK in 0 until h && nextI in 0 until n && nextJ in 0 until m && farm[nextK][nextI][nextJ] == 0) {
                farm[nextK][nextI][nextJ] = 1
                queue.offer(Tomato(nextI, nextJ, nextK, d+1))
            }
        }
        days = d
    }

    var isPremature = false
    for (k: Int in 0 until h) {
        for (i: Int in 0 until n) {
            for (j: Int in 0 until m) {
                if (farm[k][i][j] == 0) {
                    isPremature = true
                    break
                }
            }
        }
    }

    return if (isPremature) -1 else days
}

data class Tomato(
    val i: Int,
    val j: Int,
    val k: Int,
    val days: Int = 0
)