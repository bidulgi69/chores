public class NonDestroyedBuildings {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] b1 = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] s1 = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution.solution(b1, s1));

        int[][] b2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] s2 = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        System.out.println(solution.solution(b2, s2));
    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;
            int type, r1, c1, r2, c2, degree, i, j;
            //  누적합을 통해 QNM 의 시간 복잡도를 Q+NM 으로 감소시킬 수 있다.
            int[][] prefix = new int[board.length+1][board[0].length+1];
            for (int[] sk : skill) {
                type = sk[0];
                r1 = sk[1];
                c1 = sk[2];
                r2 = sk[3];
                c2 = sk[4];
                degree = type == 1 ? -sk[5] : sk[5];

                prefix[r1][c1] += degree;
                prefix[r2+1][c2+1] += degree;
                prefix[r1][c2+1] -= degree;
                prefix[r2+1][c1] -= degree;
            }
            //  위에서 아래로 누적합 계산
            for (i = 1; i < prefix.length; i++) {
                for (j = 0; j < prefix[i].length; j++) {
                    prefix[i][j] = prefix[i][j]+prefix[i-1][j];
                }
            }
            //  왼쪽에서 오른쪽으로 누적합 계산
            for (i = 1; i < prefix[0].length; i++) {
                for (j = 0; j < prefix.length; j++) {
                    prefix[j][i] = prefix[j][i]+prefix[j][i-1];
                }
            }
            //  계산된 누적합을 원래 행렬에 더해줌.
            for (i = 0; i < board.length; i++) {
                for (j = 0; j < board[i].length; j++) {
                    board[i][j] += prefix[i][j];
                    if (board[i][j] > 0) answer++;
                }
            }

            return answer;
        }
    }
}

/*
//  brute-force (O(Q*(N*M))
for (i = r1; i <= r2; i++) {
    for (j = c1; j <= c2; j++) {
        hp = board[i][j];
        affected = type == 1 ? hp-degree : hp+degree;
        if (hp <= 0 && affected > 0) answer++;
        else if (hp > 0 && affected <= 0) answer--;
        board[i][j] = affected;
    }
}
 */