import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var inorder: List<Int>
lateinit var postorder: List<Int>
private val bw = System.out.bufferedWriter()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    inorder = readLine().split(" ").map { it.toInt() }
    postorder = readLine().split(" ").map { it.toInt() }

    preorder(0, n-1, 0, n-1)
    bw.flush()
    bw.close()
}

private fun preorder(il: Int, ir: Int, pl: Int, pr: Int) {
    if (il > ir || pl > pr) return
    //  루트 노드는 postorder 의 마지막 값이다.
    val root = postorder[pr]
    //  preorder 이기 때문에 좌,우 자식 노드를 살펴보기 전 출력 수행
    bw.write("$root ")
    //  해당 연산에 O(N) 이 소요되므로, memoization 을 통해 시간 복잡도를 단순화할 수 있다.
    val rootIndex = inorder.indexOf(root)
    val addons = rootIndex-il

    //  좌측 트리로 내려가본다.
    preorder(il, rootIndex-1, pl, pl+addons-1)
    //  우측 트리로 내려가본다.
    preorder(rootIndex+1, ir, pl+addons, pr-1)
}