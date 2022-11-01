import java.io.StreamTokenizer

var call = 0
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val bw = System.out.bufferedWriter()
    repeat(n) {
        nextToken(); val s = sval
        bw.write("${isPalindrome(s)} $call\n")
        call = 0
    }
    bw.flush()
    bw.close()
}

private fun recursion(s: String, l: Int, r: Int): Int {
    call++
    return if (l >= r) 1
    else if (s[l] != s[r]) 0
    else recursion(s, l+1, r-1)
}

fun isPalindrome(s: String): Int {
    return recursion(s, 0, s.length-1)
}