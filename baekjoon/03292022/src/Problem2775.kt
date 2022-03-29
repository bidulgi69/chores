import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        val k: Int = readLine().toInt()
        val n: Int = readLine().toInt()

        val apartment = Array(k + 1) { IntArray(n + 1) { 0 } }
        for (i: Int in 1..n)
            apartment[0][i] = i

        for (i: Int in 1..k) {
            for (j: Int in 1..n) {
                apartment[i][j] = apartment[i - 1].take(j + 1).sum()
            }
        }
        bw.write("${apartment[k][n]}\n")
    }
    bw.flush()
    bw.close()
}