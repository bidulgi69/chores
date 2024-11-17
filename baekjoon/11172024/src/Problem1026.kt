fun main() {
    val n = readln().toInt()
    val a = readln().split(" ")
        .map { s -> s.toInt() }
        .sorted()
    val b = readln().split(" ")
        .map { s -> s.toInt() }
        .sortedDescending()

    var sum = 0
    for (i in 0 until n) {
        sum += b[i] * a[i]
    }

    print(sum)
}