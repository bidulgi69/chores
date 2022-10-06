fun main() {
    val test1Users = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val test1Ban = arrayOf("fr*d*", "abc1**")
    println("Solution 1: ${solution(test1Users, test1Ban)}")

    val test2Users = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val test2Ban = arrayOf("*rodo", "*rodo", "******")
    println("Solution 2: ${solution(test2Users, test2Ban)}")

    val test3Users = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val test3Ban = arrayOf("fr*d*", "*rodo", "******", "******")
    println("Solution 3: ${solution(test3Users, test3Ban)}")
}

fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
    val matches = Array<MutableList<String>>(banned_id.size) { mutableListOf() }
    for (i: Int in banned_id.indices) {
        for (j: Int in user_id.indices) {
            if (isSame(banned_id[i], user_id[j])) {
                matches[i].add(user_id[j])
            }
        }
    }
    //  dfs
    val combination = mutableSetOf<MutableSet<String>>()
    dfs(0, mutableListOf(),  matches, combination)
    return combination.size
}

fun dfs(here: Int, paths: MutableList<String>, matches: Array<MutableList<String>>, groups: MutableSet<MutableSet<String>>) {
    if (here == matches.size) {
        groups.add(paths.toMutableSet())
    } else {
        for (i: Int in matches[here].indices) {
            if (!paths.contains(matches[here][i])) {
                val next = mutableListOf<String>().apply { addAll(paths) }
                next.add(matches[here][i])
                dfs(here+1, next, matches, groups)
            }
        }
    }
}

fun isSame(banned: String, user: String): Boolean {
    if (banned.length == user.length) {
        for (i: Int in banned.indices) {
            if (banned[i] != '*' && banned[i] != user[i])
                return false
        }
    } else return false

    return true
}