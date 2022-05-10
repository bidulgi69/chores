import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val repeats = readLine().toInt()
    val points = mutableListOf<Pair<Int, Int>>()

    repeat(repeats) {
        points.add(
            readLine()
                .split(" ")
                .map { it.toInt() }
                .let {
                    Pair(it[0], it[1])
                }
        )
    }

    points.sortWith { o1, o2 ->
        if (o1.second == o2.second)
            o1.first - o2.first
        else o1.second - o2.second
    }

    points
        .forEach { point ->
            bw.write("${point.first} ${point.second}\n")
        }
    bw.flush()
    bw.close()
}