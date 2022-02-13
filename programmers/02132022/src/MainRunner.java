import 모의고사.Solution;

import java.util.Arrays;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[1,2,3,4,5]	[1]
        int[] answers = { 1,3,2,4,2 };

        System.out.printf("Ans : %s\n", Arrays.toString(solution.solution(answers)));
    }
}
