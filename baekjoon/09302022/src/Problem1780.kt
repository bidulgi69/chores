import java.io.StreamTokenizer

private lateinit var papers: Array<Array<Int>>
var zero = 0
var minus = 0
var plus = 0
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    papers = Array(n) { Array(n) { 0 } }

    repeat(n) { row ->
        repeat(n) { col ->
            nextToken(); papers[row][col] = nval.toInt()
        }
    }

    dq(n, 0, 0)
    print("$minus\n$zero\n$plus")
}

private fun dq(n: Int, i: Int, j: Int) {
    if (n == 0) return

    var mi = 0
    var ze = 0
    var pl = 0
    for (p: Int in i until i+n) {
        for (q: Int in j until j+n) {
            when (papers[p][q]) {
                -1 -> mi++
                0 -> ze++
                1 -> pl++
            }
        }
    }

    val area = n*n
    if (ze == area) {
        zero++
    } else if (mi == area) {
        minus++
    } else if (pl == area) {
        plus++
    } else {
        //  divide
        val step = n/3
        val twoSteps = step * 2
        dq(step, i, j)
        dq(step, i, j+step)
        dq(step, i, j+twoSteps)
        dq(step, i+step, j)
        dq(step, i+step, j+step)
        dq(step, i+step, j+twoSteps)
        dq(step, i+twoSteps, j)
        dq(step, i+twoSteps, j+step)
        dq(step, i+twoSteps, j+twoSteps)
    }
}