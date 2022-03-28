import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    val alphabets = IntArray(26) { 101 }    //  initialize with max length
    var numbers = 0

    for (i: Int in 0 until cases) {
        val word = readLine()

        word.forEachIndexed { index, alphabet ->
            val locate: Int = alphabet.code - 97
            if (alphabets[locate] == 101 || alphabets[locate] + 1 == index) {
                alphabets[locate] = index
            } else {
                alphabets[locate] = -1   //  연속되지 않음을 표시
            }
        }
        if (alphabets.minOf { it } != -1) numbers++
        alphabets.fill(101)   //  initialize
    }
    bw.write("$numbers")
    bw.flush()
}