import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()

    val dp = Array(11) { 0 }
    dp[0] = 1   //  1
    dp[1] = 2   //  1+1, 2
    dp[2] = 4   //  1+1+1, 1+2, 2+1, 3
    //  dp[4]=(dp[3]+1), (dp[2], 2), (dp[1], 3)
    //  dp[n]=dp[n-3]+dp[n-2]+dp[n-1]

    for (i: Int in 3 until 11) {
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    }

    val bw = System.out.bufferedWriter()
    repeat(cases) {
        nextToken(); val n = nval.toInt()
        bw.write("${dp[n-1]}\n")
    }

    bw.flush()
    bw.close()
}