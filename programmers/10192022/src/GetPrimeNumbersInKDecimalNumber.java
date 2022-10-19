import java.util.Deque;
import java.util.LinkedList;

public class GetPrimeNumbersInKDecimalNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(110011, 10));
        System.out.println(solution.solution(437674, 3));
        System.out.println(solution.solution(17, 10));
        System.out.println(solution.solution(110110110, 10));
    }

    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            Deque<Integer> deque = new LinkedList<>();
            while (n > 0) {
                deque.offerFirst(n%k);
                n /= k;
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) sb.append(deque.poll());
            final String decimal = sb.toString();
            sb.setLength(0);    //  clear
            System.out.println(decimal);

            int zf = decimal.indexOf('0'), zl = decimal.lastIndexOf('0');
            if (zf != -1 && isPrime(Long.parseLong(decimal.substring(0, zf)))) answer++;      //  2번 조건
            if (zl != -1 && isPrime(Long.parseLong(decimal.substring(zl)))) answer++;         //  3번 조건
            if (zf == -1 && zl == -1 && isPrime(Long.parseLong(decimal))) answer++;           //  4번 조건
            if (zf != -1 && zl != -1) {                                                         //  1번 조건
                char c;
                int j = -1;
                for (int i = zf+1; i <= zl; i++) {
                    c = decimal.charAt(i);
                    if (c != '0') {
                        sb.append(c);
                        if (j == -1) j = i-1;   //  처음으로 0이 아닌 숫자가 나왔을 때, 이전 인덱스를 저장.
                    }
                    else {
                        if (sb.length() > 0
                                && decimal.charAt(j) == '0'
                                && isPrime(Long.parseLong(sb.toString()))) {
                            answer++;
                        }
                        //  초기화
                        j = -1;
                        sb.setLength(0);
                    }
                }
            }

            return answer;
        }

        private boolean isPrime(long n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return n > 1;
        }
    }
}
