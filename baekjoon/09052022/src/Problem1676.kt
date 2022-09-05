//package src
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//import kotlin.math.min
//
//var zeros: Int = 0
//var twos: Int = 0
//var fives: Int = 0
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val n = readLine().toInt()
//    factorialTour(n)
//    println(zeros + min(twos, fives))
//}
//
//fun factorialTour(n: Int) {
//    if (n < 2) return
//    else {
//        factorialTour(n - 1)
//        tear(n)
//    }
//}
//
//fun tear(n: Int) {
//    var num = n
//    while (num % 10 == 0) {
//        num /= 10
//        zeros++
//    }
//
//    while (num % 5 == 0) {
//        num /= 5
//        fives++
//    }
//
//    while (num % 2 == 0) {
//        num /= 2
//        twos++
//    }
//}