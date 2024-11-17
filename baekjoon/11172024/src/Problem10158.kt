import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val w = nval.toInt()
    nextToken(); val h = nval.toInt()
    nextToken(); val p = nval.toInt()
    nextToken(); val q = nval.toInt()
    nextToken(); val t = nval.toInt()

    //  t 만큼 이동
    val _p = p+t
    val _q = q+t

    //  벽에 부딛힌 횟수
    val den_p = _p/w
    val den_q = _q/h

    val x: Int = if (den_p % 2 == 0) {
        _p%w
    } else {
        w-_p%w
    }

    val y: Int = if (den_q % 2 == 0) {
        _q%h
    } else {
        h-_q%h
    }

    print("$x $y")
}