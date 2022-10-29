public class RecommendID {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String id1 = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution.solution(id1)); //  bat.y.abcdefghi
        String id2 = "\"z-+.^.\"";
        System.out.println(solution.solution(id2)); //  z--
        String id3 = "=.=";
        System.out.println(solution.solution(id3)); //  aaa
        String id4 = "123_.def";
        System.out.println(solution.solution(id4)); //  123_.def
        String id5 = "abcdefghijklmn.p";
        System.out.println(solution.solution(id5)); //  abcdefghijklmn

    }

    static class Solution {
        public String solution(String new_id) {
            //  step 1
            String answer = new_id.toLowerCase();

            //  step 2
            answer = answer.replaceAll("[^\\da-z-_.]", "");

            //  step 3
            StringBuilder sb = new StringBuilder();
            boolean dot = false;
            for (char c : answer.toCharArray()) {
                if ('.' == c) {
                    if (!dot) {
                        sb.append(c);
                    }
                    dot = true;
                } else {
                    sb.append(c);
                    dot = false;
                }
            }
            answer = sb.toString();

            //  step 4
            if (!answer.isEmpty() && '.' == answer.charAt(0)) answer = answer.substring(1);
            if (!answer.isEmpty() && '.' == answer.charAt(Math.max(0, answer.length()-1))) answer = answer.substring(0, Math.max(0, answer.length() - 1));

            //  step 5
            if (answer.isEmpty()) answer = "a";

            //  step 6
            if (answer.length() > 15) {
                answer = answer.substring(0, 15);
                if (answer.charAt(14) == '.') answer = answer.substring(0, 14);
            }

            //  step 7
            while (answer.length() < 3) {
                answer = answer+answer.charAt(answer.length() - 1);
            }

            return answer;
        }
    }
}
