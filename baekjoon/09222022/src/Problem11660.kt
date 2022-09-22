import java.io.InputStreamReader
import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(InputStreamReader(System.`in`))) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val sum = Array(n+1) { Array(n+1) { 0 } }
    repeat(n) { row ->
        repeat(n) { col ->
            nextToken()
            sum[row+1][col+1] = sum[row+1][col] + sum[row][col+1] - sum[row][col] + nval.toInt()
        }
    }

    val bw = System.out.bufferedWriter()
    repeat(m) {
        nextToken(); val x1 = nval.toInt()
        nextToken(); val y1 = nval.toInt()
        nextToken(); val x2 = nval.toInt()
        nextToken(); val y2 = nval.toInt()

        bw.write("${sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1]}\n")
    }
    bw.flush()
    bw.close()
}
/*
4 5
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
1 1 4 4
3 4 3 4
1 2 1 3
2 1 2 4
 */