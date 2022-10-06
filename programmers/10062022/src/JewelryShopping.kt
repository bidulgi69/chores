fun main() {
    val s = JewelryShopping()

    val ans = intArrayOf(1, 1)
    ans[0] = 1
    ans[1] = 2

    var gems = arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")
    println("S1: ${s.solution(gems).toList()}")

    gems = arrayOf("AA", "AB", "AC", "AA", "AC")
    println("S2: ${s.solution(gems).toList()}")

    gems = arrayOf("XYZ", "XYZ", "XYZ")
    println("S3: ${s.solution(gems).toList()}")

    gems = arrayOf("ZZZ", "YYY", "NNNN", "YYY", "BBB")
    println("S4: ${s.solution(gems).toList()}")

    gems = arrayOf("A", "AA", "AA", "AAA", "AA", "A")
    println("S5: ${s.solution(gems).toList()}")

}

class JewelryShopping {

    fun solution(gems: Array<String>): IntArray {
        val answer = intArrayOf(1, 1)
        val distinct = gems.toSet()
        if (distinct.size == 1) return answer

        //  two pointer algorithm
        var l = 0
        var r = 0
        val purchased = mutableMapOf<String, Int>()
        var minDist = gems.size + 1
        while (l <= r) {
            if (purchased.size >= distinct.size) {
                purchased[gems[l]] = purchased[gems[l]]!! - 1
                if (purchased[gems[l]] == 0) purchased.remove(gems[l])
                l++
            } else if (r == gems.size) {
                break
            } else {
                purchased[gems[r]] = purchased.getOrDefault(gems[r], 0) + 1
                r++
            }

            if (purchased.size == distinct.size && r-l < minDist) {
                minDist = r-l
                answer[0] = l+1
                answer[1] = r
            }
        }

        return answer
    }
}
/* Brute Force
val candidates = mutableSetOf<Pair<Int, Int>>()
for (i: Int in gems.indices) {
    val purchased = mutableSetOf<String>().apply { add(gems[i]) }
    for (j: Int in i+1 until gems.size) {
        purchased.add(gems[j])
        if (purchased.size == distinct.size) {
            candidates.add(Pair(i, j))
            break
        }
    }
}

val sorted = candidates.sortedWith { p1, p2 ->
    val len1 = p1.second - p1.first
    val len2 = p2.second - p2.first

    if (len1 == len2) {
        p1.first.compareTo(p2.first)
    } else {
        len1.compareTo(len2)
    }
}

return intArrayOf(sorted[0].first + 1, sorted[0].second + 1)
 */