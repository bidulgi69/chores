import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n: Int = readLine().toInt()
    val root = Trie(' ')
    root.fail = root
    repeat(n) {
        root.insert(readLine())
    }

    //  failover
    val q = LinkedList<Trie>()
    var cursor: Trie
    q.offer(root)
    while (!q.isEmpty()) {
        cursor = q.poll()
        for (child: Trie in cursor.children.values) {
            if (cursor == root) {
                child.fail = root
            } else {
                var ref: Trie = cursor.fail!!
                //  till there is no next node
                while (ref != root && ref.children[child.character] == null) ref = ref.fail!!
                //  fail(px) = go(fail(p), x)
                ref = ref.children[child.character] ?: ref
                child.fail = ref
            }
            if (child.fail!!.isTerminal) child.isTerminal = true
            q.offer(child)
        }
    }

    val m: Int = readLine().toInt()
    val bw = System.out.bufferedWriter()
    repeat(m) {
        val w = readLine()
        bw.write(
            if (find(root, w)) "YES\n" else "NO\n"
        )
    }

    bw.flush()
    bw.close()
}

fun find(root: Trie, target: String): Boolean {
    var cursor = root
    for (c: Char in target) {
        cursor = cursor.children[c] ?: run {
            var ref = cursor
            while (ref != root && ref.children[c] == null) ref = ref.fail!!
            ref.children[c] ?: ref
        }

        if (cursor.isTerminal) return true
    }

    return cursor.isTerminal
}

class Trie(
    val character: Char,
    val children: MutableMap<Char, Trie> = mutableMapOf(),
    var isTerminal: Boolean = false,
    var fail: Trie? = null
) {

    fun insert(source: String) {
        var cursor = this
        for (c: Char in source) {
            cursor = cursor.children.computeIfAbsent(c) { Trie(c) }
        }
        cursor.isTerminal = true
    }
}