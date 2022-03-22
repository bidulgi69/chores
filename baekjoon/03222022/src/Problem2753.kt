import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val year: Int = readLine().toInt()
    print(isLeapYear(year))
}

fun isLeapYear(year: Int): Int {
    //윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
    if (year % 400 == 0) return 1
    else if (year % 4 == 0) {
        return if (year % 100 != 0) 1 else 0
    }
    return 0
}