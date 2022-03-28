import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val bw = System.out.bufferedWriter()
    var cases = 0
    for (i: Int in 1..n) {
        if (isArithmeticSequence(i)) cases++
    }
    bw.write("$cases")
    bw.flush()
}

fun isArithmeticSequence(number: Int): Boolean {
    val digits: List<Int> = "$number".map {
        it.digitToInt()
    }
    if (digits.size == 1) return true
    else {
        var diff = digits[0] - digits[1]
        for (i: Int in 2 until digits.size) {
            val currentDiff = digits[i - 1] - digits[i]
            if (diff != currentDiff) return false
            else diff = currentDiff
        }
        return true
    }
}