import java.io.BufferedReader
import java.io.InputStreamReader

private val bw = System.out.bufferedWriter()
const val offset = 65
private lateinit var edges: Array<Node>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    edges = Array(n) { Node() }
    var parent: Int
    var left: Int
    var right: Int
    repeat(n) {
        val values = readLine().split(" ")
        parent = values[0][0].code-offset; edges[parent].value = values[0][0]
        left = values[1][0].code-offset
        right = values[2][0].code-offset

        if (left >= 0) {
            edges[parent].left = left
        }
        if (right >= 0) {
            edges[parent].right = right
        }
    }

    preorder(edges[0])
    bw.appendLine()
    inorder(edges[0])
    bw.appendLine()
    postorder(edges[0])

    bw.flush()
    bw.close()
}

private fun preorder(node: Node) {
    bw.write("${node.value}")
    if (node.left >= 0) preorder(edges[node.left])
    if (node.right >= 0) preorder(edges[node.right])
}

private fun inorder(node: Node) {
    if (node.left >= 0) inorder(edges[node.left])
    bw.write("${node.value}")
    if (node.right >= 0) inorder(edges[node.right])
}

private fun postorder(node: Node) {
    if (node.left >= 0) postorder(edges[node.left])
    if (node.right >= 0) postorder(edges[node.right])
    bw.write("${node.value}")
}

data class Node(
    var value: Char? = null,
    var left: Int = -1,
    var right: Int = -1
)