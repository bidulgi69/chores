package 섬연결하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    /**
     * @param n number of islands
     * @param costs bridges
     * @return minimum cost to build bridges between islands
     */
    public int solution(int n, int[][] costs) {
        int answer = 0;
        final List<Bridge> bridges = new ArrayList<>();
        //  sort by ascending
        Arrays
                .stream(costs)
                .sorted(Comparator.comparingInt(c -> c[2]))
                .forEach(cost -> bridges.add(new Bridge(Math.min(cost[0], cost[1]), Math.max(cost[0], cost[1]), cost[2])));

        System.out.printf("Bridges: %s\n\n", bridges);
        //  find MST
        int[] islands = IntStream.range(0, n).toArray();
        for (Bridge bridge : bridges) {
            int from = bridge.from;
            int to = bridge.to;
            System.out.printf("From: %d, to: %d\tCurrent unions: %s\n", from, to, Arrays.toString(islands));

            int fp = getParent(islands, from);
            int tp = getParent(islands, to);
            //  union find
            if (fp != tp) {
                if (fp > tp)
                    islands[fp] = islands[tp];
                else islands[tp] = islands[fp];
                answer += bridge.cost;
            }
        }
        return answer;
    }

    private int getParent(int[] islands, int i) {
        if (islands[i] == i) return i;
        return islands[i] = getParent(islands, islands[i]);
    }
}

class Bridge {
    final int from;
    final int to;
    final int cost;

    public Bridge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("\nBridge (%d-%d), distance: %d", from, to, cost);
    }
}
