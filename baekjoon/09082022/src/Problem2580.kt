package src

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var sudoku: Array<Array<Int>>
val bw = System.out.bufferedWriter()
const val size: Int = 9

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    sudoku = Array(size) { Array(size) { 0 } }
    repeat(size) { row ->
        readLine()
            .split(" ")
            .forEachIndexed { col, v ->
                sudoku[row][col] = v.toInt()
            }
    }

    try {
        solve(0, 0)
    } catch (ignored: IndexOutOfBoundsException) { }
    sudoku.forEach { row ->
        row.forEach { value ->
            bw.write("$value ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

@Throws(IndexOutOfBoundsException::class)
fun solve(i: Int, j: Int) {
    val cell = getNextCell(i, j)
    if (sudoku[i][j] == 0) {
        for (value: Int in 1..size) {
            if (isAvailable(i, j, value)) {
                sudoku[i][j] = value
                solve(cell.first, cell.second)
            }
        }
        sudoku[i][j] = 0
    } else {
        solve(cell.first, cell.second)
    }
}

fun isAvailable(i: Int, j: Int, value: Int): Boolean {
    //  check row
    for (v: Int in sudoku[i]) {
        if (v == value) return false
    }
    //  check column
    for (offset: Int in 0 until size) {
        if (sudoku[offset][j] == value) return false
    }
    //  check square
    val rowFrom = (i / 3) * 3
    val colFrom = (j / 3) * 3
    for (p: Int in rowFrom..rowFrom + 2) {
        for (q: Int in colFrom..colFrom + 2) {
            if (sudoku[p][q] == value) return false
        }
    }
    return true
}

fun getNextCell(i: Int, j: Int): Pair<Int, Int> {
    var nextI = i
    var nextJ = j + 1
    if (nextJ == 9) {
        nextI += 1
        nextJ = 0
    }
    return Pair(nextI, nextJ)
}