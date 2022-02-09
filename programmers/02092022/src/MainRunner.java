import 디스크컨트롤러.*;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};    //  return 72
        //[[0, 5], [2, 10], [10000, 2]] = 60
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        System.out.println(solution.solution(jobs));
    }
}
