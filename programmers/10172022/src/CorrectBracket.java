import java.util.*;

public class CorrectBracket {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "()()";
        System.out.println(solution.solution(s1));
        String s2 = "(())()";
        System.out.println(solution.solution(s2));
        String s3 = ")()(";
        System.out.println(solution.solution(s3));
        String s4 = "(()(";
        System.out.println(solution.solution(s4));
    }

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;
            final Stack<Character> stack = new Stack<>();

            try {
                for (char c : s.toCharArray()) {
                    if (c == '(') stack.push(c);
                    else stack.pop();
                }
            } catch (EmptyStackException e) {
                answer = false;
            }
            if (!stack.isEmpty()) answer = false;

            return answer;
        }
    }
}
