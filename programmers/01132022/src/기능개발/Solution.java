package 기능개발;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();

        int passed = 0, completed = 0;
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i],
                    speed = speeds[i];

            int fulfilled = (int) Math.ceil(
                    (100 - (progress + speed * passed)) / (float) speed);
//            System.out.printf("Fulfilled: %d\n", fulfilled);
            if (i == 0) {
                completed++;
                passed += fulfilled;
            } else {
                if (fulfilled > 0) {
                    answer.add(completed);
                    completed = 1;
                    passed += fulfilled;
                } else {
                    completed++;
                }
            }
        }
        if (completed != 0) answer.add(completed);
        return answer.stream().mapToInt(x -> x).toArray();
    }
}

/*
public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int i = 0, days = 0, cnt = 0;
        while (i < progresses.length) {
//            System.out.printf("Iter: %d,  %d && %d ==> %d\n", i, progresses[i], speeds[i], (progresses[i] + speeds[i] * days));
            int fulfilled = (int) Math.ceil(
                    (100 - (progresses[i] + speeds[i] * days)) / (float) speeds[i]);
            System.out.printf("Fulfilled: %d\n", fulfilled);

            if (fulfilled <= 0) {
                cnt++;
            } else if (cnt != 0) {
                answer.add(cnt);
                cnt = 0;
                days += fulfilled;
            } else {
                cnt++;
                days += fulfilled;
            }

            i++;
        }

        if (cnt != 0)
            answer.add(cnt);

        return answer.stream().mapToInt(x -> x).toArray();
    }
 */
