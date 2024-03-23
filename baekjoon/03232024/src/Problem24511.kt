package src

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Deque
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dsn = readLine().toInt()
    val types = IntArray(dsn)
    val out: Deque<Int> = LinkedList()

    readLine().split(" ")
        .forEachIndexed { i, type ->
            types[i] = type.toInt()   //  0: queue, 1: stack
        }

    //  init
    readLine().split(" ")
        .forEachIndexed { i, n ->
            if (types[i] == 0) out.offerFirst(n.toInt())
        }
    readLine()  //  ignore
    val bw = System.out.bufferedWriter()

    //  insert
    readLine().split(" ")
        .forEach { n ->
            out.offer(n.toInt())
            bw.write("${out.poll()} ")
        }

    bw.flush()
    bw.close()
    this.close()
}