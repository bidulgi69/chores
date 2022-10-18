import java.util.HashMap;
import java.util.Map;

public class KakaoPersonalityTypeTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] c1 = {5, 3, 2, 7, 5};
        System.out.println(solution.solution(s1, c1));

        String[] s2 = {"TR", "RT", "TR"};
        int[] c2 = {7, 1, 3};
        System.out.println(solution.solution(s2, c2));
    }

    /*
    1번 지표 	라이언형(R), 튜브형(T)
    2번 지표 	콘형(C), 프로도형(F)
    3번 지표 	제이지형(J), 무지형(M)
    4번 지표 	어피치형(A), 네오형(N)
    매우 비동의 	네오형 3점
    비동의 	네오형 2점
    약간 비동의 	네오형 1점
    모르겠음 	어떤 성격 유형도 점수를 얻지 않습니다
    약간 동의 	어피치형 1점
    동의 	어피치형 2점
    매우 동의 	어피치형 3점
     */
    static class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";

            final Map<Character, Integer> personalities = new HashMap<>();
            personalities.put('R', 0);
            personalities.put('T', 0);
            personalities.put('C', 0);
            personalities.put('F', 0);
            personalities.put('J', 0);
            personalities.put('M', 0);
            personalities.put('A', 0);
            personalities.put('N', 0);

            int choice;
            char personality;
            final int len = survey.length;
            for (int i = 0; i < len; i++) {
                choice = choices[i];
                if (choice < 4) {
                    personality = survey[i].charAt(0);
                    personalities.put(personality, personalities.get(personality)+4-choice);
                } else if (choice > 4) {
                    personality = survey[i].charAt(1);
                    personalities.put(personality, personalities.get(personality)+choice-4);
                }
            }

            //  1번 지표
            if (personalities.get('T') > personalities.get('R')) answer += 'T';
            else answer += 'R';
            //  2번 지표
            if (personalities.get('F') > personalities.get('C')) answer += 'F';
            else answer += 'C';
            //  3번 지표
            if (personalities.get('M') > personalities.get('J')) answer += 'M';
            else answer += 'J';
            //  4번 지표
            if (personalities.get('N') > personalities.get('A')) answer += 'N';
            else answer += 'A';

            return answer;
        }
    }
}
