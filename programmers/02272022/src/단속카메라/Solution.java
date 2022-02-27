package 단속카메라;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int solution(int[][] routes) {
        //  Because the iteration starts with index 1,
        //  one camera that takes car [0] is required.
        int answer = 1;

        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        final int len = routes.length;
        int camera = routes[0][1];
        System.out.printf("Routes : %s\n", print2dArray(routes));
        for (int i = 1; i < len; i++) {
            if (routes[i][0] > camera || routes[i][1] < camera) {
                camera = routes[i][1];  //  renewal
                answer++;
            }
        }
        return answer;
    }

    public String print2dArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : array)
            sb.append(Arrays.toString(arr)).append("\n");
        return sb.toString();
    }
}
