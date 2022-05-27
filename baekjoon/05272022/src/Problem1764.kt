import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()
        .split(" ")
        .map { it.toInt() }

    val dbj = mutableListOf<String>()

    //  중복되는 경우가 없기 때문에 같은 배열에 저장할 수 있다.
    repeat(n) {
        dbj.add(readLine())
    }
    repeat(m) {
        dbj.add(readLine())
    }

    val bw = System.out.bufferedWriter()
    val duplicate: List<String> = dbj.groupBy { it }
        .filter { entry -> entry.value.size >= 2 }
        .keys
        .sorted()
    bw.write("${duplicate.size}\n")
    duplicate.forEach { name ->
        bw.write("$name\n")
    }
    bw.flush()
    bw.close()
}