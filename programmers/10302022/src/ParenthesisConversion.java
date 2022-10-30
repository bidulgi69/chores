import java.util.Stack;

public class ParenthesisConversion {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(()())()"));  //  (()())()
        System.out.println(solution.solution(")("));   //  ()
        System.out.println(solution.solution("()))((()")); //  ()(())()
    }

    static class Solution {
        public String solution(String p) {
            if (p.isEmpty() || isValid(p.toCharArray())) return p;
            String u, v;
            String[] dv = divide(p);
            u = dv[0];
            v = dv[1];

            if (isValid(u.toCharArray())) {
                return u + solution(v);
            } else {
                return "(" + solution(v) + ")" + reverse(u.substring(1, u.length()-1));
            }
        }


        public String[] divide(String p) {
            Stack<Character> stack = new Stack<>();
            String u, v;
            char c;
            int i, l = 0, r = 0;
            for (i = 0; i < p.length(); i++) {
                c = p.charAt(i);
                if ('(' == c) l++;
                else r++;

                if (stack.isEmpty()) stack.push(c);
                else {
                    if (stack.peek() != c) {
                        if (l == r) {   //  분리할 수 없는 균형잡힌 문자열 반환
                            u = p.substring(0, i+1);
                            v = p.substring(i+1);
                            stack.clear();
                            return new String[]{u, v};
                        } else {
                            stack.pop();
                        }
                    } else {
                        stack.push(c);
                    }
                }
            }
            stack.clear();
            return new String[]{p, ""};
        }

        public String reverse(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if ('(' == c) sb.append(')');
                else sb.append('(');
            }
            return sb.toString();
        }

        boolean isValid(char[] s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == stack.peek()) {
                        stack.push(c);
                    } else {
                        if (c == ')') stack.pop();
                        else return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
