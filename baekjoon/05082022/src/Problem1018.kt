import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val sizes: List<Int> = readLine()
        .split(" ")
        .map { it.toInt() }

    val board = Array(sizes[0]) { BooleanArray(sizes[1]) }
    repeat(sizes[0]) { row ->
        readLine()
            .mapIndexed { col, color ->
                board[row][col] = color == 'B'
            }
    }
    //  Black == true
    //  White == false
    //  window: 8x8
    val repairs = mutableListOf<Int>()
    for (i: Int in 0..sizes[0] - 8) {
        for (j: Int in 0..sizes[1] - 8) {
            var ordered = 0
            var unordered = 0
            for (r: Int in i..i+7) {
                for (c: Int in j..j+7) {
                    if ((r + c) % 2 == 0) {
                        if (board[r][c]) ordered++
                        else unordered++
                    } else {
                        if (board[r][c]) unordered++
                        else ordered++
                    }
                }
            }
            repairs.add(min(ordered, unordered))
        }
    }
    bw.write("${repairs.minOf { it }}")
    bw.flush()
    bw.close()
}