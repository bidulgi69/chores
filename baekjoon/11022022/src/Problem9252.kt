import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val s1 = sval
    nextToken(); val s2 = sval

    val dp = Array(s1.length+1) { Array(s2.length+1) { Array(2) { 0 } } }
    for (i: Int in 1..s1.length) {
        for (j: Int in 1..s2.length) {
            if (s1[i-1] == s2[j-1]) {
                dp[i][j][0] = dp[i-1][j-1][0]+1
                dp[i][j][1] = 3 //  왼쪽 위로 이동(대각선)
            } else {
                if (dp[i-1][j][0] > dp[i][j-1][0]) {
                    dp[i][j][0] = dp[i-1][j][0]
                    dp[i][j][1] = 1 //  위로 이동
                } else {
                    dp[i][j][0] = dp[i][j-1][0]
                    dp[i][j][1] = 2 //  왼쪽으로 이동
                }
            }
        }
    }

    val bw = System.out.bufferedWriter()
    bw.write("${dp[s1.length][s2.length][0]}\n")
    if (dp[s1.length][s2.length][0] > 0) {
        //  track
        val lcs = mutableListOf<Char>()
        var i = s1.length
        var j = s2.length
        while (i > 0 && j > 0) {
            when (dp[i][j][1]) {
                3 -> {
                    lcs.add(s1[i-1])
                    i -= 1
                    j -= 1
                }
                1 -> {
                    i -= 1
                }
                2 -> {
                    j -= 1
                }
            }
        }

        for (k: Int in lcs.size-1 downTo 0) {
            bw.write("${lcs[k]}")
        }
    }
    bw.flush()
    bw.close()
}