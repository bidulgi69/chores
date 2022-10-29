import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuRenewal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] o1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] c1 = {2, 3, 4};
        System.out.println(Arrays.stream(solution.solution(o1, c1)).collect(Collectors.toList()));  //  ["AC", "ACDE", "BCFG", "CDE"]

        String[] o2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] c2 = {2, 3, 5};
        System.out.println(Arrays.stream(solution.solution(o2, c2)).collect(Collectors.toList()));  //  ["ACD", "AD", "ADE", "CD", "XYZ"]

        String[] o3 = {"XYZ", "XWY", "WXA"};
        int[] c3 = {2, 3, 4};
        System.out.println(Arrays.stream(solution.solution(o3, c3)).collect(Collectors.toList()));  //  ["WX", "XY"]
    }

    static class Solution {
        private final Map<String, Integer> combo = new HashMap<>();
        private final Map<Integer, Integer> popularity = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();
            Set<Integer> c = new HashSet<>();
            for (int len : course) c.add(len);

            for (String order : orders) {
                for (int i = 0; i < order.length(); i++) {
                    dfs(i, "", order.toCharArray());
                }
            }
//            System.out.println(combo.entrySet());

            int max;
            for (int len : course) {
                max = popularity.getOrDefault(len, 0);
                if (max > 1) {
                    for (Map.Entry<String, Integer> entry : combo.entrySet()) {
                        if (entry.getKey().length() == len && entry.getValue() == max) answer.add(entry.getKey());
                    }
                }
            }

            Collections.sort(answer);
            combo.clear();
            popularity.clear();
            return answer.toArray(new String[0]);
        }

        void dfs(int here, String combi, char[] order) {
            combi += order[here];
            combi = Stream.of(combi.split(""))
                    .sorted()
                    .collect(Collectors.joining());

            if (combi.length() > 1) {
                combo.put(combi, combo.getOrDefault(combi, 0) + 1);
                popularity.put(
                        combi.length(),
                        Math.max(
                                combo.get(combi),
                                popularity.getOrDefault(combi.length(), 0)
                        )
                );
            }

            for (int i = here+1; i < order.length; i++) {
                dfs(i, combi, order);
            }
        }
    }
}
