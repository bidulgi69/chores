import 입국심사.AnotherSolution;
import 입국심사.OtherSolution;
import 입국심사.Solution;

public class MainRunner {
    public static void main(String[] args) {

        AnotherSolution solution1 = new AnotherSolution();
        OtherSolution solution2 = new OtherSolution();

        long s1 = System.currentTimeMillis();
        solution1.solution(6, new int[]{ 7, 10 });
        s1 = System.currentTimeMillis() - s1;

        long s2 = System.currentTimeMillis();
        solution2.solution(6, new int[]{ 7, 10 });
        s2 = System.currentTimeMillis() - s2;

        System.out.printf("%d, %d\n", s1, s2);
    }
}