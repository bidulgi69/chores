import K번째수.Solution;

import java.util.Arrays;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.printf("Mixed: %s", Arrays.toString(solution.solution(array, commands)));
    }
}
