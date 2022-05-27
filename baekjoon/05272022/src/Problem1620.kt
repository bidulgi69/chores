import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val numKeyDict: Array<String> = Array(n) { "" }
    val nameKeyDict = mutableMapOf<String, Int>()
    repeat(n) { index ->
        val name = readLine()
        numKeyDict[index] = name
        nameKeyDict[name] = index + 1
    }

    val bw = System.out.bufferedWriter()
    repeat(m) {
        val quest = readLine()
        try {   //  quest: index
            bw.write("${numKeyDict[quest.toInt()-1]}\n")
        } catch (e: NumberFormatException) {    //  quest: name
            bw.write("${nameKeyDict[quest]}\n")
        }
    }
    bw.flush()
    bw.close()
}