import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue

private const val EOP = 100001
private const val INF = 100000000

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val k = nval.toInt()

    //  시간(가중치)의 최소 값을 저장.
    val time = Array(EOP) { INF }
    time[n] = 0
    val queue: Queue<Int> = LinkedList()
    queue.offer(n)

    var cursor: Int
    var teleport: Int
    var forward: Int
    var backward: Int
    while (!queue.isEmpty()) {
        cursor = queue.poll()
        if (cursor == k) {
            print(time[cursor])
            break
        }

        teleport = cursor * 2
        forward = cursor + 1
        backward = cursor - 1

        if (teleport in 0 until EOP && time[teleport] > time[cursor]) {
            queue.offer(teleport)
            time[teleport] = time[cursor]
        }
        if (forward in 0 until EOP && time[forward] > time[cursor] + 1) {
            queue.offer(forward)
            time[forward] = time[cursor]+1
        }
        if (backward in 0 until EOP && time[backward] > time[cursor] + 1) {
            queue.offer(backward)
            time[backward] = time[cursor]+1
        }
    }
}