package src

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

//  java, kotlin 의 경우
//  BigInteger 클래스를 활용해 overflow 문제를 해결할 수도 있다.
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val cases = readLine().toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        val (n, m) = readLine()
            .split(" ")
            .map { it.toInt() }

        bw.write("${calc(n, m)}\n")
    }

    bw.flush()
    bw.close()
}

fun calc(n: Int, m: Int): BigInteger {
    //  nCr = n! / r!(n-r)!
    return factorial(BigInteger("$m")) / (factorial(BigInteger("$n")).multiply(factorial(BigInteger("${m-n}"))))
}

fun factorial(n: BigInteger): BigInteger {
    return if (n <= BigInteger.ONE) BigInteger.ONE
    else n * factorial(n.subtract(BigInteger.ONE))
}