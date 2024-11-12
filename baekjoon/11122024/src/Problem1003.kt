import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()

    val bw = System.out.bufferedWriter()
    val fb = Array(41) { Pair(0, 0) }
    //  fb(n)=fb(n-1)+fb(n-2)
    fb[0] = Pair(1, 0)
    fb[1] = Pair(0, 1)
    fb[2] = Pair(1, 1)

    val req = Array(cases) { 0 }
    var max = -1
    repeat(cases) { idx ->
        nextToken(); val n = nval.toInt()
        max = max.coerceAtLeast(n)
        req[idx] = n
    }

    for (i: Int in 3..max) {
        fb[i] = Pair(fb[i-1].first+fb[i-2].first, fb[i-1].second+fb[i-2].second)
    }

    req.forEach { n ->
        bw.write("${fb[n].first} ${fb[n].second}\n")
    }

    bw.flush()
    bw.close()
}