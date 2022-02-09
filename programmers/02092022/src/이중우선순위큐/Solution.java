package 이중우선순위큐;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();

        for (String operation : operations) {
            String[] commands = operation.split(" ");
            System.out.printf("Current Operation: %s\tQueue: %s\n", operation, queue);
            int val = Integer.parseInt(commands[1]);
            switch (commands[0]) {
                case "I":
                    queue.offer(val);
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                    break;
                case "D":
                    if (!queue.isEmpty()) {
                        queue.remove(val > 0 ? max : min);
                        max = getMax(queue, Integer.MIN_VALUE);
                        min = getMin(queue, Integer.MAX_VALUE);
                    }
                    break;
                default:
                    break;
            }
            System.out.printf("After Operation: %d, %d, %s\n\n", max, min, queue);
        }
        answer[0] = getMax(queue, 0);
        answer[1] = getMin(queue, 0);
        return answer;
    }

    private int getMax(Queue<Integer> queue, int defaultValue) {
        return queue.stream().mapToInt(Integer::intValue).max().orElse(defaultValue);
    }

    private int getMin(Queue<Integer> queue, int defaultValue) {
        return queue.stream().mapToInt(Integer::intValue).min().orElse(defaultValue);
    }
}
