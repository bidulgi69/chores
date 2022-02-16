import 조이스틱.OtherSolution;
import 조이스틱.Solution;

public class MainRunner {
    public static void main(String[] args) {
        OtherSolution solution = new OtherSolution();
        System.out.println(solution.solution("JEROEN"));
        System.out.println(solution.solution("JAN"));
        System.out.println(solution.solution("ABAAAABB"));
        System.out.println(solution.solution("BBBBAAAAAAB"));
        System.out.println(solution.solution("BABBBAAAAAAB"));
    }
}
