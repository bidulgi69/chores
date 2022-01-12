import 프린터.Solution;

import java.util.*;

public class MainRunner {

    public static void main(String[] args) {
////[2, 1, 3, 2]	2	1
////[1, 1, 9, 1, 1, 1]	0	5
        int[] priorities1 = { 2, 1, 3, 2 };
        int location1 = 2;

        int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
        int location2 = 0;

        Solution solution = new Solution();
        System.out.printf("Result 1 : %d\n", solution.solution(priorities1, location1));
        System.out.printf("Result 2 : %d\n", solution.solution(priorities2, location2));

    }
}
