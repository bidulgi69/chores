import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxMinLotto {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l1 = {44, 1, 0, 0, 31, 25};
        int[] w1 = {31, 10, 45, 1, 6, 19};
        int[] r1 = solution.solution(l1, w1);
        System.out.printf("Result 1 ::: %d, %d\n", r1[0], r1[1]);   //  [3, 5]

        int[] l2 = {0, 0, 0, 0, 0, 0};
        int[] w2 = {38, 19, 20, 40, 15, 25};
        int[] r2 = solution.solution(l2, w2);
        System.out.printf("Result 2 ::: %d, %d\n", r2[0], r2[1]);   //  [1, 6]

        int[] l3 = {45, 4, 35, 20, 3, 9};
        int[] w3 = {20, 9, 3, 45, 4, 35};
        int[] r3 = solution.solution(l3, w3);
        System.out.printf("Result 3 ::: %d, %d\n", r3[0], r3[1]);   //  [1, 1]
    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            Set<Integer> balls = new HashSet<>();
            Arrays.stream(win_nums)
                    .forEach(balls::add);

            int matched = 0;
            int zeros = 0;
            for (int lotto : lottos) {
                if (lotto == 0) zeros++;
                else if (balls.contains(lotto)) matched++;
            }

            answer[0] = Math.min(7-(matched+zeros), 6);     //  최대 등수
            answer[1] = Math.min(7-matched, 6);                            //  최소 등수

            return answer;
        }
    }
}

