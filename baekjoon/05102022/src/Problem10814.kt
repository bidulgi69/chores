import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val repeats = readLine().toInt()
    val judges = mutableListOf<Person>()
    repeat(repeats) { index ->
        judges.add(
            readLine()
                .split(" ")
                .let { values ->
                    Person(
                        index,
                        values[0].toInt(),
                        values[1]
                    )
                }
        )
    }

    judges.sortWith { p1, p2 ->
        if (p1.age == p2.age) p1.index - p2.index
        else p1.age - p2.age
    }
    judges
        .forEach { person ->
            bw.write("${person.age} ${person.name}\n")
        }

    bw.flush()
    bw.close()
}

data class Person(
    val index: Int,
    val age: Int,
    val name: String,
)