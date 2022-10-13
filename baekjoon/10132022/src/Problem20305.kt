import java.io.StreamTokenizer
import java.util.Arrays

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); var k = nval.toInt()

    val scores = Array(n) { 0 }
    repeat(n) {
        nextToken(); scores[it] = nval.toInt()
    }
    //  timsort
    Arrays.sort(scores)
    print(scores[n-k])
}