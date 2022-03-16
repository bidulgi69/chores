package 등굣길;

public class Solution {
    final int DENOM = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        final int[][] map = new int[m][n];

        for (int[] puddle : puddles) map[puddle[0] - 1][puddle[1] - 1] = -1;
        for (int i = 0; i < m; i++) {
            if (map[i][0] == -1) break;
            map[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (map[0][j] == -1) break;
            map[0][j] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (map[row][col] != -1) {
                    map[row][col] = (Math.max(map[row - 1][col], 0) + Math.max(map[row][col - 1], 0)) % DENOM;
                }
            }
        }

        return map[m - 1][n - 1] % DENOM;
    }
}