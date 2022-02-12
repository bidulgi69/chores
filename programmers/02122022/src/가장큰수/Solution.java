package 가장큰수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int[] numbers) {
        final String[] strings = Arrays
                .stream(numbers)
                .boxed()
                .map(x -> x.toString())
                .toArray(String[]::new);

        Arrays.sort(strings, (o1, o2) -> o2.concat(o1).compareTo(o1.concat(o2)));
        return removeZeros(Arrays.stream(strings).collect(Collectors.joining("")));
    }

    private String removeZeros(String decimal) {
        boolean detected = false;
        while (!detected && decimal.length() > 1) {
            char d = decimal.charAt(0);
            if (d == '0') {
                decimal = decimal.substring(1);
            } else {
                detected = true;
            }
        }
        return decimal;
    }
}
