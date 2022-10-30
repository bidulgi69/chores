import java.util.Stack;

public class StringCompression {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbaccc"));  //  7
        System.out.println(solution.solution("ababcdcdababcdcd"));  //  9
        System.out.println(solution.solution("abcabcdede"));    //  8
        System.out.println(solution.solution("abcabcabcabcdededededede"));  //  14
        System.out.println(solution.solution("xababcdcdababcdcd")); //  17
    }

    static class Solution {
        public int solution(String s) {
            int min = s.length();

            final int maxStep = s.length()/2;
            int step = 1;
            while (step <= maxStep) {
                Stack<String> stack = new Stack<>();
                Stack<String> iterate = new Stack<>();
                int i = 0, count = 0;
                String pattern;
                while (i < s.length()) {
                    pattern = s.substring(i, Math.min(i+step, s.length()));
                    if (iterate.isEmpty()) {
                        iterate.push(pattern);
                        count = 1;
                    } else {
                        if (pattern.equals(iterate.peek())) {
                            count++;
                        } else {
                            if (count > 1) stack.push(String.valueOf(count));
                            stack.push(iterate.pop());
                            iterate.push(pattern);
                            count = 1;
                        }
                    }
                    i += step;
                }
                while (!iterate.isEmpty()) {
                    if (count > 1) stack.push(String.valueOf(count));
                    stack.push(iterate.pop());
                }
//                System.out.printf("Step: %d\t\tstack: %s\t\titerate: %s\n", step, stack, iterate);

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                min = Math.min(min, sb.length());
                step++;
            }

            return min;
        }
    }
}
