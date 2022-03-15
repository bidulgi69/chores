package 정수삼각형;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            int row = triangle[i].length;
            triangle[i][0] = triangle[i][0] + triangle[i - 1][0];
            triangle[i][row - 1] = triangle[i][row - 1] + triangle[i - 1][triangle[i - 1].length - 1];

            int l = 0, r = 1;
            for (int j = 1; j < triangle[i].length - 1; j++)
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i - 1][l++], triangle[i - 1][r++]);
            System.out.printf("acc: %s\n\n", Arrays.toString(triangle[i]));
        }

        return Arrays
                .stream(triangle[triangle.length - 1])
                .max()
                .orElse(0);
    }
}
