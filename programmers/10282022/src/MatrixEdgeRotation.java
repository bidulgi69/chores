import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MatrixEdgeRotation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] q1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] ret1 = solution.solution(6, 6, q1);
        System.out.println(Arrays.stream(ret1).boxed().collect(Collectors.toList()));   //  [8,10,25]

        int[][] q2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        int[] ret2 = solution.solution(3, 3, q2);
        System.out.println(Arrays.stream(ret2).boxed().collect(Collectors.toList()));   //  [1,1,5,3]

        int[][] q3 = {{1,1,100,97}};
        int[] ret3 = solution.solution(100, 97, q3);
        System.out.println(Arrays.stream(ret3).boxed().collect(Collectors.toList()));   //  [1]
    }

    static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                     matrix[i][j] = i*columns + j+1;
                }
            }

            int x1, y1, x2, y2;
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                x1 = query[0]-1;
                y1 = query[1]-1;
                x2 = query[2]-1;
                y2 = query[3]-1;

                answer[i] = rotate(matrix, x1, y1, x2, y2);
            }

            return answer;
        }

        int rotate(int[][] matrix, int x1, int y1, int x2, int y2) {
            int min = 1000000000;
            Deque<Integer> top = new LinkedList<>();
            Deque<Integer> bottom = new LinkedList<>();
            Deque<Integer> left = new LinkedList<>();
            Deque<Integer> right = new LinkedList<>();

            for (int i = x1; i <= x2; i++) {
                left.offer(matrix[i][y1]);
                right.offerFirst(matrix[i][y2]);

                min = Math.min(min, matrix[i][y1]);
                min = Math.min(min, matrix[i][y2]);
            }

            for (int i = y1+1; i < y2; i++) {
                top.offerFirst(matrix[x1][i]);
                bottom.offer(matrix[x2][i]);

                min = Math.min(min, matrix[x1][i]);
                min = Math.min(min, matrix[x2][i]);
            }

            //  rotate
            top.offer(left.poll());
            right.offer(top.poll());
            bottom.offer(right.poll());
            left.offer(bottom.poll());

            //  copy
            for (int i = x1; i <= x2; i++) {
                matrix[i][y1] = left.poll();
                matrix[i][y2] = right.pollLast();
            }

            for (int i = y1+1; i < y2; i++) {
                matrix[x1][i] = top.pollLast();
                matrix[x2][i] = bottom.poll();
            }

            return min;
        }
    }
}
