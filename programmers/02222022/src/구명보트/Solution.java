package 구명보트;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        final int len = people.length;
        int answer = 0, p = 0, q = len - 1;

        Arrays.sort(people);
        while (p < q) {
            int weight = people[p] + people[q];

            if (weight <= limit) {
                p++;
                q--;
                answer++;
            } else {
                q--;
                answer++;
            }
        }

        return answer + (p == q ? 1 : 0);
    }
}
