import java.io.InputStreamReader
import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(InputStreamReader(System.`in`))) {
    nextToken()
    val n = nval.toInt()
    nextToken()
    val m = nval.toInt()

    val sum = Array(n) { 0L }
    val modulo = Array(m) { 0L }
    /**
     * (sum[j] - sum[i-1]) % 3 == sum[j]%3 + sum[i-1]%3 = 0
     * 즉, sum[j]%3 = sum[i-1]%3 인 (i, j) 를 찾는 문제이다.
     */
    repeat(n) {
        nextToken()
        if (it == 0) {
            sum[0] = nval.toLong() % m
        } else {
            sum[it] = (nval.toLong() + (sum[it-1]) % m) % m
        }
        modulo[sum[it].toInt()]++
    }

    var cnt = modulo[0]
    for (i: Int in modulo.indices) {
        //  만들 수 있는 경우의 수는 i*(i-1)/2 (i <= j 이므로)
        cnt += modulo[i] * (modulo[i]-1) / 2
    }
    print(cnt)
}