import java.util.*;
import java.util.stream.Collectors;

public class PonketMonster {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3,1,2,3};
        System.out.println(solution.solution(nums1));

        int[] nums2 = {3,3,3,2,2,4};
        System.out.println(solution.solution(nums2));

        int[] nums3 = {3,3,3,2,2,2};
        System.out.println(solution.solution(nums3));
    }


    static class Solution {
        public int solution(int[] nums) {
            int kinds = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toSet())
                    .size();
            return Math.min(kinds, (int) Math.ceil(nums.length/2f));
        }
    }
}