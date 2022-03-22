import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val a: Int = readln().toInt()
    val b: String = readln()
    val arr: List<String> = b.split("".toRegex()).filter { it != "" }

    for (offset: Int in b.length-1 downTo 0)
        println(a*arr[offset].toInt())
    print(a*b.toInt())
}