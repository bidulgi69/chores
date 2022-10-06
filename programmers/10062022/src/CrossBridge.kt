fun main() {
    val s = CrossBridge()
    val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
    println(s.solution(stones, 3))
}

class CrossBridge {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var lo = stones[0]
        var hi = stones[0]
        for (i: Int in 1 until stones.size) {
            if (lo > stones[i]) lo = stones[i]
            if (hi < stones[i]) hi = stones[i]
        }

        while (hi-lo >= 0) {
            //  x = N 명이 건넘.
            val mid = (lo+hi) / 2
            var jumped = 0
            for (i: Int in stones.indices) {
                if (stones[i] - mid <= 0) jumped++
                else jumped = 0

                if (jumped == k) break
            }

            if (jumped < k) {   //  더 많은 사람이 건널 수 있음
                lo = mid+1
            } else {    //  jumped==k
                hi = mid-1
                answer = mid
            }
        }

        return answer
    }
}

/*
O(n^2) sliding window
var answer = Int.MAX_VALUE
val len = stones.size
for (i: Int in 0..len-k) {
    var max = stones[i]
    for (j: Int in i until i+k) {
        if (max < stones[j]) max = stones[j]
    }

    if (answer > max) answer = max
}

return answer
 */