import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    var generated = n
    var iter = 0    //  cycle
    val bw = System.out.bufferedWriter()

    do {
        val digits = "${if (generated < 10) "0" else ""}$generated"
        val sum = "$generated".map { it.digitToInt() }.sum()

        generated = "${digits[1]}${if (sum < 10) sum else "$sum"[1].digitToInt()}".toInt()
        iter++
    } while (n != generated)

    bw.write("$iter")
    bw.flush()
}