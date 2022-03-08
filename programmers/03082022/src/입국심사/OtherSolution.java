package 입국심사;

import java.util.Arrays;

public class OtherSolution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long l = 0L, r = (long) times[times.length - 1] * n, mid;

        while (r - l >= 0) {
            mid = (r + l) / 2;
            long passed = 0;
            for (int t : times) passed += mid / t;

            if (passed < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
