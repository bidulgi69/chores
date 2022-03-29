import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    print(readLine().split(" ")
        .map { BigDecimal(it) }
        .reduce { x, y ->
            x.add(y)
        }.toString())
}