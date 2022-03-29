import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val order = readLine().toInt()
    val bw = System.out.bufferedWriter()

    var numbers = 1

    var progression = 2
    while (numbers < order) {
        numbers += progression++
    }
    val sum = progression
    //  sum 이 홀수일 경우 분모 < 분자
    var numerator = if (sum % 2 == 0) 1 else sum - 1
    var denominator = if (sum % 2 == 0) sum - 1 else 1
    while (numbers-- != order) {
        if (sum % 2 == 0) {
            numerator++
            denominator--
        } else {
            numerator--
            denominator++
        }
    }
    bw.write("$numerator/$denominator")
    bw.flush()
}
//  1/1                                         1
//  1/2 2/1                                     3
//  3/1 2/2 1/3                                 6
//  1/4 2/3 3/2 4/1                             10
//  5/1 4/2 3/3 2/4 1/5                         15
//  1/6 2/5 3/4 4/3 5/2 6/1                     21
//  7/1 6/2 5/3 4/4 3/5 2/6 1/7                 28
//  1/8 2/7 3/6 4/5 5/4 6/3 7/2 8/1             36
//  9/1 8/2 7/3 6/4 5/5 4/6 3/7 2/8 1/9         45
//  1/10 2/9 3/8 4/7 5/6 6/5 7/4 8/3 9/2 10/1   55