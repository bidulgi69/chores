import 구명보트.Solution;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        [70, 50, 80, 50]	100	3
//        [70, 80, 50]	100	3

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.printf("Ans: %s\n", solution.solution(people, limit));
    }
}
