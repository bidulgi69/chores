package 도둑질;

import java.util.Arrays;

public class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];

        //  첫 번째 집을 터는 경우
        dp[0] = money[0];
        dp[1] = Math.max(dp[0], money[1]);
        //  첫 번째 집을 털지 않는 경우
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            //  마지막 집을 털지 않기 때문에 해당 epoch 에서 종료.
            if (i != money.length - 1) dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            answer = Math.max(answer, Math.max(dp[i], dp2[i]));
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));

        return answer;
    }
}
