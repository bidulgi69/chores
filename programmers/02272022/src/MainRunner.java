import 단속카메라.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	2
        //  {{-2, -1}, {1, 2}, {-3, 0} } 2
        // {{0,2},{2,3},{3,4},{4,6}} 2
        //[[0, 0], [0, 0], [2, 2]] 2
        //[[0, 1], [0, 1], [2, 2]] 2
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        System.out.printf("Answer: %d\n", solution.solution(routes));
    }
}
