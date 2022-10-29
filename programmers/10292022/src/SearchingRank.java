import java.util.*;
import java.util.stream.Collectors;

public class SearchingRank {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] i1 = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] q1 = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.stream(solution.solution(i1, q1)).boxed().collect(Collectors.toList()));  //  [1,1,1,1,2,4]
    }

    static class Solution {
        private final Map<String, List<Integer>> hash = new HashMap<>();
        private String key;

        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];

            for (String s : info) {
                dfs(-1, new String[]{"-", "-", "-", "-"}, s.split(" "));
            }

            hash.forEach((key, value) -> Collections.sort(value));

            for (int i = 0; i < query.length; i++) {
                String[] qs = query[i].split(" and ");
                String[] sp = qs[3].split(" ");
                qs[3] = sp[0];
                int target = Integer.parseInt(sp[1]);
                key = Arrays.stream(new String[]{ qs[0], qs[1], qs[2], qs[3] }).collect(Collectors.joining());
                List<Integer> matches = hash.getOrDefault(key, new ArrayList<>());
                answer[i] = bs(matches, target);    //  binary search
            }

            hash.clear();
            return answer;
        }

        int bs(List<Integer> numbers, int target) {
            int lo = 0;
            int hi = numbers.size();
            int mid;
            while (hi - lo > 0) {
                mid = (hi+lo)/2;
                if (numbers.get(mid) >= target) {
                    hi = mid;
                } else {
                    lo = mid+1;
                }
            }
            //  찾은 위치보다 큰 인덱스에 있는 값들이 조건에 만족한다.
            return numbers.size()-lo;
        }

        void dfs(int here, String[] values, String[] info) {
            key = Arrays.stream(values).collect(Collectors.joining(""));
            List<Integer> candidates = hash.getOrDefault(key, new ArrayList<>());
            candidates.add(Integer.parseInt(info[4]));
            hash.put(key, candidates);

            for (int i = here+1; i < values.length; i++) {
                //  backtrack
                values[i] = info[i];
                dfs(i, values, info);
                values[i] = "-";
            }
        }
    }
}
