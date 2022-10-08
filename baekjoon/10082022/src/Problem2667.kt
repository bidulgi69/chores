import java.io.BufferedReader
import java.io.InputStreamReader

val regions = mutableListOf<Int>()
var painted = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val map = Array(n) { Array(n) { '0' } }
    repeat(n) { r ->
        val row = readLine()
        row.forEachIndexed { c, v ->
            map[r][c] = v
        }
    }

    for (i: Int in 0 until n) {
        for (j: Int in 0 until n) {
            if (map[i][j] == '1') {
                dfs(map, i, j)
                regions.add(painted)
                painted = 0
            }
        }
    }
    regions.sort()
    print("${regions.size}\n${regions.joinToString("\n")}")
}

private fun dfs(map: Array<Array<Char>>, i: Int, j: Int) {
    map[i][j] = '0'
    painted++
    val len = map.size
    if (i-1 >= 0 && map[i-1][j] == '1') dfs(map, i-1, j)
    if (i+1 < len && map[i+1][j] == '1') dfs(map, i+1, j)
    if (j-1 >= 0 && map[i][j-1] == '1') dfs(map, i, j-1)
    if (j+1 < len && map[i][j+1] == '1') dfs(map, i, j+1)
}
/*
7
1110101
0110101
1110101
0000111
0100000
0111110
0111001
 */