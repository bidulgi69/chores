import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val word: String = readLine()
    val bw = System.out.bufferedWriter()
    val alphabets = IntArray(26) { -1 } //  initialize array with -1
    word.mapIndexed { index, it ->
        val indexed: Int = it.code - 97
        if (alphabets[indexed] == -1) alphabets[indexed] = index
    }

    alphabets.forEach {
        bw.write("$it ")
    }
    bw.flush()
}