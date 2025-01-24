public class PuzzleGameChallenge {

    public static void main(String[] args) {
        Solution solution = new Solution();

        //[1, 5, 3]	[2, 4, 7]	30	//3
        int[] diffs = {1,5,3};
        int[] times = {2,4,7};
        long limit = 30L;
        int ret = solution.solution(diffs, times, limit);
        System.out.println("Parameter 1: " + ret);
        //expected: 3

        //[1, 4, 4, 2]	[6, 3, 8, 2]	59	//2
        int[] diffs2 = {1,4,4,2};
        int[] times2 = {6,3,8,2};
        long limit2 = 59L;
        int ret2 = solution.solution(diffs2, times2, limit2);
        System.out.println("Parameter 2: " + ret2);
        //expected: 2

        //[1, 328, 467, 209, 54]	[2, 7, 1, 4, 3]	1723	//294
        int[] diffs3 = {1,328,467,209,54};
        int[] times3 = {2,7,1,4,3};
        long limit3 = 1723L;
        int ret3 = solution.solution(diffs3, times3, limit3);
        System.out.println("Parameter 3: " + ret3);

        //[1, 99999, 100000, 99995]	[9999, 9001, 9999, 9001]	3456789012	//39354
        int[] diffs4 = {1,99999,100000,99995};
        int[] times4 = {9999,9001,9999,9001};
        long limit4 = 3456789012L;
        int ret4 = solution.solution(diffs4, times4, limit4);
        System.out.println("Parameter 4: " + ret4);
        //expected: 39354

    }

}

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int right = 0;
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }
        
        int left = 1;
        int mid;
        while (left < right) {
            mid = left+(right - left)/2;
            long total = getTotal(diffs, times, mid);

            if (total <= limit) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private long getTotal(int[] diffs,
                          int[] times,
                          int level
    ) {
        long total = 0L;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            if (diff <= level) {
                total += times[i];
            } else {
                int gap = diff - level;
                int prev = i > 0 ? times[i-1] : 1;
                total += gap * (long)(prev + times[i]) + times[i];
            }
        }

        return total;
    }
}