import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    var sum = 0
    for(i: Int in 0 until cases) {
        val quiz = readLine()
        var acc = 1
        quiz
            .forEach {
               if (it == 'O') {
                   sum += acc++
               } else if (it == 'X') {
                   acc = 1
               }
            }
        bw.write("$sum\n")
        sum = 0
    }
    bw.flush()
}