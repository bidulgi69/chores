import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    val map = Array(n) { Array(n) { ' ' } }
    draw(map, n, 0, 0)

    val bw = System.out.bufferedWriter()
    for (i: Int in 0 until n) {
        for (j: Int in 0 until n) {
            bw.write("${map[i][j]}")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

fun draw(map: Array<Array<Char>>, n: Int, x: Int, y: Int) {
    if (n == 1) {
        map[x][y] = '*'
    } else {
        val next = n / 3
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (i != 1 || j != 1) {
                    draw(map, next, i * next + x, j * next + y)
                }
            }
        }
    }
}

/*
N=3
***
* *
***

N=9
*********
* ** ** *
*********
***   ***
* *   * *
***   ***
*********
* ** ** *
*********
*/