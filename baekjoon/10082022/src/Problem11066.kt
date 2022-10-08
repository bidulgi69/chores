import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()

    repeat(cases) {
        nextToken(); val n = nval.toInt()
        val numbers = Array(n) { 0 }
        repeat(n) {
            nextToken(); numbers[it] = nval.toInt()
        }

        val sum = Array(n) { 0 }
        sum[0] = numbers[0]
        for (i: Int in 1 until n) {
            sum[i] = sum[i-1]+numbers[i]
        }

        
    }
}