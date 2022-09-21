import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, cases) = readLine()
        .split(" ")
        .map { it.toInt() }

    val numbers = Array(n+1) { 0 }
    //  누적합 구하기
    readLine()
        .split(" ")
        .forEachIndexed { index, v ->
            numbers[index+1] = numbers[index] + v.toInt()
        }

    val bw = System.out.bufferedWriter()
    repeat(cases) {
        val (i, j) = readLine()
            .split(" ")
            .map { it.toInt() }

        bw.write("${numbers[j] - numbers[i-1]}\n")
    }
    bw.flush()
    bw.close()
}