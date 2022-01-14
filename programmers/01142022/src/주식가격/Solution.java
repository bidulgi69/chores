package 주식가격;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--)
            stack.push(prices[i]);

        int index = 0;
        while (!stack.isEmpty()) {
            int price = stack.pop();
            for (int i = index + 1; i < prices.length; i++) {
                if (price <= prices[i]) answer[index]++;
                else {
                    answer[index]++;
                    break;
                }
            }
            index++;
        }
        return answer;
    }
}
