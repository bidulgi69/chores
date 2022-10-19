import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingFee {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] f1 = {180, 5000, 10, 600};
        String[] r1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.stream(solution.solution(f1, r1)).boxed().collect(Collectors.toList()));

        int[] f2 = {120, 0, 60, 591};
        String[] r2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(Arrays.stream(solution.solution(f2, r2)).boxed().collect(Collectors.toList()));

        int[] f3 = {1, 461, 1, 10};
        String[] r3 = {"00:00 1234 IN"};
        System.out.println(Arrays.stream(solution.solution(f3, r3)).boxed().collect(Collectors.toList()));

        int[] f4 = {1, 10, 1, 11};
        String[] r4 = {"00:00 1234 IN", "00:02 1234 OUT"};
        System.out.println(Arrays.stream(solution.solution(f4, r4)).boxed().collect(Collectors.toList()));
    }


    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int time = fees[0], base = fees[1], charge = fees[3];
            float unit = (float) fees[2];
            Map<String, Integer> acc = new HashMap<>();    //  누적 시간
            Map<String, Integer> enter = new HashMap<>();   //  입장 시간

            int minutes, diff;
            for (String record : records) {
                String[] s = record.split(" ");
                String[] t = s[0].split(":");

                minutes = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                if ("IN".equals(s[2])) {
                    enter.put(s[1], minutes);
                } else {    //  out
                    diff = minutes - enter.get(s[1]);
                    acc.put(s[1], acc.getOrDefault(s[1], 0) + diff);
                    enter.remove(s[1]);
                }
            }

            int end = 23 * 60 + 59;
            for (String number : enter.keySet()) {
                diff = end - enter.get(number);
                acc.put(number, acc.getOrDefault(number, 0) + diff);
            }

            int[] answer = new int[acc.size()];
            String[] keys = acc.keySet().toArray(new String[]{});
            Arrays.sort(keys);

            for (int i = 0; i < keys.length; i++) {
                int spend = acc.get(keys[i]);
                if (spend <= time) answer[i] = base;
                else answer[i] = base + (int) Math.ceil((spend-time)/unit)*charge;
            }
            return answer;
        }
    }
}
