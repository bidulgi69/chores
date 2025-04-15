package 완전범죄;

class DynamicProgrammingSolution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        boolean[][][] dp = new boolean[len + 1][n][m];
        dp[0][0][0] = true;

        for (int i = 0; i < len; i++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[i][a][b]) continue;

                    int newA = a + info[i][0];
                    if (newA < n) {
                        dp[i + 1][newA][b] = true;
                    }

                    int newB = b + info[i][1];
                    if (newB < m) {
                        dp[i + 1][a][newB] = true;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[len][a][b]) {
                    answer = Math.min(answer, a);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

