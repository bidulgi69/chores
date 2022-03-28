import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val word = readLine().uppercase(Locale.getDefault())
    val bw = System.out.bufferedWriter()
    val alphabets = IntArray(26) { 0 }
    word.map {
        alphabets[it.code - 65]++
    }

    val maxFrequency: Int = alphabets.maxOf { it }
    val results: MutableList<Int> = mutableListOf<Int>().apply {
        alphabets.forEachIndexed { index, frequency ->
            if (frequency == maxFrequency) this.add(index)
        }
    }
    if (results.size > 1) bw.write("?")
    else bw.write("${(results[0] + 65).toChar()}")
    bw.flush()
}