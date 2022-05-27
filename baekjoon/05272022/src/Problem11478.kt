import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val sequence = readLine()
    val subsets = mutableSetOf<String>().apply {
        add(sequence)
    }
//    find(subsets, sequence, "", 0)
    var window = 1
    while (window < sequence.length) {
        var start = 0
        while (start + window <= sequence.length) {
            subsets.add(sequence.substring(start, start + window))
            println("($start,${start+window}) until ${sequence.length} ==> ${sequence.substring(start, start + window)}")
            start++
        }
        window++
    }
    println(subsets)
    bw.write("${subsets.size}")
    bw.flush()
    bw.close()
}

/*
    abcab
    a ab abc abca abcab
    b bc bca bcab
    c ca cab
    a ab
    b
    a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc
*/
fun find(
    subsets: MutableSet<String>,    //  부분집합의 경우의 수
    sequence: String,   //  주어진 문자열
    value: String,
    offset: Int,
) {
    if (offset >= sequence.length) return
    else if (value == "") {
        sequence.forEachIndexed { index, char ->
            subsets.add(char.toString())
            find(subsets, sequence, char.toString(), index + 1)
        }
    } else {
        val generated = value + sequence[offset]
        subsets.add(generated)
        find(subsets, sequence, generated, offset + 1)
    }
}