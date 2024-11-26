import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {

    var sum = 0
    val list = mutableListOf<Int>()
    repeat(5) {
        nextToken(); val n = nval.toInt()
        sum += n
        list.add(n)
    }

    print("${sum/5}\n${list.sorted()[2]}")
}