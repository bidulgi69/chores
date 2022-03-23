import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
//    print((n * n+1) / 2)
    //  using for loop
    var sum = 0
    for (i: Int in 1..n)
        sum += i
    print(sum)
}