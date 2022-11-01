import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val matrix = Array(n) { Array(m) { 0 } }
    repeat(n) { r ->
        repeat(m) { c ->
            nextToken(); matrix[r][c] = nval.toInt()
        }
    }

    repeat(n) { r ->
        repeat(m) { c ->
            nextToken(); matrix[r][c] += nval.toInt()
        }
    }

    val bw = System.out.bufferedWriter()
    for (row in matrix) {
        for (col in row) {
            bw.write("$col ")
        }
        bw.appendLine()
    }
    bw.flush()
    bw.close()
}