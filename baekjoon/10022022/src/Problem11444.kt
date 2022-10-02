import java.io.StreamTokenizer

private const val mod = 1000000007

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toLong()

    //  F(n+1) Fn
    //  Fn  F(n-1)  형태로 형렬을 만들고,
    //  해당 행렬을 제곱하면서 피보나치 수열의 값을 만들 수 있다.
    val init = Array(2) { Array(2) { 1L } }
    init[1][1] = 0

    print(dq(init, n)[0][1])
}

private fun dq(matrix: Array<Array<Long>>, exponent: Long): Array<Array<Long>> {
    return if (exponent == 1L) matrix
    else {
        val divide = dq(matrix, exponent/2)
        if (exponent % 2 == 0L) multiply(divide, divide)
        else multiply(multiply(divide, divide), matrix)
    }
}

private fun multiply(a: Array<Array<Long>>, b: Array<Array<Long>>): Array<Array<Long>> {
    val result = Array(a.size) { Array(b.size) { 0L } }
    for (i: Int in a.indices) {
        for (j: Int in b[i].indices) {
            for (k: Int in b.indices) {
                result[i][j] += a[i][k] * b[k][j]
            }
            result[i][j] = result[i][j] % mod
        }
    }
    return result
}