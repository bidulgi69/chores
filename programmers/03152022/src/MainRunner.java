public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
        int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};

        System.out.printf("Ans: %d\n", solution.solution(triangle));
    }
}
