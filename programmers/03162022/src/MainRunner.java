import 도둑질.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //  {1,2,3,1}   4
        //  {91, 90, 5, 7, 5, 7}    104
        //  {90, 0, 0, 95, 1, 1}  185
        final int[] money = {90, 0, 0, 95, 1, 1};
        System.out.printf("Ans: %d\n", solution.solution(money));
    }
}
