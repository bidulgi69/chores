package 더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int times = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int score : scoville)
            queue.offer(score); //  sorted in ascending order.

        while (true) {
            Integer min = queue.poll();
            System.out.printf("Min: %d\n", min);
            if (min != null && min < K) {
                Integer next = queue.poll();
                if (next == null) return -1;
                else queue.offer(min + next * 2);
                times++;
            } else break;
        }

        return times;
    }
}