import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val numbers = Array(n) { 0 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    //  increasing subsequence 이기 때문에 오름차순 정렬.
    val lis = mutableListOf<Int>()
    //  O(n*log n)
    numbers.forEach { number ->
        findAndUpdate(lis, number)
    }
    print(lis.size)
}

fun findAndUpdate(lis: MutableList<Int>, target: Int) {
    if (lis.isEmpty() || lis[lis.size-1] < target) {
        lis.add(target)
    } else {
        //  binary search 를 사용해 logN 으로 시간 복잡도를 감소시킬 수 있다.
        var lo = 0
        var hi = lis.size
        var loc = 0
        while (hi - lo >= 0) {
            val mid = (lo+hi)/2
            if (lis[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid - 1
                loc = mid
            }
        }
        lis[loc] = target
    }
}