import java.util.*;
import java.util.stream.Collectors;

public class ReportResults {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id1 = {"muzi", "frodo", "apeach", "neo"};
        String[] rep1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.stream(solution.solution(id1, rep1, k)).boxed().collect(Collectors.toList()));
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, Set<String>> reported = new HashMap<>();    //  key: 신고 당한 유저
            Map<String, Set<String>> reporter = new HashMap<>();    //  key: 신고한 유저

            for (String r : report) {
                String[] content = r.split(" ");
                Set<String> reported_to_reporter = reported.getOrDefault(content[1], new HashSet<>());
                reported_to_reporter.add(content[0]);
                reported.put(content[1], reported_to_reporter);
                
                Set<String> reporter_to_reported = reporter.getOrDefault(content[0], new HashSet<>());
                reporter_to_reported.add(content[1]);
                reporter.put(content[0], reporter_to_reported);
            }

            int sum = 0;
            for (int i = 0; i < id_list.length; i++) {
                 Set<String> my_report = reporter.get(id_list[i]);
                 if (my_report != null) {
                     for (String id : my_report) {
                         sum += reported.getOrDefault(id, new HashSet<>()).size() >= k ? 1 : 0;
                     }
                 }
                 answer[i] = sum;
                 sum = 0;
            }
            return answer;
        }
    }
}
