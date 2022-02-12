import 더맵게.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[1, 2, 3, 9, 10, 12]	7	2
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        System.out.printf("Mixed: %d", solution.solution(scoville, K));
    }
}
