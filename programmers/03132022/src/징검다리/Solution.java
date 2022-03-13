package 징검다리;

import java.util.Arrays;

public class Solution {
    /**
     * @param distance 출발점(0) - 도착점(distance) 사이의 거리
     * @param rocks 바위의 위치
     * @param n 제거할 바위의 개수
     * @return 거리의 최솟값 중 가장 큰 값
     */
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        //  이진 탐색이므로 최소 거리들 중 최대값을 x 로 선정
        int l = 0, r = distance, mid;
        while (r - l >= 0) {
            mid = (l + r) / 2;
            int passed = 0, position = 0;
            //  최소값보다 크거나 같은 바위들만 남겨놓으면서 이동함
            for (int rock : rocks) {
                if (rock - position < mid) passed++;   //  최소값보다 작을 경우, 해당 바위를 삭제함
                else position = rock;   //  최소값보다 크거나 같을 경우, 해당 바위로 부터의 거리를 계산해줘야함.
            }
            if (distance - position < mid) passed++;
            if (n < passed) {
                r = mid - 1;
            } else {
                l = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;
    }
}