package 조이스틱;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    //  ^ : next alphabet (+1, a -> z)
    //  v : prev alphabet (-1, z -> a)
    //  < : left offset
    //  > : next offset
    public int solution(String name) {
        int answer = 0;
        char[] chars = Stream
                .generate(() -> 'A')
                .limit(name.length())
                .map(x -> Character.toString(x))
                .collect(Collectors.joining())
                .toCharArray();
        boolean[] changed = new boolean[chars.length];

        int offset = 0;
        while (!String.valueOf(chars).equals(name)) {
            System.out.printf("Current: %d :::: %s\n", offset, String.valueOf(chars));
            if (!changed[offset]) {
                char alphabet = name.charAt(offset);
                answer += Math.min(
                        Math.abs(alphabet - 'A'),
                        1 + ('Z' - alphabet)
                );
                chars[offset] = name.charAt(offset);
                changed[offset] = true;
            }

            int prev = (offset - 1 + chars.length) % chars.length,
                    next = (offset + 1) % chars.length,
                    L = 0, R = 0;
            while (L < chars.length &&
                    (name.charAt(prev) == 'A' || changed[prev])) {
                prev = (prev - 1 + chars.length) % chars.length;
                L++;
            }
            while (R < chars.length &&
                    (name.charAt(next) == 'A' || changed[next])) {
                next = (next + 1) % chars.length;
                R++;
            }
            L %= chars.length;
            R %= chars.length;

            answer += Math.min(L, R);
            offset = L <= R ? prev : next;
        }

        return answer;
    }
}
