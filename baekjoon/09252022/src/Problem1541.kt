import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    var isNegativeDetected = false
    val sb = StringBuilder()
    var sum = 0
    readLine()
        ?. forEach { c ->
            if (c.isDigit()) {
                sb.append(c)
            } else {    //  '+' or '-'
                //  '-' 이후로는 값을 모두 빼줘도 됨. (어떻게든 만들 수 있다.)
                if (isNegativeDetected) {
                    sum -= sb.toString().toInt()
                } else {
                    isNegativeDetected = c == '-'
                    sum += sb.toString().toInt()
                }
                sb.clear()
            }
        }

    if (sb.isNotEmpty()) {
        if (isNegativeDetected) sum -= sb.toString().toInt()
        else sum += sb.toString().toInt()
    }

    print(sum)
}