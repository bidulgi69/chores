import java.util.*;

public class PillarAndBridge {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] bf1 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
//        int[][] bf1 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,2,0,1}};
        int[][] ret1 = solution.solution(5, bf1);
        for (int[] i : ret1) {
            System.out.printf("(%d, %d, %d)\n", i[0], i[1], i[2]);
        }
        System.out.println("\n");
        int[][] bf2 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] ret2 = solution.solution(5, bf2);   //  [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
        for (int[] i : ret2) {
            System.out.printf("(%d, %d, %d)\n", i[0], i[1], i[2]);
        }
        System.out.println("\n");
        int[][] bf3 = {{2, 0, 0, 1}, {100, 0, 0, 1}, {100, 1, 1, 1}, {99, 1, 1, 1}, {99, 1, 0, 1}, {99, 0, 0, 1}};
        int[][] ret3 = solution.solution(100, bf3);
        for (int[] i : ret3) {
            System.out.printf("(%d, %d, %d)\n", i[0], i[1], i[2]);
        }
    }

    static class Solution {
        private int[][][] map;
        //  기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
        //  보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
        //  유효하지 않은 build_frame 값은 무시됩니다.
        public int[][] solution(int n, int[][] build_frame) {
            List<int[]> answer = new ArrayList<>();
            //  initialize
            map = new int[n+1][n+1][2];
            //  x, y, a, b
            //  a (0: 기둥, 1: 보)
            //  b (0: 삭제, 1: 설치)
            int x, y, a, b;
            for (int[] bf : build_frame) {
                y = bf[0];
                x = bf[1];
                a = bf[2];
                b = bf[3];
                if (a == 0) {
                    if (b == 0) removePillar(x, y);
                    else if (buildPillar(x, y)) map[x][y][0] = 1;
                } else {    //  a == 1
                    if (b == 0) removeBridge(x, y);
                    else if (buildBridge(x, y)) map[x][y][1] = 1;
                }
//                print(bf, map);
            }

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (map[i][j][0] == 1) answer.add(new int[]{j, i, 0});
                    if (map[i][j][1] == 1) answer.add(new int[]{j, i, 1});
                }
            }

            answer.sort((i1, i2) -> {
                if (i1[0] != i2[0]) return Integer.compare(i1[0], i2[0]);
                if (i1[1] != i2[1]) return Integer.compare(i1[1], i2[1]);
                else return Integer.compare(i1[2], i2[2]);
            });
            return answer.toArray(new int[0][0]);
        }

        //  기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
        boolean buildPillar(int x, int y) {
            return x == 0 || map[x][y][1] == 1 || y-1 >= 0 && map[x][y-1][1] == 1 || map[x-1][y][0] == 1;
        }

        //  보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
        boolean buildBridge(int x, int y) {
            if (x == 0) return false;
            //  한쪽 끝 부분이 기둥 위에
            boolean onp = map[x-1][y][0] == 1 || (y+1 < map.length && map[x-1][y+1][0] == 1);
            //  양쪽 끝 부분이 다른 보와 동시에 연결
            boolean sandwich = y-1 >= 0 && map[x][y-1][1] == 1 && y+1 < map.length && map[x][y+1][1] == 1;
            return onp || sandwich;
        }

        //  삭제 이후 해당 셀(x, y) 의 유효성을 검증한다.
        boolean invalid(int x, int y) {
            boolean build;
            if (map[x][y][0] == 1) {
                map[x][y][0] = 0;
                build = buildPillar(x, y);
                map[x][y][0] = 1;
                if (!build) return true;
            }
            if (map[x][y][1] == 1) {
                map[x][y][1] = 0;
                build = buildBridge(x, y);
                map[x][y][1] = 1;
                if (!build) return true;
            }
            return false;
        }

        void removePillar(int x, int y) {
            map[x][y][0] = 0;
            //  기둥 삭제의 경우
            //  현재 위치, 위, 왼쪽 위를 확인하면 된다.
            if (invalid(x, y)
                    || (x+1 < map.length && invalid(x+1, y))
                    || (x+1 < map.length && y-1 >= 0 && invalid(x+1, y-1))) {
                map[x][y][0] = 1;
            }
        }

        void removeBridge(int x, int y) {
            map[x][y][1] = 0;
            //  보 삭제의 경우
            //  현재 위치, 좌, 우를 확인하면 된다.
            if (invalid(x, y)
                    || (y-1 >= 0 && invalid(x, y-1))
                    || (y+1 < map.length && invalid(x, y+1))) {
                map[x][y][1] = 1;
            }
        }
    }

    static void print(int[] bf, int[][][] map) {
        System.out.printf("(%d, %d)\t\tcommand: [%d, %d]\n", bf[1], bf[0], bf[2], bf[3]);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.printf("(%d, %d, [%d, %d])\t\t", i, j, map[i][j][0], map[i][j][1]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
