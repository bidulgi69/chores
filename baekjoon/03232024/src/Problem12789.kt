package src

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stack = Stack<Int>()

    val tickets: Queue<Int> = LinkedList()
    //  initialize
    readLine().split(" ")
        .forEach { tickets.offer(it.toInt()) }

    var ticket = 1
    while (!tickets.isEmpty()) {
        val head = tickets.poll()
        if (ticket != head) {
            stack.push(head)
        } else {    //  간식 받음
            ticket = head+1
            while (!stack.isEmpty() && ticket == stack.peek()) {
                ticket = stack.pop()+1
            }
        }
    }

    //  remove leftovers
    while (!stack.isEmpty() && ticket == stack.peek()) {
        ticket = stack.pop()+1
    }
    print(if (stack.isEmpty()) "Nice" else "Sad")
}