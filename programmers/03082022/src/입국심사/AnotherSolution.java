package 입국심사;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AnotherSolution {
    public long solution(int n, int[] times) {
        double vel = 0;
        //  capacity
        for (int t : times) vel += 1D / t;
        //  upper bound (same with r)
        double bound = n / vel;

        // heap 에는 심사관이 저장 됩니다. 각 값은 각 심사관의 {한명 처리 시간, 여태까지 처리한 총 시간} 입니다.
        // 정렬 기준은 한명을 더 처리했을때의 총 시간 입니다.
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0] + a[1]));
        // 여기서 근접값을 이용해 답에 이미 근접한 상태로 heap 을 준비합니다.
        for (int t : times) {
            long cnt = (long) (bound / t);
            heap.offer(new long[]{t, cnt * t});
            n -= cnt;
        }

        // 여기서 남은 사람을 처리해 줍니다.
        long max = (long) bound;
        for (int i = 0; i < n; i++) {
            long[] a = heap.poll();
            a[1] += a[0];
            heap.offer(a);
            max = a[1];
        }

        return max;
    }
}