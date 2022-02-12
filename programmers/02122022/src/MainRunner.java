import HIndex.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[3, 0, 6, 1, 5]	3
        int[] array = {3,0,6,1,5};
        System.out.printf("After %d\n", solution.solution(array));
    }


}
