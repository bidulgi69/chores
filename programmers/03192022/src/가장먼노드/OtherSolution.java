package 가장먼노드;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OtherSolution {
    final int INF = 987654321;
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adjacent = Stream
                .generate(() -> new LinkedList<Integer>())
                .limit(n)
                .collect(Collectors.toList());

        for (int[] e : edge) {
            adjacent.get(e[0] - 1).add(e[1] - 1);
            adjacent.get(e[1] - 1).add(e[0] - 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));
        //  starts with node 0
        pq.offer(new int[]{0, 0});

        int[] distances = new int[n];
        Arrays.fill(distances, 1, n, INF);

        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            System.out.printf("Adj of %d: %s\n", e[0], adjacent.get(e[0]));
            for (int i = 0; i < adjacent.get(e[0]).size(); i++) {
                int next = adjacent.get(e[0]).get(i);
                int nextDistance = distances[e[0]] + 1;
                if (distances[next] > nextDistance) {
                    distances[next] = nextDistance;
                    pq.offer(new int[]{next, distances[next]});
                }
            }
        }

        System.out.println(Arrays.toString(distances));
        int max = Arrays.stream(distances).max().orElse(0);
        return (int) Arrays.stream(distances)
                .filter(x -> x == max)
                .count();
    }
}
