import java.io.StreamTokenizer

enum class Direction(val move: Int) {
    RIGHT(1),
    LEFT(-1),
    TOP(1),
    BOTTOM(-1)
    ;
}

fun getReverse(dir: Direction) = when(dir) {
    Direction.LEFT -> Direction.RIGHT
    Direction.RIGHT -> Direction.LEFT
    Direction.TOP -> Direction.BOTTOM
    Direction.BOTTOM -> Direction.TOP
}

data class Resolution(
    val _p: Int,
    val _q: Int,
    val cur: Int,
    val opt: Boolean,
)

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val w = nval.toInt()
    nextToken(); val h = nval.toInt()
    nextToken(); val p = nval.toInt()
    nextToken(); val q = nval.toInt()
    nextToken(); val t = nval.toInt()

    //  t>=1
    var resolution = opt(w, h, p, q, t)
    if (resolution.cur < t && resolution.opt) {
        resolution = opt(w, h, p, q, t%resolution.cur)
    }

    print("${resolution._p} ${resolution._q}")
}

fun opt(w: Int, h: Int, p: Int, q: Int, t: Int): Resolution {
    var cur = 0
    var x: Int
    var y: Int
    var _p = p
    var _q = q
    var dx = Direction.RIGHT
    var dy = Direction.TOP

    var optimize = false
    do {
        x = _p+dx.move
        y = _q+dy.move

        if (x > w || x < 0) {
            dx = getReverse(dx)
        }
        if (y > h || y < 0) {
            dy = getReverse(dy)
        }

        _p += dx.move
        _q += dy.move

        if (_p == p && _q == q && dx == Direction.RIGHT && dy == Direction.TOP) {
            optimize = true
        }
    } while (++cur < t && !optimize)

    return Resolution(_p, _q, cur, optimize)
}