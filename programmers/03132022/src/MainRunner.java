import 징검다리.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int distance = 48;
        int[] rocks = new int[]{12,25,38,43};
        int n = 1;
        //16, {4,8,11}, 2 ==> 8
        //25, {2,14,11,21,17}, 2 ==> 4
        //48, {12,25,38,43}, 1 ==> 10

        System.out.printf("Ans: %d\n", solution.solution(distance, rocks, n));
    }
}
