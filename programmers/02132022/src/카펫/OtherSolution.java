package 카펫;

public class OtherSolution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= 5000; i++) {
            for (int j = 1; j <= i; j++) {
                int outline = i * 2 + j * 2 - 4;
                if (outline == brown && i * j - brown == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}
