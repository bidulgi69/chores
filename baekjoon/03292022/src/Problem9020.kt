import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val limit = 10000
    val prime = BooleanArray(limit + 1) { true }
    prime[0] = false
    prime[1] = false
    var i = 2
    while (i * i <= limit){
        if (prime[i]) {
            for (j: Int in i*i..limit step i)
                prime[j] = false
        }
        i++
    }

    val bw = System.out.bufferedWriter()
    val cases: Int = readLine().toInt()
    repeat(cases) {
        val n: Int = readLine().toInt()
        val partition = findOptimizedGoldBachPartition(prime, n)
        bw.write("${partition.second} ${partition.first}\n")
    }
    bw.flush()
    bw.close()
}

fun findOptimizedGoldBachPartition(prime: BooleanArray, target: Int): Pair<Int, Int> {
    for (i: Int in target / 2..target) {
        for (j: Int in target / 2 downTo 2) {
            if (prime[i] && prime[j] && i + j == target) {
                return Pair(i, j)
            }
        }
    }
    return Pair(-1, -1)
}