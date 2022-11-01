import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); var n = nval.toInt()
    val dp = Array(1000001) { Array(2) { 0 } }
    var a: Int
    var b: Int
    var c: Int
    for (i: Int in 2..n) {
        a = dp[i/3][0]
        b = dp[i/2][0]
        c = dp[i-1][0]
        if (i%6 == 0) {
            if (a <= b && a <= c) {
                dp[i][0] = dp[i/3][0]+1
                dp[i][1] = i/3
            } else if (b <= a && b <= c) {
                dp[i][0] = dp[i/2][0]+1
                dp[i][1] = i/2
            } else {
                dp[i][0] = dp[i-1][0]+1
                dp[i][1] = i-1
            }
        } else if (i%3 == 0) {
            if (a <= c) {
                dp[i][0] = dp[i/3][0]+1
                dp[i][1] = i/3
            } else {
                dp[i][0] = dp[i-1][0]+1
                dp[i][1] = i-1
            }
        } else if (i%2 == 0) {
            if (b <= c) {
                dp[i][0] = dp[i/2][0]+1
                dp[i][1] = i/2
            } else {
                dp[i][0] = dp[i-1][0]+1
                dp[i][1] = i-1
            }
        } else {
            dp[i][0] = dp[i-1][0]+1
            dp[i][1] = i-1
        }
    }

    val bw = System.out.bufferedWriter()
    bw.write("${dp[n][0]}\n")
    while (n != 1) {
        bw.write("$n ")
        n = dp[n][1]
    }
    bw.write("1")
    bw.flush()
    bw.close()
}