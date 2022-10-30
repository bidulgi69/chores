public class LockAndKey {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(solution.solution(key, lock));   //  true
    }

    static class Solution {
        int n;
        int m;
        int furrow;
        public boolean solution(int[][] key, int[][] lock) {
            n = lock.length;
            m = key.length;
            //  lock 의 홈 개수 구하기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (lock[i][j] == 0) furrow++;
                }
            }
            boolean answer;
            //  initialize
            int[][] span = new int[n*3][n*3];
            for (int i = 0; i < span.length; i++) {
                for (int j = 0; j < span.length; j++) {
                    span[i][j] = -1;
                }
            }
            //  확장한 배열의 중앙에 lock 복사
            for (int i = n; i < 2*n; i++) {
                for (int j = n; j < 2*n; j++) {
                    span[i][j] = lock[i-n][j-n];
                }
            }
            
            answer = fit(key, span);
            //  90 degree
            if (!answer) {
                rotate(key);
                answer = fit(key, span);
            }
            //  180 degree
            if (!answer) {
                rotate(key);
                answer = fit(key, span);
            }
            //  270 degree
            if (!answer) {
                rotate(key);
                answer = fit(key, span);
            }

            return answer;
        }

        //  rotate 90 degree
        public void rotate(int[][] matrix) {
            /*
            1 2 3       7 4 1       9 8 7       3 6 9
            4 5 6   =>  8 5 2   =>  6 5 4   =>  2 5 8
            7 8 9       9 6 3       3 2 1       1 4 7

            1 2 3 4             13 9 5 1
            5 6 7 8         =>  14 10 6 2
            9 10 11 12          15 11 7 3
            13 14 15 16         16 12 8 4
             */
            int[][] temp = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    temp[j][i] = matrix[m-i-1][j];
                }
            }
            //  copy
            for (int i = 0; i < m; i++) {
                System.arraycopy(temp[i], 0, matrix[i], 0, m);
            }
        }

        public boolean fit(int[][] key, int[][] span) {
            int si, sj;
            //  key 배열을 움직이면서 모든 홈이 채워지는지 확인
            //  단, 모든 홈이 채워져도 key 와 lock 의 돌기가 겹치는 경우는 제외해줘야 함.
            for (int i = n-m; i < span.length-m; i++) {
                for (int j = n-m; j < span.length-m; j++) {
                    int matches = 0;
                    boolean conflict = false;
                    for (int p = 0; p < m; p++) {
                        for (int q = 0; q < m; q++) {
                            si = p+i;
                            sj = q+j;
                            if (span[si][sj] == 0 && key[p][q] == 1) matches++;
                            else if (span[si][sj] == 1 && key[p][q] == 1) conflict = true;   //  돌기가 만나는 경우
                        }
                    }
                    if (!conflict && furrow == matches) return true;
                }
            }
            return false;
        }
    }
}