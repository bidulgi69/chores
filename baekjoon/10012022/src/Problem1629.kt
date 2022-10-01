import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val a = nval.toLong()
    nextToken(); val b = nval.toLong()
    nextToken(); val c = nval.toLong()

    print(dq(a, b, c))
}

private fun dq(a: Long, b: Long, c: Long): Long {
    return if (b == 0L) 1
    else {
        val divide = dq(a, b/2, c)
        if (b % 2 == 0L) (divide * divide)%c
        else ((divide * divide)%c * a)%c
    }
}