import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PyramidToothbrushSale {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] e1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s1 = {"young", "john", "tod", "emily", "mary"};
        int[] a1 = {12, 4, 2, 5, 10};
        int[] ret1 = solution.solution(e1, r1, s1, a1);
        System.out.println(Arrays.stream(ret1).boxed().collect(Collectors.toList()));   //  [360, 958, 108, 0, 450, 18, 180, 1080]

        String[] e2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s2 = {"sam", "emily", "jaimie", "edward"};
        int[] a2 = {2, 3, 5, 4};
        int[] ret2 = solution.solution(e2, r2, s2, a2);
        System.out.println(Arrays.stream(ret2).boxed().collect(Collectors.toList()));   //  [0, 110, 378, 180, 270, 450, 0, 0]
    }

    static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            final int cost = 100;

            //  reference 저장
            Map<String, Node> refs = new HashMap<>();
            refs.put("-", new Node());

            String n, pn;
            for (int i = 0; i < enroll.length; i++) {
                n = enroll[i];
                pn = referral[i];

                Node me = new Node();
                Node parent = refs.getOrDefault(pn, new Node());
                me.parent = parent;
                refs.put(n, me);
                refs.putIfAbsent(pn, parent);
            }

            Node cursor, parent;
            int sell, take;
            for (int i = 0; i < seller.length; i++) {
                cursor = refs.get(seller[i]);
                sell = amount[i]*cost;

                parent = cursor.parent;
                while (parent != null) {
                    take = (int) Math.ceil(sell * 0.9);
                    sell -= take;
                    cursor.profit += take;

                    cursor = cursor.parent;
                    parent = cursor.parent;
                }
            }

            for (int i = 0; i < enroll.length; i++) {
                answer[i] = refs.get(enroll[i]).profit;
            }

            return answer;
        }

        class Node {
            Node parent = null;
            int profit;
        }
    }
}
