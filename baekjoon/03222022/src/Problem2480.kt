import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dices = IntArray(6)
    StringTokenizer(readLine())
        .iterator()
        .forEach { dices[it.toString().toInt() - 1]++ }

    //같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
    //같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
    //모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
    var three: Int = -1
    var two: Int = -1
    var max: Int = -1
    for ((index: Int, acc: Int) in dices.withIndex()) {
        when (acc) {
            3 -> three = index
            2 -> two = index
            1 -> max = index
        }
    }

    if (three != -1) print(10000 + ++three * 1000)
    else if (two != -1) print(1000 + ++two * 100)
    else print(++max * 100)
}