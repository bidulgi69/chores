package 체육복;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        List<Integer> l = Arrays.stream(lost)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new)),
                r = Arrays.stream(reserve)
                        .boxed()
                        .sorted()
                        .collect(Collectors.toCollection(ArrayList::new));

        List<Integer> ls = Arrays.stream(lost)
                .filter(x -> !r.contains(x))
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        Queue<Integer> ll = Arrays.stream(reserve)
                .filter(x -> !l.contains(x))
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.printf("Filtered: %s\n", ll);
        for (int student : ls) {
            int prev = student - 1, next = student + 1;

            if (ll.contains(prev)) {
                ll.remove(prev);
            } else if (ll.contains(next)) {
                ll.remove(next);
            } else {
                answer--;
            }
        }

        return answer;
    }
}
