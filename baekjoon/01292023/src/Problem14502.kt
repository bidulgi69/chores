import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

//  0: 빈 칸, 1: 벽, 2: 바이러스
lateinit var map: Array<Array<Int>>
var maxSafeArea = 0
val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    map = Array(n) { Array(m) { 0 } }
    repeat(n) { row ->
        readLine()
            .split(" ")
            .map { it.toInt() }
            .forEachIndexed { col, v ->
                map[row][col] = v
            }
    }

    dfs(3)
    print(maxSafeArea)
}

fun dfs(walls: Int) {
    if (walls == 0) {
        //  사용할 수 있는 벽을 모두 소진한 경우
        //  최대 안전 영역의 크기를 계산한다.
        bfs()
    } else {
        for (x: Int in map.indices) {
            for (y: Int in map[x].indices) {
                if (map[x][y] == 0) {
                    map[x][y] = 1
                    dfs(walls-1)
                    map[x][y] = 0
                }
            }
        }
    }
}

fun bfs() {
    val n = map.size
    val m = map[0].size

    val clone = Array(n) { Array(m) { 0 } }
    val queue = LinkedList<Pair<Int, Int>>()
    for (i: Int in 0 until n) {
        for (j: Int in 0 until m) {
            clone[i][j] = map[i][j]
            if (map[i][j] == 2) queue.offer(Pair(i, j))
        }
    }

    var di: Int
    var dj: Int
    while (!queue.isEmpty()) {
        val (x, y) = queue.poll()
        for (i: Int in dx.indices) {
            di = x+dx[i]
            dj = y+dy[i]

            if (di in 0 until n
                && dj in 0 until m
                && clone[di][dj] == 0
            ) {
                clone[di][dj] = 2
                queue.offer(Pair(di, dj))
            }
        }
    }

    var safeArea = 0
    clone.forEach { row ->
        row.forEach { cell ->
            if (cell == 0) safeArea++
        }
    }

    if (maxSafeArea < safeArea) maxSafeArea = safeArea
}
