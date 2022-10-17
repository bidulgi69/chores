import java.util.*;
import java.util.stream.Collectors;

public class NonDuplicatedNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1,1,3,3,0,1,1};
        System.out.println(Arrays.stream(solution.solution(arr1)).boxed().collect(Collectors.toList()));

        int[] arr2 = {4,4,4,3,3};
        System.out.println(Arrays.stream(solution.solution(arr2)).boxed().collect(Collectors.toList()));
    }

    static class Solution {
        public int[] solution(int[] arr) {
            final Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (stack.peek() != arr[i]) {
                    stack.push(arr[i]);
                }
            }

            return stack.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
