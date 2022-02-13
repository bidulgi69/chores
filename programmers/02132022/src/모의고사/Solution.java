package 모의고사;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        final int[] pattern1 = { 1, 2, 3, 4, 5 };
        final int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        final int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int offset1 = 0, offset2 = 0, offset3 = 0;
        int score1 = 0, score2 = 0, score3 = 0;

        for (int ans : answers) {
            if (ans == pattern1[offset1]) score1++;
            if (ans == pattern2[offset2]) score2++;
            if (ans == pattern3[offset3]) score3++;

            offset1 = (offset1 + 1) % pattern1.length;
            offset2 = (offset2 + 1) % pattern2.length;
            offset3 = (offset3 + 1) % pattern3.length;
        }

        int[] answer = new int[3];
        int max = Math.max(Math.max(score1, score2), score3);
        answer[0] = score1 == max ? 1 : -1;
        answer[1] = score2 == max ? 2 : -1;
        answer[2] = score3 == max ? 3 : -1;
        return Arrays.stream(answer).filter(x -> x != -1).toArray();
    }
}
