import 여행경로.Solution;

import java.util.Arrays;

public class MainRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "B"}, {"B", "A"}, {"A", "ICN"}};
        //{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}	{"ICN", "JFK", "HND", "IAD"}
        //{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}	{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}

        //{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}
        //{"ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"}

        //{{"ICN", "A"}, {"ICN", "A"}, {"A", "B"}, {"B", "A"}, {"A", "ICN"}}
        //{"ICN", "A", "B", "A", "ICN", "A"}

        //{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}}
        //["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]
        System.out.printf("Ans: %s\n",
                Arrays.toString(solution.solution(tickets)));
    }
}
