import java.io.StreamTokenizer

private const val mod = 1000

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val exponent = nval.toLong()

    val matrix = Array(n) { Array(n) { 0 } }
    repeat(n) { row ->
        repeat(n) { col ->
            nextToken(); matrix[row][col] = nval.toInt() % mod
        }
    }

    val bw = System.out.bufferedWriter()
    dq(matrix, exponent)
        .forEach { row ->
            row.forEach { col ->
                bw.write("$col ")
            }
            bw.write("\n")
        }
    bw.flush()
    bw.close()
}

private fun dq(matrix: Array<Array<Int>>, exponent: Long): Array<Array<Int>> {
    return if (exponent == 1L) {
        matrix
    } else {
        val divide = dq(matrix, exponent/2)
        if (exponent % 2 == 0L) multiply(divide, divide)
        else multiply(multiply(divide, divide), matrix)
    }
}

private fun multiply(a: Array<Array<Int>>, b: Array<Array<Int>>): Array<Array<Int>> {
    val result = Array(a.size) { Array(b.size) { 0 } }
    for (i: Int in a.indices) {
        for (j: Int in b[i].indices) {
            for (k: Int in b.indices) {
                result[i][j] += (a[i][k] * b[k][j]) % mod
                result[i][j] %= mod
            }
        }
    }
    return result
}
