public class MinimumSquare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] s1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution.solution(s1));
        int[][] s2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution.solution(s2));
        int[][] s3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution.solution(s3));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int w = -1, h = -1, l, r;
            for (int[] size : sizes) {
                if (size[0] >= size[1]) {
                    l = size[0];
                    r = size[1];
                } else {
                    l = size[1];
                    r = size[0];
                }

                if (w < l) w = l;
                if (h < r) h = r;
            }

            return w*h;
        }
    }
}
