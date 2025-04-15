package 도넛과막대그래프;

import java.util.*;

public class Solution {

    class Degree {
        int in;
        int out;

        public Degree() {
            this.in = 0;
            this.out = 0;
        }

        public int sum() {
            return out - in;
        }
    }

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, List<Integer>> graphs = new HashMap<>();
        Map<Integer, Degree> degrees = new HashMap<>();

        for (int[] edge : edges) {
            graphs.compute(edge[0], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }

                v.add(edge[1]);
                return v;
            });

            // out: +1
            degrees.compute(edge[0], (k, v) -> {
                if (v == null) {
                    v = new Degree();
                }

                v.out++;
                return v;
            });
            // in: -1
            degrees.compute(edge[1], (k, v) -> {
                if (v == null) {
                    v = new Degree();
                }

                v.in++;
                return v;
            });
        }

        int sticks = 0;
        int eights = 0;
        int startVertex = degrees.entrySet().stream()
            .filter(entry -> entry.getValue().sum() >= 2)
            .findFirst()
            .get()
            .getKey();

        for (int v : graphs.get(startVertex)) {
            degrees.computeIfPresent(v, (k, value) -> {
                value.in--;
                return value;
            });
        }

        for (Map.Entry<Integer, Degree> entry : degrees.entrySet()) {
            if (entry.getKey() == startVertex) {
                continue;
            }

            Degree degree = entry.getValue();
            if (degree.sum() >= 2) {
                startVertex = entry.getKey();
            } else if (degree.out == 0) {
                sticks++;
            } else if (degree.in == 2 && degree.out == 2) {
                eights++;
            }
        }

        answer[0] = startVertex;
        answer[1] = graphs.get(startVertex).size() - sticks - eights;
        answer[2] = sticks;
        answer[3] = eights;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //[[2, 3], [4, 3], [1, 1], [2, 1]]	[2, 1, 1, 0]
        //[[4, 11], [1, 12], [8, 3], [12, 7], [4, 2], [7, 11], [4, 8], [9, 6], [10, 11], [6, 10], [3, 5], [11, 1], [5, 3], [11, 9], [3, 8]]	[4, 0, 1, 2]
        int[][] edges1 = {{2,3}, {4,3}, {1,1}, {2,1}};
        int[] answer1 = solution.solution(edges1);
        System.out.println("Result 1: " + Arrays.toString(answer1) + "\t(expected: [2, 1, 1, 0])");

        int[][] edges2 = {{4,11}, {1,12}, {8,3}, {12,7}, {4,2}, {7,11}, {4,8}, {9,6}, {10,11}, {6,10}, {3,5}, {11,1}, {5,3}, {11,9}, {3,8}};
        int[] answer2 = solution.solution(edges2);
        System.out.println("Result 2: " + Arrays.toString(answer2) + "\t(expected: [4, 0, 1, 2])");

        //[[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [7, 8], [8, 9], [9, 10], [11, 10], [11, 1]]
        //[11, 0, 2, 0]
        int[][] edges3 = {{1,2},{2,3},{3,4},{4,5},{5,6},{7,8},{8,9},{9,10},{11,10},{11,1}};
        int[] answer3 = solution.solution(edges3);
        System.out.println("Result 3: " + Arrays.toString(answer3) + "\t(expected: [11, 0, 2, 0])");

        //[[1, 12], [8, 3], [12, 7], [7, 11], [9, 6], [10, 11], [6, 10], [3, 5], [11, 1], [5, 3], [11, 9], [3, 8], [4, 11], [4, 8]]
        //[4, 0, 0, 2]
        int[][] edges4 = {{1,12},{8,3},{12,7},{7,11},{9,6},{10,11},{6,10},{3,5},{11,1},{5,3},{11,9},{3,8},{4,11},{4,8}};
        int[] answer4 = solution.solution(edges4);
        System.out.println("Result 4: " + Arrays.toString(answer4) + "\t(expected: [4, 0, 0, 2])");

        //[[4, 11], [1, 12], [8, 3], [12, 7], [7, 11], [4, 8], [9, 6], [10, 11], [6, 10], [3, 5], [11, 1], [5, 3], [11, 9], [3, 8]]
        //[4, 0, 0, 2]
        int[][] edges5 = {{4,11},{1,12},{8,3},{12,7},{7,11},{4,8},{9,6},{10,11},{6,10},{3,5},{11,1},{5,3},{11,9},{3,8}};
        int[] answer5 = solution.solution(edges5);
        System.out.println("Result 5: " + Arrays.toString(answer5) + "\t(expected: [4, 0, 0, 2])");
    }
}
