package N으로표현;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public int solution(int N, int number) {
        List<List<Integer>> dp = new ArrayList<>(9);
        dp.add(Collections.emptyList());    //  dp[0]
        //  N 을 붙여서(concatenate) 만들어 낼 수 있는 수를 미리 만들어준다.
        for (int i = 1; i <= 8; i++) {
            int concatenated = Integer.parseInt(
                    Stream.generate(() -> String.valueOf(N))
                            .limit(i)
                            .collect(Collectors.joining()));
            if (concatenated == number) return i;
            dp.add(Collections.singletonList(concatenated));
        }

        int i = 1;
        while (i <= 8) {
            for (int j = 1; j < i; j++) {
                int paren = i - j;
                List<Integer> prev = dp.get(j);
                List<Integer> next = dp.get(paren);

                System.out.printf("I: %d\tpair: %d, %d\n", i, j, paren);
                System.out.printf("Prev: %s\tNext: %s\n", prev, next);
                HashSet<Integer> cases = new HashSet<>();
                for (Integer p : prev) {
                    for (Integer q : next) {
                        cases.add(p + q);
                        cases.add(p - q);
                        cases.add(p * q);
                        if (q != 0) cases.add(p / q);
                    }
                }
                if (cases.contains(number)) return i;
                else dp.get(i).addAll(cases);
            }
            i++;
        }
        return -1;
    }
}
