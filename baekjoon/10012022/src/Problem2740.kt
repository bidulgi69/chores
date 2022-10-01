import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val a = Array(n) { Array(m) { 0 } }
    repeat(n) { row ->
        repeat(m) { col ->
            nextToken(); a[row][col] = nval.toInt()
        }
    }

    nextToken(); nextToken(); val k = nval.toInt()
    val b = Array(m) { Array(k) { 0 } }
    repeat(m) { row ->
        repeat(k) { col ->
            nextToken(); b[row][col] = nval.toInt()
        }
    }

    val mul = Array(n) { Array(k) { 0 } }
    for (i: Int in 0 until n) {
        for (j: Int in 0 until k) {
            for (p: Int in 0 until m) {
                mul[i][j] += a[i][p] * b[p][j]
            }
        }
    }

    val bw = System.out.bufferedWriter()
    for (i: Int in 0 until n) {
        for (j: Int in 0 until k) {
            bw.write("${mul[i][j]} ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}