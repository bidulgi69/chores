import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()
        .split(" ")

    val set1 = readLine()
        .split(" ")
        .toSet()
    val set2 = readLine()
        .split(" ")
        .toSet()

    var sum = 0
    //  A-B
    sum += set1
        .filter { !set2.contains(it) }
        .size

    //  B-A
    sum += set2
        .filter { !set1.contains(it) }
        .size

    val bw = System.out.bufferedWriter()
    bw.write("$sum")
    bw.flush()
    bw.close()
}