import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val number: Int = readLine().toInt()
    for (i: Int in 1..9) {
        println("$number * $i = ${number*i}")
    }
}