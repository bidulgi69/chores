import java.io.StreamTokenizer

var white = 0
var blue = 0
private lateinit var paper: Array<Array<Int>>
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    paper = Array(n) { Array(n) { 0 } }
    repeat(n) { row ->
        repeat(n) { col ->
            nextToken(); paper[row][col] = nval.toInt()
        }
    }
    dq(n, 0, 0)
    print("$white\n$blue")
}

private fun dq(n: Int, i: Int, j: Int) {
    var w = 0
    var b = 0
    for (p: Int in i until i+n) {
        for (q: Int in j until j+n) {
            if (paper[p][q] == 1) b++
            else w++
        }
    }

    val area = n*n
    if (b != area && w != area) {
        //  divide
        val window = n/2
        dq(window, i, j)
        dq(window, i+window, j)
        dq(window, i, j+window)
        dq(window, i+window, j+window)
    } else {
        if (b == area) blue++
        else white++
    }
}