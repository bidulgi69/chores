import 섬연결하기.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //  4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
        //  7   {{0,6,12}, {0,3,28}, {0,1,67}, {0,4,17}, {1,3,24}, {1,4,62}, {2,4,20}, {2,5,37}, {3,6,13}, {4,5,45}, {4,6,73}}  123
        //  5   [[0,1,1],[0,2,2],[1,2,5],[2,3,8],[3,4,1]]
        final int n = 5;
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {2,3,8}, {3,4,1}};

        System.out.printf("Answer: %d\n", solution.solution(n, costs));
    }
}
