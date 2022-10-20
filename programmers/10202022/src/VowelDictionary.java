import java.util.HashMap;
import java.util.Map;

public class VowelDictionary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("AAAAE"));
        System.out.println(solution.solution("AAAE"));
        System.out.println(solution.solution("I"));
        System.out.println(solution.solution("EIO"));
    }

    static class Solution {
        static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        static Map<String, Integer> dict = new HashMap<>();
        static int n = 1;

        static {
            solve("");
        }

        public int solution(String word) {
            return dict.get(word);
        }

        static void solve(String s) {
            if (s.length() < 5) {
                for (char vowel : vowels) {
                    System.out.println(s+vowel);
                    dict.put(s+vowel, n++);
                    solve(s+vowel);
                }
            }
        }
    }
}
