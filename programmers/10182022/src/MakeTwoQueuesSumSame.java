import java.util.LinkedList;
import java.util.Queue;

public class MakeTwoQueuesSumSame {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] q1a = {3, 2, 7, 2};
//        int[] q2a = {4, 6, 5, 1};
//        System.out.println(solution.solution(q1a, q2a));
//        int[] q1b = {1, 2, 1, 2};
//        int[] q2b = {1, 10, 1, 2};
//        System.out.println(solution.solution(q1b, q2b));
//        int[] q1c = {1, 1};
//        int[] q2c = {1, 5};
//        System.out.println(solution.solution(q1c, q2c));
        int[] q1d = {2, 2, 2};
        int[] q2d = {4, 4, 4};
        System.out.println(solution.solution(q1d, q2d));
        int[] q1e = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        int[] q2e = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(solution.solution(q1e, q2e));
        int[] q1f = {1, 1, 1, 1, 1};
        int[] q2f = {1, 1, 1, 9, 1};
        System.out.println(solution.solution(q1f, q2f));
    }

    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            long sum1 = 0L, sum2 = 0L;
            final Queue<Integer> q1 = new LinkedList<>();
            final Queue<Integer> q2 = new LinkedList<>();

            for (int v1 : queue1) {
                sum1 += v1;
                q1.offer(v1);
            }

            for (int v2 : queue2) {
                sum2 += v2;
                q2.offer(v2);
            }

            //  만들 수 있는 수인지 판별
            //  짝수인 경우에만 나눌 수 있다.
            long sum = sum1+sum2;
            if (sum % 2 != 0) return -1;

            int poll, ans = 0, it = 0, maxIt = queue1.length*3;
            while (sum1 != sum2 && it < maxIt) {
                if (q1.isEmpty() || q2.isEmpty()) return -1;

                if (sum1 > sum2) {
                    poll = q1.poll();
                    sum1 -= poll;
                    q2.offer(poll);
                    sum2 += poll;
                } else {
                    poll = q2.poll();
                    sum2 -= poll;
                    q1.offer(poll);
                    sum1 += poll;
                }
                ans++;
                it++;
            }

            return it == maxIt ? -1 : ans;
        }
    }
}
