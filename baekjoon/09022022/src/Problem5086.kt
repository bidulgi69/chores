package src

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    while (true) {
        val (n1, n2) = readLine()
            .split(" ")
            .map { it.toInt() }

        try {
            if (n2 % n1 == 0) {
                bw.write("factor\n")
            } else if (n1 % n2 == 0) {
                bw.write("multiple\n")
            } else {
                bw.write("neither\n")
            }
        } catch (e: ArithmeticException) {
            break
        }
    }

    bw.flush()
    bw.close()
}

