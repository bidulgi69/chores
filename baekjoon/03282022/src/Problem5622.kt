import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val alphabets: List<Char> = readLine().toList()
    val bw = System.out.bufferedWriter()

    bw.write("${alphabets.map {
        castAlphabetToTime(it)
    }.sum()}\n")
    bw.flush()
}

//  ABC, DEF, GHI, JKL, MNO, PQRS, TUV, WXYZ
fun castAlphabetToTime(alphabet: Char): Int {
    return when (alphabet) {
        'A', 'B', 'C' -> 3
        'D', 'E', 'F' -> 4
        'G', 'H', 'I' -> 5
        'J', 'K', 'L' -> 6
        'M', 'N', 'O' -> 7
        'P', 'Q', 'R', 'S' -> 8
        'T', 'U', 'V' -> 9
        'W', 'X', 'Y', 'Z' -> 10
        else -> 0
    }
}