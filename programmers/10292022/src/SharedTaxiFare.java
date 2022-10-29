public class SharedTaxiFare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] f1 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution.solution(6, 4, 6, 2, f1));  //  82

        int[][] f2 = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        System.out.println(solution.solution(7, 3, 4, 1, f2));  //  14
        int[][] f3 = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        System.out.println(solution.solution(6, 4, 5, 6, f3));  //  18
    }

    static class Solution {
        //  fares: 인접 행렬 (a->z, cost)
        public int solution(int n, int s, int a, int b, int[][] fares) {
            final int INF = 100000000;
            final int[][] graph = new int[n][n];

            int answer = INF;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) graph[i][j] = INF;
                }
            }
            int c, d, f;
            for (int[] fare : fares) {
                c = fare[0]-1;
                d = fare[1]-1;
                f = fare[2];
                //  undirected graph
                graph[c][d] = f;
                graph[d][c] = f;
            }

            //  floyd-warshall
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (graph[i][j] > graph[i][k] + graph[k][j]) {
                            graph[i][j] = graph[i][k]+graph[k][j];
                        }
                    }
                }
            }

            s -= 1;
            a -= 1;
            b -= 1;
            for (int k = 0; k < n; k++) {
                answer = Math.min(answer, graph[s][k] + graph[k][a] + graph[k][b]);
            }

            return answer;
        }
    }
}
