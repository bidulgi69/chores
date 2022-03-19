import 가장먼노드.OtherSolution;
import 가장먼노드.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        OtherSolution other = new OtherSolution();
        //6	{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}	3
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.printf("Ans: %d\n", solution.solution(n, edge));
        System.out.printf("Ans: %d\n", other.solution(n, edge));
    }
}
