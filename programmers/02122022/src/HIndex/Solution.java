package HIndex;

import java.util.Arrays;

public class Solution {

    public int solution(int[] citations) {
        int answer;
        Arrays.sort(citations);
        answer = citations[citations.length - 1];
        while (answer >= 0) {
            int emit = 0;
            System.out.printf("Ans: %d\n", answer);
            for (int i = citations.length - 1; i >= 0; i--) {
                int val = citations[i];
                if (val >= answer) emit++;
                else break;
            }
            if (emit >= answer) break;
            else answer--;
        }
        return answer;
    }
}
