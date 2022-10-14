import java.io.StreamTokenizer
import kotlin.math.max

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val q = nval.toInt()
    val blocks = Array(n) { 0 }
    repeat(n) {
        nextToken(); blocks[it] = nval.toInt()
    }

    val bw = System.out.bufferedWriter()
    var x: Int
    var y: Int
    repeat(q) {
        nextToken(); x = nval.toInt()-1
        nextToken(); y = nval.toInt()-1


        val r = if (y >= n || x >= blocks[y]) 0 else blocks[y]-x
        //  O(n) 시간초과
        //  O(log n) 으로 줄여야 함. --> binary search
        //  넴모 층들은 위에서부터 아래로 오름차순 정렬돼있는 상태이기 때문에, 이분 탐색 사용이 가능하다.
        var lo = 0
        var hi = n-1
        var mid: Int
        var h = 0
        while (hi - lo >= 0) {
            mid = (hi + lo) / 2
            if (blocks[mid] > x) {
                lo = mid+1
                h = mid
            } else {
                hi = mid-1
            }
        }
        h -= y
        bw.write("${max(0, r+h)}\n")
    }
    bw.flush()
    bw.close()
}
/*
O(n) 시간초과
var h = 0
for (i: Int in y until n) {
    if (blocks[i] > x) h++
}
 */