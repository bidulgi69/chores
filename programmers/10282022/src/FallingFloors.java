public class FallingFloors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board1 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] a1 = {1,0};
        int[] b1 = {1,2};
        System.out.println(solution.solution(board1, a1, b1));  //  5

        int[][] board2 = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[] a2 = {1,0};
        int[] b2 = {1,2};
        System.out.println(solution.solution(board2, a2, b2));  //  4

        int[][] board3 = {{1,1,1,1,1}};
        int[] a3 = {0,0};
        int[] b3 = {0,4};
        System.out.println(solution.solution(board3, a3, b3));  //  4

        int[][] board4 = {{1}};
        int[] a4 = {0,0};
        int[] b4 = {0,0};
        System.out.println(solution.solution(board4, a4, b4));  //  0

        int[][] board5 = {{1, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}};
        int[] a5 = {0, 0};
        int[] b5 = {3, 3};
        System.out.println(solution.solution(board5, a5, b5));  //  8
    }

    static class Solution {

        static class Result {
            boolean win;
            int moved;

            public Result(boolean win, int moved) {
                this.win = win;
                this.moved = moved;
            }

            @Override
            public String toString() {
                return String.format("Result: %s, %d\n", win, moved);
            }
        }
        private final int[] dx = {1, -1, 0, 0};
        private final int[] dy = {0, 0, 1, -1};
        int ni, nj;

        public int solution(int[][] board, int[] aloc, int[] bloc) {
            return solve(board, aloc[0], aloc[1], bloc[0], bloc[1], 0).moved;
        }

        Result solve(int[][] board, int x1, int y1, int x2, int y2, int moved) {
            if (board[x1][y1] == 0) return new Result(false, moved);
            

            boolean win = false;
            int min = 100000000, max = moved;

            for (int i = 0; i < 4; i++) {
                ni = x1 + dx[i];
                nj = y1 + dy[i];

                if (canMove(board, ni, nj)) {
                    board[x1][y1] = 0;
                    Result result = solve(board, x2, y2, ni, nj, moved + 1);
                    board[x1][y1] = 1;
                    win |= !result.win; //  한 번이라도 이긴 경우, 항상 이기는 쪽으로만 행동한다. (OR)
                    if (!result.win) {    //  상대가 이긴 경우
                        min = Math.min(min, result.moved);
                    } else {    //  내가 이긴 경우
                        max = Math.max(max, result.moved);
                    }
                }
            }
            //  이겼다면, 최소로 움직여야 하고
            //  졌다면 최대로 움직여야 함.
            return new Result(win, win ? min : max);
        }

        boolean canMove(int[][] board, int i, int j) {
            return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 1;
        }

        boolean chk(int[][] board, int i, int j) {
            for (int k = 0; k < 4; k++) {
                if (canMove(board, i+dx[k], j+dy[k])) return false;
            }
            return true;
        }
    }
}
