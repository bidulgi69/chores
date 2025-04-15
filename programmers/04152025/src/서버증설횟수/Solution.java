package 서버증설횟수;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> servers = new LinkedList<>();
        //어느 시간대의 이용자가 n x m명 이상 (n + 1) x m명 미만이라면 최소 n대의 증설된 서버가 운영 중이어야 합니다.
        for (int player : players) {
            Queue<Integer> activeServers = new LinkedList<>();
            while (!servers.isEmpty()) {
                int life = servers.poll();
                if (--life > 0) {
                    activeServers.offer(life);
                }
            }
            servers = new LinkedList<>(activeServers);

            int required = player / m;
            if (required > servers.size()) {
                for (int i = servers.size(); i < required; i++) {
                    servers.offer(k);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        /*
        [0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5]	3	5	7
[0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0]	5	1	11
[0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1]	1	1	12
         */

        int[] players1 = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        System.out.printf("Result 1: %d (expected: %d)\n", solution.solution(players1, m, k), 7);

        int[] players2 = {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
        int m2 = 5;
        int k2 = 1;
        System.out.printf("Result 2: %d (expected: %d)\n", solution.solution(players2, m2, k2), 11);

        int[] players3 = {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        int m3 = 1;
        int k3 = 1;
        System.out.printf("Result 1: %d (expected: %d)\n", solution.solution(players3, m3, k3), 12);
    }
}
