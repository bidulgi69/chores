import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val repeats = readLine().toInt()
    var words = mutableListOf<String>()

    repeat(repeats) {
        val word = readLine()
        if (!words.contains(word))
            words.add(word)
    }

    words.sortWith { w1, w2 ->
        if (w1.length != w2.length) {
            w1.length - w2.length
        } else w1.compareTo(w2)
    }

    words
        .forEach { word ->
            bw.write("$word\n")
        }
    bw.flush()
    bw.close()
}