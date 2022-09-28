import java.io.StreamTokenizer
import java.util.LinkedList

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val queue = LinkedList<Int>()

    for (i: Int in 1..n) {
        queue.offer(i)
    }

    while (queue.size > 1) {
        queue.pop() //  맨 위 카드를 버림
        queue.offer(queue.pop())    //  그 다음 카드를 맨 뒤로 보냄
    }
    //assert(queue.size == 1)
    print(queue.pop())
}