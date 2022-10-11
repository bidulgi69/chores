import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { Array(m) { Array(3) { 0 } } }
    repeat(n) { r ->
        readLine().forEachIndexed { c, v ->
            //  wall = -1
            map[r][c][2] = -v.digitToInt()
        }
    }
    var nextI: Int
    var nextJ: Int
    var found = false
    val queue = LinkedList<Path>()
    queue.offer(Path(0, 0, 1))
    map[0][0][0] = 1   //  checked
    map[0][0][1] = 1
    while (!queue.isEmpty()) {
        val (i, j, moved, broke) = queue.poll()
        if (i == n-1 && j == m-1) {
            print(moved)
            found = true
            break
        }
        for (k: Int in dx.indices) {
            nextI = i+dx[k]
            nextJ = j+dy[k]

            if (nextI in 0 until n && nextJ in 0 until m && map[nextI][nextJ][broke] == 0) {
                if (broke == 0 && map[nextI][nextJ][2] == -1) {
                    map[nextI][nextJ][1] = 1
                    queue.offer(Path(nextI, nextJ, moved+1, 1))
                } else if (map[nextI][nextJ][2] != -1) {
                    map[nextI][nextJ][broke] = 1
                    queue.offer(Path(nextI, nextJ, moved+1, broke))
                }
            }
        }
    }
    if (!found) print(-1)
}

data class Path(
    val i: Int,
    val j: Int,
    var moved: Int,
    var broke: Int = 0
)
/*
6 4
0000
1110
1000
0000
0111
0010

9

2 6
010001
000110

9

9 9
010001000
010101010
010101010
010101010
010101010
010101010
010101010
010101011
000100010
 */