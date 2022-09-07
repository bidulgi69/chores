package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

var cases = 0
lateinit var offsets: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val board: Array<Array<Boolean>> = Array(n) { Array(n) { false } }
    offsets = Array(n) { 0 }

    solve(0, n, board)
    solve2(0, n)
    println(cases)
}

//  offsets 배열은 퀸이 놓인 체스판의 column index 값을 저장.
//  현재 rowOffset 값은 확인하지 않으므로, deep copy 후 전달할 필요가 없다.
fun solve2(rowOffset: Int, queens: Int) {
    if (queens == 0) {
        cases++
        return
    } else {
        //  find an offset of next queen.
        println("Solve2:::\t\tRow offset: $rowOffset\t\tLeft Queens: $queens\t\tOffsets: ${offsets.toList()}\n")
        for (i: Int in offsets.indices) {
            println("Check if available::\t\tColumn Index: $i\t\tIsAvailable: ${isAvailable(rowOffset, i)}")
            if (isAvailable(rowOffset, i)) {
                offsets[rowOffset] = i
                solve2(rowOffset + 1, queens - 1)
            }
        }
    }
}

fun isAvailable(rowOffset: Int, queenOffset: Int): Boolean {
    for (i: Int in 0 until rowOffset) {
        if (offsets[i] == queenOffset) return false
        else if (rowOffset - i == abs(queenOffset - offsets[i])) return false
    }
    return true
}

//  메모리 초과
fun solve(rowOffset: Int, queens: Int, board: Array<Array<Boolean>>) {
    println("Solve: $rowOffset\t\tLeft Queens: $queens\t\t")
    for (i: Int in board.indices) {
        print2dArray(board)
        clone(board).run {
            if (!this[rowOffset][i]) {
                //  colour row
                for (j: Int in this[rowOffset].indices)
                    this[rowOffset][j] = true
                //  colour column
                for (k: Int in this.indices)
                    this[k][i] = true
                //  colour diagonals
                var p = rowOffset
                var q = i
                var offset = 0
                //  diagonals on right side
                while (++q < this.size) {
                    offset--
                    if (p + offset >= 0) this[p + offset][q] = true
                    if (p - offset < this.size) this[p - offset][q] = true
                }
                //  diagonals on left side
                p = rowOffset
                q = i
                offset = 0
                while (--q >= 0) {
                    offset--
                    if (p + offset >= 0) this[p + offset][q] = true
                    if (p - offset < this.size) this[p - offset][q] = true
                }

                if (queens - 1 == 0) cases++
                else solve(rowOffset + 1, queens - 1, this)
            }
        }
    }
}

private fun clone(array: Array<Array<Boolean>>): Array<Array<Boolean>> {
    return array.map {
        it.clone()
    }.toTypedArray()
}

private fun print2dArray(array: Array<Array<Boolean>>) {
    println("-----------------------------------------------------")
    for (i: Int in array.indices) {
        val row = array[i].toList().toString()
        println("$i::\t\t$row")
    }
    println("-----------------------------------------------------")
}