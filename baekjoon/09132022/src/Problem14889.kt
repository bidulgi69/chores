package src

import java.io.BufferedReader
import java.io.InputStreamReader

var N: Int = 0
var limit: Int = 0
var min: Int = Int.MAX_VALUE
lateinit var chemistry: Array<Array<Int>>
lateinit var flags: Array<Boolean>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine().toInt()
    limit = N / 2

    chemistry = Array(N) { Array(N) { 0 } }
    flags = Array(N) { false }
    repeat(N) { row ->
        readLine()
            .split(" ")
            .forEachIndexed { index, v ->
                chemistry[row][index] = v.toInt()
            }
    }

    //  0 번 선수가 속한 팀과 속하지 않은 팀으로 나누면 된다.
    flags[0] = true
    solve(0, 0)
    print(min)
}

fun solve(here: Int, members: Int) {
    flags[here] = true
    if (members + 1 == limit) {
        calcDiff()
    } else {
        for (i: Int in here + 1 until N) {
            solve(i, members + 1)
        }
    }
    flags[here] = false
}

fun calcDiff() {
    var startTeamChemistry = 0
    var linkTeamChemistry = 0
    for (i: Int in 0 until N) {
        for (j: Int in 0 until N) {
            if (flags[i] && flags[j]) startTeamChemistry += chemistry[i][j]
            else if (!flags[i] && !flags[j]) linkTeamChemistry += chemistry[i][j]
        }
    }
    min = kotlin.math.min(
        min,
        kotlin.math.abs(startTeamChemistry - linkTeamChemistry)
    )
}