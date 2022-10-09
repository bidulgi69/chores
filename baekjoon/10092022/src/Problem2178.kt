import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val maze = Array(n) { Array(m) { '0' } }
    repeat(n) { r ->
        readLine().forEachIndexed { c, v ->
            maze[r][c] = v
        }
    }

    print(bfs(maze, n, m))
}

private fun bfs(maze: Array<Array<Char>>, n: Int, m: Int): Int {
    //  항상 (1,1)에서 출발
    var i = 0
    var j = 0
    val queue = LinkedList<Triple<Int, Int, Int>>()
    queue.offer(Triple(i, j, 1))
    maze[i][j] = '0'
    while (!queue.isEmpty()) {
        val cursor = queue.poll()
        i = cursor.first
        j = cursor.second

        if (i == n-1 && j == m-1) return cursor.third

        val pass = cursor.third+1
        if (i-1 >= 0 && maze[i-1][j] == '1') {
            maze[i-1][j] = '0'
            queue.offer(Triple(i-1, j, pass))
        }
        if (i+1 < n && maze[i+1][j] == '1') {
            maze[i+1][j] = '0'
            queue.offer(Triple(i+1, j, pass))
        }
        if (j-1 >= 0 && maze[i][j-1] == '1') {
            maze[i][j-1] = '0'
            queue.offer(Triple(i, j-1, pass))
        }
        if (j+1 < m && maze[i][j+1] == '1') {
            maze[i][j+1] = '0'
            queue.offer(Triple(i, j+1, pass))
        }
    }

    return -1   //  not found
}