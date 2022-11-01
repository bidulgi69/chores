import java.io.StreamTokenizer

const val max = 101
const val len = 10
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    val paper = Array(max) { Array(max) { 0 } }
    nextToken(); val n = nval.toInt()
    var ans = 0
    repeat(n) {
        nextToken(); val x = nval.toInt()
        nextToken(); val y = nval.toInt()

        for (i: Int in x until x+len) {
            for (j: Int in y until y+len) {
                if (paper[i][j] == 0) ans++
                paper[i][j] = 1
            }
        }
    }
    print(ans)
}