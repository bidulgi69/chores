package 입국심사;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public long solution(int n, int[] times) {
        final int len = times.length;
        Integer[] acc = Stream.generate(() -> 0)
                .limit(len)
                .toArray(Integer[]::new);
        while (n > 0) {
            System.out.printf("Before: %d, %s\n", n, Arrays.toString(acc));
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (int i = 0; i < len; i++) {
                int after = acc[i] + times[i];
                if (min > after) {
                    min = after;
                    minIndex = i;
                }
            }

            acc[minIndex] = min;
            n--;
            System.out.printf("After: %d, %s\n\n", n, Arrays.toString(acc));
        }

        return Arrays.stream(acc)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
