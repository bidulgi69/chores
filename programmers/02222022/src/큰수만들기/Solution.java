package 큰수만들기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String number, int k) {
        int len = number.length() - k;
        Stack<Integer> stack = new Stack<>();
        int[] numbers = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        stack.push(numbers[0]);

        for (int num : Arrays.stream(numbers).skip(1).toArray()) {
            System.out.printf("Current : %d\n", num);

            try {
                while (k > 0 && stack.peek() < num) {
                    k--;
                    stack.pop();
                }
            } catch (EmptyStackException ignored) { }

            stack.push(num);
            System.out.printf("After operation: %s\n\n", stack.toString());
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""))
                .substring(0, len);
    }
}