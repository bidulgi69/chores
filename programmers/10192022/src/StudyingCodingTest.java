public class StudyingCodingTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int alp = 10;
        int cop = 10;
        int[][] p1 = {{10,15,2,1,2},{20,20,3,3,4}};
        System.out.println(solution.solution(alp, cop, p1));    //  15

        alp = 0;
        cop = 0;
        int[][] p2 = {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
        System.out.println(solution.solution(alp, cop, p2));    //  13
    }

    static class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            final int INF = 1000000000;
            int minReqAlp = 151, minReqCop = 151, maxReqAlp = -1, maxReqCop = -1;
            for (int[] problem : problems) {
                if (problem[0] < minReqAlp) minReqAlp = problem[0];
                if (problem[1] < minReqCop) minReqCop = problem[1];
                if (problem[0] > maxReqAlp) maxReqAlp = problem[0];
                if (problem[1] > maxReqCop) maxReqCop = problem[1];
            }

            if (alp >= maxReqAlp && cop >= maxReqCop) return 0;
            if (alp > maxReqAlp) alp = maxReqAlp;
            if (cop > maxReqCop) cop = maxReqCop;

            final int[][] dp = new int[151][151];
            for (int i = alp; i <= maxReqAlp; i++) {
                for (int j = cop; j <= maxReqCop; j++) {
                    dp[i][j] = INF;
                }
            }

            dp[alp][cop] = 0;
            int ni, nj; //  문제를 푼 후 이동하는 좌표
            for (int i = alp; i <= maxReqAlp; i++) {
                for (int j = cop; j <= maxReqCop; j++) {
                    if (i+1 <= maxReqAlp) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                    if (j+1 <= maxReqCop) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);

                    for (int[] problem : problems) {
                        if (i >= problem[0] && j >= problem[1]) {
                            ni = Math.min(i + problem[2], maxReqAlp);
                            nj = Math.min(j + problem[3], maxReqCop);
                            dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + problem[4]);
                        }
                    }
                }
            }

            System.out.printf("dp[%d][%d]:::\t\t%d\n", maxReqAlp, maxReqCop, dp[maxReqAlp][maxReqCop]);
            return dp[maxReqAlp][maxReqCop];
        }
    }
}
