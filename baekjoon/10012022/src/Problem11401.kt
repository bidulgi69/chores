import java.io.StreamTokenizer

const val mod = 1000000007L  //  prime

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val k = nval.toInt()

    //  페르마의 소정리
    //  p 가 소수일 경우, a^(p-1) = 1 (mod p)
    //  a^(p-2)*a = 1 (mod p)
    //  a^(p-2) = a^-1 (mod p)
    //  즉 이항계수는 (n! * (k!(n-k)!)^p-2) % mod 와 같이 표현 가능.
    var x = 1L
    var y = 1L
    for (i: Int in 2..n) {
        x *= i
        x %= mod
    }

    for (i: Int in 2..k) {
        y *= i
        y %= mod
    }
    for (i: Int in 2..n-k) {
        y *= i
        y %= mod
    }

    y = dq(y, mod-2)
    print((x * y) % mod)
}

private fun dq(n: Long, exponent: Long): Long {
    return if (exponent == 0L) 1
    else {
        val divide = dq(n, exponent/2)
        if (exponent % 2 == 0L) (divide * divide) % mod
        else ((divide * divide) % mod * n) % mod
    }
}