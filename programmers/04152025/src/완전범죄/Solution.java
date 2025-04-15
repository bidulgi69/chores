package 완전범죄;

public class Solution {
    //backtrack
    public int solution(int[][] info, int n, int m) {
        int[][][] memo = new int[info.length][n+1][m+1];
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= m; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        int ans = dfs(info, memo, 0, n, 0, m, 0);
        return ans >= n ? -1 : ans;
    }

    private int dfs(int[][] info, int[][][] memo,
                    int next,
                    int n, int _n,
                    int m, int _m
    ) {
        if (next >= info.length) {
            if (_n < n && _m < m) {
                return _n;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (memo[next][_n][_m] != -1) {
            return memo[next][_n][_m];
        }

        int aTakes = Integer.MAX_VALUE;
        int bTakes = Integer.MAX_VALUE;
        if (n > _n + info[next][0]) {
            aTakes = Math.min(aTakes, dfs(info, memo, next+1, n, _n+info[next][0], m, _m));
        }
        if (m > _m + info[next][1]) {
            bTakes = Math.min(bTakes, dfs(info, memo, next+1, n, _n, m, _m+info[next][1]));
        }
        memo[next][_n][_m] = Math.min(aTakes, bTakes);
        return memo[next][_n][_m];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
        [[1, 2], [2, 3], [2, 1]]	4	4	2
        [[1, 2], [2, 3], [2, 1]]	1	7	0
        [[3, 3], [3, 3]]	7	1	6
        [[3, 3], [3, 3]]	6	1	-1

         */
        int[][] info1 = {{1,2}, {2,3}, {2,1}};
        int n1 = 4;
        int m1 = 4;
        int ret1 = solution.solution(info1, n1, m1);
        System.out.printf("Result: %d\t(expected: %d)\n", ret1, 2);

        int[][] info2 = {{1,2}, {2,3}, {2,1}};
        int n2 = 1;
        int m2 = 7;
        int ret2 = solution.solution(info2, n2, m2);
        System.out.printf("Result2: %d\t(expected: %d)\n", ret2, 0);

        int[][] info3 = {{3,3}, {3,3}};
        int n3 = 7;
        int m3 = 1;
        int ret3 = solution.solution(info3, n3, m3);
        System.out.printf("Result3: %d\t(expected: %d)\n", ret3, 6);

        int[][] info4 = {{3,3}, {3,3}};
        int n4 = 6;
        int m4 = 1;
        int ret4 = solution.solution(info4, n4, m4);
        System.out.printf("Result4: %d\t(expected: %d)\n", ret4, -1);

        int[][] info5 = {{1,4}, {1,3}, {1,4}};
        int n5 = 6;
        int m5 = 4;
        int ret5 = solution.solution(info5, n5, m5);
        System.out.printf("Result5: %d\t(expected: %d)\n", ret5, 2);
    }
}
//입력값 〉 [[1, 4], [1, 3], [1, 4]], 6, 4
//기댓값 〉 2
