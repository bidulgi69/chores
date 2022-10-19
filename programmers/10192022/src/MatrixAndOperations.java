import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MatrixAndOperations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rc1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[] op1 = {"Rotate", "ShiftRow"};

        print(solution.solution(rc1, op1));
        /*
        8 9 6
        4 1 2
        7 5 3
         */

        int[][] rc2 = {{8, 6, 3}, {3, 3, 7}, {8, 4, 9}};
        String[] op2 = {"Rotate", "ShiftRow", "ShiftRow"};
        print(solution.solution(rc2, op2));
        /*
        8 3 3
        4 9 7
        3 8 6
         */
        int[][] rc3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        String[] op3 = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
        print(solution.solution(rc3, op3));
        /*
        1  6  7   8
        5  9  10  4
        2  3  12  11
         */
    }

    static void print(int[][] res1) {
        for (int i = 0; i < res1.length; i++) {
            for (int j = 0; j < res1[i].length; j++) {
                System.out.print(res1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    static class Solution {
        public int[][] solution(int[][] rc, String[] operations) {
            int r = rc.length;
            int c = rc[0].length;
            int[][] answer = new int[r][c];

            Deque<Integer> left = new LinkedList<>();
            Deque<Integer> right = new LinkedList<>();
            Deque<Deque<Integer>> mid = new LinkedList<>();
            //  시계방향을 기준으로 처리
            for (int[] row : rc) {
                left.offer(row[0]);
                right.offerFirst(row[c-1]);
                Deque<Integer> deque = new LinkedList<>();
                for (int j = c-2; j >= 1; j--) {
                    deque.offer(row[j]);
                }
                mid.offer(deque);
            }

            for (String operation : operations) {
                if ("ShiftRow".equals(operation)) {
                    mid.offerFirst(mid.pollLast());
                    left.offerFirst(left.pollLast());
                    right.offer(right.poll());
                } else {    //  "Rotate"
                    mid.peek().offer(left.poll());
                    right.offer(mid.peek().poll());
                    mid.peekLast().offerFirst(right.poll());
                    left.offer(mid.peekLast().pollLast());
                }
            }

            for (int i = 0; i < r; i++) {
                answer[i][0] = left.poll();
                answer[i][c-1] = right.pollLast();

                Deque<Integer> m = mid.poll();
                for (int j = c-2; j >= 1; j--) {
                    answer[i][j] = m.poll();
                }
            }

            return answer;
        }
    }
}
