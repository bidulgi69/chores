import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()
    val cases = readLine().toInt()

    val frequencies = Array(s.length) { Array(26) { 0 } }
    for (i: Int in s.indices) {
        if (i == 0) {
            frequencies[i][s[i].code-97] = 1
        } else {
            System.arraycopy(frequencies[i-1], 0, frequencies[i], 0, 26)
            frequencies[i][s[i].code-97]++
        }
    }

    val bw = System.out.bufferedWriter()
    repeat(cases) {
        val tokenizer = StringTokenizer(readLine())
        val alphabet = tokenizer.nextToken()
        val i = tokenizer.nextToken().toInt()
        val j = tokenizer.nextToken().toInt()

        val alphabetIndex = alphabet[0].code-97
        if (i == 0) {
            bw.write("${frequencies[j][alphabetIndex]}\n")
        } else {
            bw.write("${frequencies[j][alphabetIndex] - frequencies[i - 1][alphabetIndex]}\n")
        }
    }
    bw.flush()
    bw.close()
}