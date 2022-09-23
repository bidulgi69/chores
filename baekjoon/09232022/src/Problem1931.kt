import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val cases = nval.toInt()
    val meetings = mutableListOf<Pair<Long, Long>>()

    repeat(cases) {
        nextToken(); val startsAt = nval.toLong()
        nextToken(); val endsAt = nval.toLong()
        meetings.add(
            Pair(startsAt, endsAt)
        )
    }

    meetings.sortWith { o1, o2 ->
        if (o1.second == o2.second) o1.first.compareTo(o2.first)
        else o1.second.compareTo(o2.second)
    }

    var ans = 1
    var lastMeetingEndsAt = meetings[0].second
    for (i: Int in 1 until cases) {
        if (meetings[i].first >= lastMeetingEndsAt) {
            ans++
            lastMeetingEndsAt = meetings[i].second
        }
    }

    print(ans)
}