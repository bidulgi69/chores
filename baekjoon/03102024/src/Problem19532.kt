import java.io.InputStreamReader
import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(InputStreamReader(System.`in`))) {
    nextToken(); val a = nval.toInt()
    nextToken(); val b = nval.toInt()
    nextToken(); val c = nval.toInt()
    nextToken(); val d = nval.toInt()
    nextToken(); val e = nval.toInt()
    nextToken(); val f = nval.toInt()
    val y = (c*d - f*a)/(b*d-e*a)
    val x = (f-e*y)/d
    print("$x $y")
}