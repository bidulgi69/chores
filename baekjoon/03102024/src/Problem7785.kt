import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val log = mutableSetOf<String>()

    repeat(n) {
        val (name, lg) = readLine().split(" ")
        if ("enter" == lg) log.add(name)
        else if ("leave" == lg) log.remove(name)
    }

    val bw = System.out.bufferedWriter()
    log.stream()
        .sorted { s1, s2 -> s2.compareTo(s1) }
        .forEach { name -> bw.write("$name\n") }
    bw.flush()
}