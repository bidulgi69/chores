package K번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            System.out.printf("Command: %s\n", Arrays.toString(command));
            int[] commandAppliedArray = Arrays
                    .stream(array)
                    .skip(command[0] - 1)
                    .limit(command[1] - command[0] + 1)
                    .sorted()
                    .toArray();
            answer[i] = commandAppliedArray[command[2] - 1];
        }

        return answer;
    }
}
