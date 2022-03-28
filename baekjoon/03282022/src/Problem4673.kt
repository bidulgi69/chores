fun main() {
    val bw = System.out.bufferedWriter()
    val numbers = BooleanArray(10001)
    val n = 10000
    for (i: Int in 1..n) {
        if (!numbers[i]) bw.write("$i\n")
        val nextSelfNumber: Int = generateNextSelfNumber(i)
        if (nextSelfNumber <= n) numbers[generateNextSelfNumber(i)] = true
    }

    bw.flush()
}
//  N=100   1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
fun generateNextSelfNumber(root: Int): Int {
    val digits: Int = "$root".map {
        it.digitToInt()
    }.sum()

    return root + digits
}