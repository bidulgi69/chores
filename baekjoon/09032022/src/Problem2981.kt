package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases = readLine().toInt()
    val nums = Array(cases) { 0 }
    var offset = 0

    repeat(cases) {
        nums[offset++] = readLine().toInt()
    }
    nums.sort()

    //  최대 공약수 찾기
    //  M 으로 나눈다는 말은 다음과 같이 표현할 수 있음.
    //  N = M * Q + R (Q: 몫, R: 나머지)
    //  이 때 N0, N1, ... 가 위 식을 모두 만족하므로
    //  N1 = M * Q1 + R --- 1
    //  N0 = M * Q0 + R --- 2
    //  N1-N0 = M(Q1-Q0) --- 1 - 2
    //  위 식에서 M 이 N1-N0 의 약수가 된다.
    //  따라서 N(i)-N(i-1) 의 최대 공약수를 모두 구한뒤,
    //  최대 공약수의 약수를 구하면 되는 문제이다.
    var gcd = nums[1] - nums[0]
    for (i: Int in 2 until nums.size) {
        gcd = getGcd(gcd, nums[i] - nums[i - 1])
    }

    val bw = System.out.bufferedWriter()
    //  약수 구하기 (Brute force)
    for (i: Int in 2..gcd) {
        if (gcd % i == 0) {
            bw.write("$i ")
        }
    }
    //  약수 구하기
    for(i in 2 .. sqrt(gcd.toDouble()).toInt()) {
        if(gcd % i == 0) print("$i ")
    }
    for(i in sqrt((gcd-1).toDouble()).toInt() downTo 1) {
        if(gcd % i == 0) print("${gcd / i} ")
    }

    bw.flush()
    bw.close()
}

fun getGcd(n1: Int, n2: Int): Int {
    var a = n1
    var b = n2
    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }
    return a
}