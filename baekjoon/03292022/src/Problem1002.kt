import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cases: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        val numbers: List<Float> = readLine()
            .split(" ")
            .map { it.toFloat() }
        val x1 = numbers[0]
        val y1 = numbers[1]
        val r1 = numbers[2]

        val x2 = numbers[3]
        val y2 = numbers[4]
        val r2 = numbers[5]

        //  d = 두 원의 중심 사이의 거리
        val d = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
        when {
            //  두 원이 원점, 크기가 동일한 경우
            d == 0f && r1 == r2 -> bw.write("-1\n")
            //  외부 || 내부
            abs(r1 - r2) > d || r1 + r2 < d -> bw.write("0\n")
            //  외접 || 내접
            abs(r1 - r2) == d || r1 + r2 == d -> bw.write("1\n")
            //  두 점에서 만나는 경우
            r1 + r2 > d -> bw.write("2\n")
        }
    }
    bw.flush()
    bw.close()
}