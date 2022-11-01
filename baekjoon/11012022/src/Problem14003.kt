import java.io.StreamTokenizer

lateinit var numbers: Array<Int>
lateinit var res: Array<Int>
fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    numbers = Array(n) { 0 }
    res = Array(n) { -1 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    val indexes = mutableListOf<Int>()
    for (i: Int in numbers.indices) {
        search(indexes, i)
    }

    var cursor = indexes[indexes.size-1]
    val lis = Array(indexes.size) { 0 }
    var i = lis.size-1
    while (i >= 0 && cursor != -1) {
        lis[i--] = numbers[cursor]
        cursor = res[cursor]
    }

    val bw = System.out.bufferedWriter()
    bw.write("${lis.size}\n")
    for (num: Int in lis) {
        bw.write("$num ")
    }
    bw.flush()
    bw.close()
}

fun search(indexes: MutableList<Int>, loc: Int) {
    val num = numbers[loc]
    if (indexes.isEmpty()) {
        indexes.add(loc)
    } else if (numbers[indexes[indexes.size-1]] < num) {
        res[loc] = indexes[indexes.size-1]
        indexes.add(loc)
    } else {
        var l = 0
        var r = indexes.size
        var idx = 0
        var mid: Int
        while (r - l >= 0) {
            mid = (l + r) / 2
            if (numbers[indexes[mid]] < num) {
                l = mid+1
            } else {
                r = mid-1
                idx = mid
            }
        }
        indexes[idx] = loc
        if (idx > 0) res[loc] = indexes[idx-1]
    }
}

//11
//3 4 -1 5 8 2 3 12 7 9 10
//10
//-61 -28 -72 59 13 -21 84 -76 -52 -1
//ans=-61 -28 -21 -1