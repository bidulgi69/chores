import java.io.StreamTokenizer
import java.util.PriorityQueue
import kotlin.math.max

class Candidate(
    val pr: Int,
    val ir: Int,
): Comparable<Candidate> {

    override fun compareTo(other: Candidate): Int {
        return pr.compareTo(other.pr)
    }
}

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()
    val bw = System.out.bufferedWriter()
    repeat(cases) {
        nextToken(); val candidates = nval.toInt()
        val pq = PriorityQueue<Candidate>()
        repeat(candidates) {
            nextToken(); val paperRank = nval.toInt()
            nextToken(); val interviewRank = nval.toInt()

            pq.offer(Candidate(paperRank, interviewRank))
        }

        val superior = pq.poll()
        var superiorIr = superior.ir
        var hiring = 1
        while (!pq.isEmpty()) {
            val candidate = pq.poll()
            if (candidate.ir < superiorIr) {
                hiring++
                superiorIr = candidate.ir
            }
        }

        bw.write("$hiring\n")
    }
    bw.flush()
    bw.close()
}
