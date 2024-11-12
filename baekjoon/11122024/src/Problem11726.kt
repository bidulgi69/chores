import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()

    val bw = System.out.bufferedWriter()
    when (n) {
        0 -> bw.write("0")
        1 -> bw.write("1")
        2 -> bw.write("2")
        else -> {
            val fb = Array(n+1) { 0L }
            //  fb(n)=fb(n-1)+fb(n-2)
            fb[0] = 0L
            fb[1] = 1L
            fb[2] = 2L

            val modulo = 10_007
            for (i: Int in 3..n) {
                fb[i] = (fb[i-2]+fb[i-1])%modulo
            }

            bw.write("${fb[n]}")
        }
    }
    bw.flush()
    bw.close()
}