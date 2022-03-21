import 방의개수.OtherSolution;
import 방의개수.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        OtherSolution otherSolution = new OtherSolution();
        //  {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}	3
        //  {6, 0, 3, 0, 5, 2, 6, 0, 3, 0, 5}   3
        //  {6, 5, 2, 7, 1, 4, 2, 4, 6}     3
        //  {5, 2, 7, 1, 6, 3}      3
        //  {6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0}    3
        int[] arrows = {6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0};

        System.out.printf("Ans: %d\n\n\n", solution.solution(arrows));
        System.out.printf("Ans: %d\n", otherSolution.solution(arrows));
    }
}
