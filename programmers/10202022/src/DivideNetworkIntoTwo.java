public class DivideNetworkIntoTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] w1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution.solution(9, w1));
        int[][] w2 = {{1,2},{2,3},{3,4}};
        System.out.println(solution.solution(4, w2));
        int[][] w3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        System.out.println(solution.solution(7, w3));
    }

    static class Solution {
        public int solution(int n, int[][] wires) {
            int answer = 101;
            for (int i = 0; i < wires.length; i++) {
                //  exclude wire at i
                int[] parent = new int[n+1];
                for (int k = 1; k <= n; k++) {
                    parent[k] = k;
                }

                int[] wire;
                for (int j = 0; j < wires.length; j++) {
                    if (i != j) {
                        wire = wires[j];
                        int p1 = getParent(parent, wire[0]);
                        int p2 = getParent(parent, wire[1]);

                        if (p1 != p2) {
                            if (p1 > p2) parent[p1] = parent[p2];
                            else parent[p2] = parent[p1];
                        }
                    }
                }

                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    if (getParent(parent, parent[k]) == 1) sum++;
                }

                answer = Math.min(
                        answer,
                        Math.abs(n-2*sum)
                );
            }
            return answer;
        }

        int getParent(int[] parent, int n) {
            if (parent[n] == n) return n;
            else return parent[n] = getParent(parent, parent[n]);
        }
    }
}
