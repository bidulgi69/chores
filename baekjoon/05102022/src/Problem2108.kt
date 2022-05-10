import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.round

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val repeats = readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(repeats) {
        numbers.add(
            readLine().toInt()
        )
    }
    numbers.sort()
    val counts = numbers
        .groupingBy { it }
        .eachCount()

    val maxCount: Int = counts
        .maxOf { it.value }

    val maxCountKeys = counts
        .filter { it.value == maxCount }
        .keys
        .toMutableList()

    maxCountKeys.sort()
    bw.write("${round(numbers.average()).toInt()}\n")  //  산술평균
    bw.write("${numbers[repeats / 2]}\n")   //  중앙값
    bw.write("${maxCountKeys[if (maxCountKeys.size > 1) 1 else 0]}\n")   //  최빈값
    bw.write("${numbers[repeats - 1] - numbers[0]}")    //  범위

    bw.flush()
    bw.close()
}