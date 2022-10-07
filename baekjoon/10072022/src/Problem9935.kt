import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val characters = readLine()
    val bomb = readLine()
    val reversed = bomb.reversed()
    //  bomb 에는 중복된 문자열이 없기 때문에, 마지막 문자로 검사할 수 있다.
    val trigger = bomb[bomb.length-1]

    val stack = Stack<Char>()
    characters.forEach { c ->
        stack.push(c)
        if (c == trigger) {
            val sb = StringBuilder()
            repeat(min(bomb.length, stack.size)) {
                sb.append(stack.pop())
            }
            if (sb.toString() != reversed) {
                //  rollback
                for (i: Int in sb.length-1 downTo 0)
                    stack.push(sb[i])
            }
        }
    }

    print(
        if (stack.isEmpty()) "FRULA"
        else stack.joinToString("")
    )
}