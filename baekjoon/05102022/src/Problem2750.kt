import java.io.BufferedReader
import java.io.InputStreamReader

// 2750, 2751
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
    numbers
        .forEach { number ->
            bw.write("$number\n")
        }
    bw.flush()
    bw.close()
}