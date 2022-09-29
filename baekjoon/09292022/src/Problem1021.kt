import java.io.StreamTokenizer
import java.util.Deque
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()

    val removed = Array(n+1) { false }
    val offsets = Array(m) { 0 }
    repeat(m) {
        nextToken()
        offsets[it] = nval.toInt()
    }

    val deque: Deque<Int> = LinkedList()
    for (i: Int in 1..n) {
        deque.offer(i)
    }

    var i = 0
    var ans = 0
    while (i < m) {
        val num = offsets[i]
        val peek = deque.peek()

        var left = 0
        var right = 0
        if (num > peek) {
            for (q: Int in num-1 downTo peek) if (!removed[q]) left++
            var p = num
            while (p != peek) {
                p = (p+1) % n
                if (p == 0) p = n
                if (!removed[p]) right++
            }
        } else if (num < peek) {
            var p = num
            while (p != peek) {
                p = (p-1+n) % n
                if (p == 0) p = n
                if (!removed[p]) left++
            }
            for (q: Int in num+1..peek) if (!removed[q]) right++
        }

        if (left > right) {
            ans += right
            while (right-- > 0) {
                deque.offerFirst(deque.pollLast())
            }
        } else {
            ans += left
            while (left-- > 0) {
                deque.offer(deque.poll())
            }
        }
        removed[deque.poll()] = true
        i++
    }
    print(ans)
}