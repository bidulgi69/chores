import java.util.Stack

//  레이저는 paren 이 인접한 경우
//  막대는 ( 로 시작해서 ) 로 끝나는 (인접하지 않은 경우)
fun main() {
    val stack = Stack<Char>()

    var prev: Char
    var cur: Char
    val input = readln()
    if (input.length <= 2) {
        print("0")
        return
    }

    var split = 0

    prev = input[0]
    stack.push(prev)
    for (c in 1 until input.length) {
        cur = input[c]
        if (cur == '(') {
            stack.push(cur)
        } else {
            stack.pop()
            if (prev == '(') {
                //  레이저 발사
                split += stack.size
            } else {
                //  막대기가 끝남
                split++
            }
        }

        prev = cur
    }

    print(split)
}