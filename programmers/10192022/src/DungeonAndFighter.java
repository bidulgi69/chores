import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DungeonAndFighter {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution.solution(80, dungeons));
    }

    static class Solution {
        int answer = 0;
        public int solution(int k, int[][] dungeons) {

            List<int[]> accessible = new LinkedList<>();
            for (int[] dungeon : dungeons) {
                if (dungeon[0] <= k) accessible.add(dungeon);
            }

            solve(k, 0, accessible);
            return answer;
        }

        void solve(int k, int clear, List<int[]> dungeons) {
            answer = Math.max(answer, clear);

            for (int i = 0; i < dungeons.size(); i++) {
                if (k >= dungeons.get(i)[0]) {
                    List<int[]> next = new LinkedList<>();
                    for (int j = 0; j < dungeons.size(); j++) {
                        if (i != j) next.add(dungeons.get(j));
                    }

                    solve(k-dungeons.get(i)[1], clear+1, next);
                }
            }
        }
    }
}
