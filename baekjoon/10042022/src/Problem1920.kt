import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    val numbers = Array(n) { 0 }
    repeat(n) {
        nextToken(); numbers[it] = nval.toInt()
    }

    numbers.sort()

    val bw = System.out.bufferedWriter()
    nextToken(); val m = nval.toInt()
    repeat(m) {
        nextToken()
        bw.write("${binarySearch(numbers, 0, n, nval.toInt())}\n")
    }
    bw.flush()
    bw.close()
}

private fun binarySearch(numbers: Array<Int>, lo: Int, hi: Int, target: Int): Int {
    if (lo == hi) return 0
    val mid = (lo+hi) / 2
    return if (numbers[mid] == target) {
        1
    } else if (numbers[mid] >= target) {
        binarySearch(numbers, lo, mid, target)
    } else binarySearch(numbers, mid+1, hi, target)
}