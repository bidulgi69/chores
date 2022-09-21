import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, k) = readLine()
        .split(" ")
        .map { it.toInt() }

    val numbers = Array(n) { 0 }
    readLine()
        .split(" ")
        .forEachIndexed { index, v ->
            numbers[index] = v.toInt()
        }

    var sum = 0
    for (i: Int in 0 until k) {
        sum += numbers[i]
    }
    var max = sum
    for (i: Int in 1..n-k) {
        sum = sum - numbers[i-1] + numbers[i+k-1]
        if (sum > max) max = sum
    }
    print(max)
}