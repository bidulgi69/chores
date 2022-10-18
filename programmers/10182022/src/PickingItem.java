import java.util.LinkedList;
import java.util.Queue;

public class PickingItem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rect1 = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        System.out.println(solution.solution(rect1, 1, 3, 7, 8));   //  17

        int[][] rect2 = {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}};
        System.out.println(solution.solution(rect2, 9, 7, 6, 1));   //  11

        int[][] rect3 = {{1, 1, 5, 7}};
        System.out.println(solution.solution(rect3, 1, 1, 4, 7));   //  9

        int[][] rect4 = {{2,1,7,5},{6,4,10,10}};
        System.out.println(solution.solution(rect4, 3, 1, 7, 10));   //  15

        int[][] rect5 = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
        System.out.println(solution.solution(rect5, 1, 4, 6, 3));   //  10
    }

    static class Solution {
        private final int max = 101;
        private final int[] dx = {1, -1, 0, 0};
        private final int[] dy = {0, 0, 1, -1};

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            final int[][] map = new int[max][max];

            characterX *= 2;
            characterY *= 2;
            itemX *= 2;
            itemY *= 2;
            for (int[] rect : rectangle) {
                rect[0] *= 2;
                rect[1] *= 2;
                rect[2] *= 2;
                rect[3] *= 2;
            }

            int lx, ly, rx, ry;
            for (final int[] rect : rectangle) {
                lx = rect[0];
                ly = rect[1];
                rx = rect[2];
                ry = rect[3];

                for (int i = lx; i <= rx; i++) {
                    map[i][ly]= 1;
                    map[i][ry]= 1;
                }
                for (int i = ly; i <= ry; i++) {
                    map[lx][i]= 1;
                    map[rx][i]= 1;
                }
            }

            //  bfs
            Queue<int[]> queue = new LinkedList<>();
            int i, j, d = 0, k, di, dj;
            map[characterX][characterY] = 0;
            queue.offer(new int[]{characterX, characterY, d});
            while (!queue.isEmpty()) {
                int[] cursor = queue.poll();
                i = cursor[0];
                j = cursor[1];
                d = cursor[2];
//                System.out.printf("Cursor: (%d, %d)\t\tdistance: %d\n", i, j, d);

                if (i == itemX && j == itemY) break;

                for (k = 0; k < 4; k++) {
                    di = i+dx[k];
                    dj = j+dy[k];
                    if (di >= 0 && di < max && dj >= 0 && dj < max && //  map 내부에 존재하는 점인지 확인
                            map[di][dj] == 1 && isAvailableMove(rectangle, di, dj)) {    //  둘레로 이동하는지 확인
                        map[di][dj] = 0;
                        queue.offer(new int[]{di, dj, d + 1});
                    }
                }
            }

            return d/2;
        }

        private boolean isAvailableMove(int[][] rectangle, int di, int dj) {
            for (int[] rect : rectangle) {
                //  폭이 1일 경우 이동하려는 점이 모서리가 아닐 경우 가로질러 가게 된다.
                //  이를 체크해주기 위해서 각 직사각형을 2배 크기로 그리면 된다.
                if (di > rect[0] && di < rect[2] && dj > rect[1] && dj < rect[3]) return false;
            }
            return true;
        }
    }
}