import 네트워크.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //  3 {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}	2
        //  3 {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}} 1
        //  5 {{1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 1}, {1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}} 2
        //  3 {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}} 3

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.printf("Ans: %d\n", solution.solution(n, computers));
    }
}
