import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val c = nval.toInt()

    val coordinates = Array(n) { 0 }
    repeat(n) {
        nextToken(); coordinates[it] = nval.toInt()
    }
    coordinates.sort()

    //  공유기 사이의 최소거리를 mid
    var lo = 1
    var hi = coordinates[n-1]
    var ans = 0
    while (hi - lo >= 0) {
        val mid = (lo+hi) / 2
        var installed = 1   //  0번에 설치
        var cursor = coordinates[0]

        for (i: Int in 1 until n) {
            if (cursor + mid <= coordinates[i]) {
                cursor = coordinates[i]
                installed++
            }
        }

        if (installed < c) {
            hi = mid - 1
        } else {
            lo = mid + 1
            ans = mid
        }
    }
    print(ans)
}