import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val repeats = readLine().toInt()
    val persons = mutableListOf<Person>()

    repeat(repeats) { r ->
        readLine()
            .let { line ->
                val spec = line
                    .split(" ")
                    .map { it.toInt() }

                persons.add(Person(r, spec[0], spec[1]))
            }
    }

    for (i: Int in persons.indices) {
        var rank = 1
        for (j: Int in persons.indices)
            if (i != j
                && persons[i].weight < persons[j].weight
                && persons[i].height < persons[j].height)
                rank++

        persons[i].rank = rank
    }


    persons.forEach { p ->
        bw.write("${p.rank} ")
    }
    bw.flush()
    bw.close()
}

data class Person(
    val index: Int,
    val weight: Int,
    val height: Int
) {
    var rank = index + 1
}