package 타겟넘버;

import java.util.Arrays;

public class Solution {
    int sum;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target);
        return sum;
    }

    void dfs(int calc, int[] numbers, int target) {
        if (numbers.length == 0) {
            sum += calc == target ? 1 : 0;
        } else {
            int val = numbers[0];
            numbers = Arrays.stream(numbers)
                    .skip(1)
                    .toArray();
            dfs(calc + val, numbers, target);
            dfs(calc - val, numbers, target);
        }
    }
}
