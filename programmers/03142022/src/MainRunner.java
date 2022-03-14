import N으로표현.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        final int N = 5, number = 31168;

        //  5, 12   4
        //  2, 11   3
        //  5, 31168    -1

        System.out.printf("Ans: %d\n", solution.solution(N, number));
    }
}
