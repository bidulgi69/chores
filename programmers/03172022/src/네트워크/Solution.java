package 네트워크;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int n, int[][] computers) {
        int[] union = IntStream
                .range(0, n)
                .toArray();

        //  bfs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    int fp = find(union, union[i]);
                    int tp = find(union, union[j]);
                    if (fp != tp) {
                        if (fp > tp) union[fp] = union[tp];
                        else union[tp] = union[fp];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(union));
        for (int i = 0; i < n; i++)
            union[i] = find(union, i);

        return Arrays.stream(union)
                .boxed()
                .collect(Collectors.toSet())
                .size();
    }

    int find(int[] union, int i) {
        if (union[i] == i) return i;
        return union[i] = find(union, union[i]);
    }
}
