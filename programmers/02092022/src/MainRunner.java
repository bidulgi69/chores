import 이중우선순위큐.*;

import java.util.Arrays;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // ["I 16","D 1"]
        // ["I 7","I 5","I -5","D -1"]
        // ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
        // ["I 1", "I 2", "I 3", "I 4", "D -1", "D 1", "D -1"]
        String[] operations = {"I 1", "I 1", "I 1", "I 2", "D -1", "D 1", "D -1"};
        System.out.println(Arrays.toString(solution.solution(operations)));
        /**
         * 디스크 컨트롤러
            //[[0, 5], [2, 10], [10000, 2]] = 60
            int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
            System.out.println(solution.solution(jobs));
         */
    }
}
