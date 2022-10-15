import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()

    //  소수 찾기
    val prime = Array(n+1) { true }
    val numbers = mutableListOf<Int>()
    var i = 2
    while (i*i <= n) {
        if (prime[i]) {
            for (j: Int in i*i..n step i) {
                prime[j] = false
            }
        }
        i++
    }

    for (k: Int in 2..n) {
        if (prime[k]) numbers.add(k)
    }
    numbers.add(0)

    val len = numbers.size-1
    var l = 0
    var r = 0
    var sum = numbers[0]
    var ans = 0
    while (r < len) {
        if (sum < n) {
            sum += numbers[++r]
        } else {
            if (sum == n) {
                ans++
            }
            sum -= numbers[l++]
        }
    }
    print(ans)
}