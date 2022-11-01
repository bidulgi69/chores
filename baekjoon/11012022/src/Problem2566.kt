import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    var max = 0
    var i = 0
    var j = 0
    repeat(9*9) { offset ->
        nextToken()
        if (nval.toInt() > max) {
            max = nval.toInt()
            i = offset/9
            j = offset%9
        }
    }
    print("$max\n${i+1} ${j+1}")
}