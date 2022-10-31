import java.util.LinkedList;
import java.util.Queue;

public class MovingOnBlock {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(solution.solution(board));   //  7
    }

    //  정확성에는 문제가 없지만 효율성(시간초과)에서 문제가 발생한 코드...
    static class Solution {
        public int solution(int[][] board) {
            int answer = -1;
            final int n = board.length;

            Queue<int[]> queue = new LinkedList<>();
            //  x1, y1, x2, y2, m
            //  x1 <= x2
            //  y1 <= y2
            queue.offer(new int[]{0, 0, 0, 1, 0});
            int[] cursor;
            boolean [][] visited = new boolean[n][n];
            visited[0][0] = true;
            visited[0][1] = true;
            while (!queue.isEmpty()) {
                cursor = queue.poll();
//                System.out.printf("Cursor(%d):::\t\tx1: (%d, %d)\t\tx2: (%d, %d)\n", cursor[4], cursor[0], cursor[1], cursor[2], cursor[3]);
                if (cursor[2] == n-1 && cursor[3] == n-1) {
                    answer = cursor[4];
                    break;
                }
                int m = cursor[4]+1;

                if (cursor[0] == cursor[2]) {   //  가로로 놓임
                    //  좌우 이동
                    if (cursor[1]-1 >= 0 && !visited[cursor[0]][cursor[1]-1] && board[cursor[0]][cursor[1]-1] == 0 && board[cursor[2]][cursor[3]-1] == 0) {
                        visited[cursor[0]][cursor[1]-1] = true;
                        queue.offer(new int[]{cursor[0], cursor[1]-1, cursor[2], cursor[3]-1, m});
                    }
                    if (cursor[3]+1 < n && !visited[cursor[2]][cursor[3]+1] && board[cursor[0]][cursor[1]+1] == 0 && board[cursor[2]][cursor[3]+1] == 0) {
                        visited[cursor[2]][cursor[3]+1] = true;
                        queue.offer(new int[]{cursor[0], cursor[1]+1, cursor[2], cursor[3]+1, m});
                    }
                    //  상하 이동
                    if (cursor[0]-1 >= 0 && !visited[cursor[0]-1][cursor[1]] && !visited[cursor[2]-1][cursor[3]] && board[cursor[0]-1][cursor[1]] == 0 && board[cursor[2]-1][cursor[3]] == 0) {
                        visited[cursor[0]-1][cursor[1]] = true;
                        visited[cursor[2]-1][cursor[3]] = true;
                        queue.offer(new int[]{cursor[0]-1, cursor[1], cursor[2]-1, cursor[3], m});
                    }
                    if (cursor[2]+1 < n && !visited[cursor[0]+1][cursor[1]] && !visited[cursor[2]+1][cursor[3]] && board[cursor[0]+1][cursor[1]] == 0 && board[cursor[2]+1][cursor[3]] == 0) {
                        visited[cursor[0]+1][cursor[1]] = true;
                        visited[cursor[2]+1][cursor[3]] = true;
                        queue.offer(new int[]{cursor[0]+1, cursor[1], cursor[2]+1, cursor[3], m});
                    }

                    //  x1 을 축으로 이동
                    if (cursor[0]-1 >= 0 && board[cursor[0]-1][cursor[1]] == 0 && board[cursor[2]-1][cursor[3]] == 0) {
                        visited[cursor[0]-1][cursor[1]] = true;
                        queue.offer(new int[]{cursor[0]-1, cursor[1], cursor[0], cursor[1], m});
                    }
                    if (cursor[0]+1 < n && board[cursor[0]+1][cursor[1]] == 0 && board[cursor[2]+1][cursor[3]] == 0) {
                        visited[cursor[0]+1][cursor[1]] = true;
                        queue.offer(new int[]{cursor[0], cursor[1], cursor[0]+1, cursor[1], m});
                    }
                    //  x2 를 축으로 이동
                    if (cursor[2]-1 >= 0 && board[cursor[2]-1][cursor[3]] == 0 && board[cursor[0]-1][cursor[1]] == 0) {
                        visited[cursor[2]-1][cursor[3]] = true;
                        queue.offer(new int[]{cursor[2]-1, cursor[3], cursor[2], cursor[3], m});
                    }
                    if (cursor[2]+1 < n && board[cursor[2]+1][cursor[3]] == 0 && board[cursor[0]+1][cursor[1]] == 0) {
                        visited[cursor[2]+1][cursor[3]] = true;
                        queue.offer(new int[]{cursor[2], cursor[3], cursor[2]+1, cursor[3], m});
                    }
                } else {    //  세로로 놓임
                    //  좌우 이동
                    if (cursor[1]-1 >= 0 && !visited[cursor[0]][cursor[1]-1] && !visited[cursor[2]][cursor[3]-1] && board[cursor[0]][cursor[1]-1] == 0 && board[cursor[2]][cursor[3]-1] == 0) {
                        visited[cursor[0]][cursor[1]-1] = true;
                        visited[cursor[2]][cursor[3]-1] = true;
                        queue.offer(new int[]{cursor[0], cursor[1]-1, cursor[2], cursor[3]-1, m});
                    }
                    if (cursor[3]+1 < n && !visited[cursor[2]][cursor[3]+1] && !visited[cursor[0]][cursor[1]+1] && board[cursor[0]][cursor[1]+1] == 0 && board[cursor[2]][cursor[3]+1] == 0) {
                        visited[cursor[0]][cursor[1]+1] = true;
                        visited[cursor[2]][cursor[3]+1] = true;
                        queue.offer(new int[]{cursor[0], cursor[1]+1, cursor[2], cursor[3]+1, m});
                    }
                    //  상하 이동
                    if (cursor[0]-1 >= 0 && !visited[cursor[0]-1][cursor[1]] && board[cursor[0]-1][cursor[1]] == 0 && board[cursor[2]-1][cursor[3]] == 0) {
                        visited[cursor[0]-1][cursor[1]] = true;
                        queue.offer(new int[]{cursor[0]-1, cursor[1], cursor[2]-1, cursor[3], m});
                    }
                    if (cursor[2]+1 < n && !visited[cursor[2]+1][cursor[3]] && board[cursor[0]+1][cursor[1]] == 0 && board[cursor[2]+1][cursor[3]] == 0) {
                        visited[cursor[2]+1][cursor[3]] = true;
                        queue.offer(new int[]{cursor[0]+1, cursor[1], cursor[2]+1, cursor[3], m});
                    }

                    //  x1 을 축으로 이동
                    if (cursor[1]-1 >= 0 && board[cursor[0]][cursor[1]-1] == 0 && board[cursor[2]][cursor[3]-1] == 0) {
                        visited[cursor[0]][cursor[1]-1] = true;
                        queue.offer(new int[]{cursor[0], cursor[1]-1, cursor[0], cursor[1], m});
                    }
                    if (cursor[1]+1 < n && board[cursor[0]][cursor[1]+1] == 0 && board[cursor[2]][cursor[3]+1] == 0) {
                        visited[cursor[0]][cursor[1]+1] = true;
                        queue.offer(new int[]{cursor[0], cursor[1], cursor[0], cursor[1]+1, m});
                    }
                    //  x2 를 축으로 이동
                    if (cursor[3]-1 >= 0 && board[cursor[2]][cursor[3]-1] == 0 && board[cursor[0]][cursor[1]-1] == 0) {
                        visited[cursor[2]][cursor[3]-1] = true;
                        queue.offer(new int[]{cursor[2], cursor[3]-1, cursor[2], cursor[3], m});
                    }
                    if (cursor[3]+1 < n && board[cursor[2]][cursor[3]+1] == 0 && board[cursor[0]][cursor[1]+1] == 0) {
                        visited[cursor[2]][cursor[3]+1] = true;
                        queue.offer(new int[]{cursor[2], cursor[3], cursor[2], cursor[3]+1, m});
                    }
                }
            }

            return answer;
        }
    }
}
