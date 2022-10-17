import java.util.LinkedList;
import java.util.Queue;

public class GameMapFastestPath {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] map1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution.solution(map1));
        int[][] map2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution.solution(map2));
    }

    static class Solution {
        private final int[] dx = {1, -1, 0, 0};
        private final int[] dy = {0, 0, 1, -1};

        public int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            //  bfs
            Queue<int[]> queue = new LinkedList<>();
            //  [i, j, distance]
            queue.offer(new int[]{0, 0, 1});
            int i, j, d, k, di, dj;
            while (!queue.isEmpty()) {
                int[] cursor = queue.poll();
                i = cursor[0];
                j = cursor[1];
                d = cursor[2];

                if (i == n-1 && j == m-1) return d;

                for (k = 0; k < 4; k++) {
                    di = i+dx[k];
                    dj = j+dy[k];
                    if (di >= 0 && di < n && dj >= 0 && dj < m && maps[di][dj] == 1) {
                        maps[di][dj] = 0;
                        queue.offer(new int[]{di, dj, d+1});
                    }
                }
            }

            return -1;
        }
    }
}
