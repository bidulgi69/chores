import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/*
크로아티아 알파벳	변경
            č	c=
            ć	c-
            dž	dz=
            đ	d-
            lj	lj
            nj	nj
            š	s=
            ž	z=
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val croatianAlphabets = readLine()
    val bw = System.out.bufferedWriter()
    var numbers = 0

    val len = croatianAlphabets.length
    val croatians = listOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")

    var offset = 0
    while (offset < len) {
        offset += if (croatianAlphabets.substring(offset, min(offset + 3, len)) in croatians) {
            3
        } else if (croatianAlphabets.substring(offset, min(offset + 2, len)) in croatians) {
            2
        } else {
            1
        }
        numbers++
    }

    bw.write("$numbers")
    bw.flush()
}