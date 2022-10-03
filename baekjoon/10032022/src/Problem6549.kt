import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var heights: List<Long>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    var line = readLine()
    do {
        heights = line.split(" ").map { it.toLong() }
        val n = heights[0].toInt()
        bw.write("${dq(1, n)}\n")
        line = readLine()
    } while (line != "0")

    bw.flush()
    bw.close()
}

fun dq(i: Int, j: Int): Long {
    return if (i == j) heights[i]
    else {
        val pivot = (i+j)/2
        val l = dq(i, pivot)
        val r = dq(pivot+1, j)
        val area = if (l > r) l else r
        //  양쪽으로 넓혀가며 탐색
        var left = pivot
        var right = pivot
        var minHeight = heights[pivot]
        var maxSpanArea = heights[pivot]
        var span: Long

        while (left > i && right < j) {
            if (heights[left-1] > heights[right+1]) {
                left--
                if (minHeight > heights[left]) minHeight = heights[left]
            } else {
                right++
                if (minHeight > heights[right]) minHeight = heights[right]
            }
            span = minHeight * (right-left+1)
            if (maxSpanArea < span) maxSpanArea = span
        }

        while (left > i) {
            left--
            if (minHeight > heights[left]) minHeight = heights[left]
            span = minHeight * (right-left+1)
            if (maxSpanArea < span) maxSpanArea = span
        }
        while (right < j) {
            right++
            if (minHeight > heights[right]) minHeight = heights[right]
            span = minHeight * (right-left+1)
            if (maxSpanArea < span) maxSpanArea = span
        }

        if (area > maxSpanArea) area else maxSpanArea
    }
}

//  O(n^2)
/*
val heights = line.split(" ").map { it.toInt() }
//  O(n^2)
val n = heights[0]

var ans = 0
for (i: Int in 1..n) {
    var minHeight = heights[i]
    var area = heights[i]
    for (j: Int in i+1..n) {
        if (minHeight > heights[j]) minHeight = heights[j]
        area = kotlin.math.max(area, minHeight * (j-i+1))
    }

    ans = kotlin.math.max(ans, area)
}
bw.write("$ans\n")
 */