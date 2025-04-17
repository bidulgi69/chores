package 비밀코드해독;

public class Solution {

    public int solution(int n, int[][] q, int[] ans) {
        int[] masks = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int mask = 0;
            for (int r : q[i]) {
                mask |= 1 << (r-1);
            }
            masks[i] = mask;
        }

        return dfs(1, n, 0, 0, masks, ans);
    }

    //dfs 로 경우의 수 생성
    private int dfs(int start, int n, int len,
                    int secret,
                    int[] masks, int[] answers
    ) {
        if (len == 5) {
            for (int i = 0; i < answers.length; i++) {
                if (Integer.bitCount(secret & masks[i]) != answers[i]) {
                    return 0;
                }
            }
            return 1;
        }

        int sum = 0;
        for (int i = start; i <= n; i++) {
            sum += dfs(i+1, n, len+1, secret | (1 << (i-1)), masks, answers);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //10	[[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [3, 7, 8, 9, 10], [2, 5, 7, 9, 10], [3, 4, 5, 6, 7]]	[2, 3, 4, 3, 3]	3
        //15	[[2, 3, 9, 12, 13], [1, 4, 6, 7, 9], [1, 2, 8, 10, 12], [6, 7, 11, 13, 15], [1, 4, 10, 11, 14]]	[2, 1, 3, 0, 1]	5
        int n1 = 10;
        int[][] q1 = {{1,2,3,4,5},{6,7,8,9,10},{3,7,8,9,10},{2,5,7,9,10},{3,4,5,6,7}};
        int[] ans1 = {2,3,4,3,3};
        System.out.printf("Result1: %d (expected: %d)\n", solution.solution(n1, q1, ans1), 3);

        int n2 = 15;
        int[][] q2 = {{2,3,9,12,13},{1,4,6,7,9},{1,2,8,10,12},{6,7,11,13,15},{1,4,10,11,14}};
        int[] ans2 = {2,1,3,0,1};
        System.out.printf("Result1: %d (expected: %d)\n", solution.solution(n2, q2, ans2), 5);
    }
}
