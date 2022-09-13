//package src
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//
//lateinit var numbers: List<Int>
////  operators[0]: +
////  operators[1]: -
////  operators[2]: x
////  operators[3]: /
//lateinit var operators: MutableList<Int>
//
//var min = Int.MAX_VALUE
//var max = Int.MIN_VALUE
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//
//    val len = readLine().toInt()
//    numbers = readLine()
//        .split(" ")
//        .map { it.toInt() }
//    operators = readLine()
//        .split(" ")
//        .map { it.toInt() }
//        .toMutableList()
//    solve(1, numbers[0])
//    print("$max\n$min")
//}
//
//fun solve(offset: Int, acc: Int) {
//    if (offset == numbers.size) {
//        min = kotlin.math.min(min, acc)
//        max = kotlin.math.max(max, acc)
//    } else {
//        for (i: Int in operators.indices) {
//            if (operators[i] != 0) {
//                val nextAcc = when (i) {
//                    0 -> acc + numbers[offset]
//                    1 -> acc - numbers[offset]
//                    2 -> acc * numbers[offset]
//                    3 -> acc / numbers[offset]
//                    else -> throw IndexOutOfBoundsException()
//                }
//                operators[i]--
//                solve(offset + 1, nextAcc)
//                operators[i]++
//            }
//        }
//    }
//}