package 카펫;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    private final HashSet<Rectangle> rectangles = new HashSet<>();
    /**
     * @param brown [8, 5000]
     * @param yellow [1, 2000000]
     * @return { width, height }
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        final StringBuilder sb = new StringBuilder();
        int cells = brown + yellow;
        for (int i = 2; i <= cells; i++) {
            while (cells % i == 0) {
                sb.append(i).append(' ');
                cells /= i;
            }
        }

        int[] factors = Arrays.stream(
                sb.toString().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dfs(1, factors);
        Rectangle optimize = rectangles
                .stream()
                .filter(rect -> rect.width >= rect.height)
                .filter(rect -> rect.isAdjustableForOutline(brown))
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);
        answer[0] = optimize.width;
        answer[1] = optimize.height;
        return answer;
    }

    private void dfs(int height, int[] factors) {
        int width = Arrays.stream(factors).reduce((f1, f2) -> f1 * f2).orElse(1);
        rectangles.add(new Rectangle(width, height));

        for (int i = 0; i < factors.length; i++) {
            int[] neighbors = new int[factors.length - 1];
            int offset = 0;
            for (int j = 0; j < factors.length; j++) {
                if (j != i) {
                    neighbors[offset++] = factors[j];
                }
            }
            dfs(height * factors[i], neighbors);
        }
    }
}

class Rectangle {
    final int width;
    final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isAdjustableForOutline(int brown) {
        return brown == width * 2 + height * 2 - 4;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Rectangle.class)
            return false;

        Rectangle other = (Rectangle) obj;
        return (this.width == other.width) && (this.height == other.height);
    }

    @Override
    public int hashCode() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle { width: %d, height: %d }\n", width, height);
    }
}
