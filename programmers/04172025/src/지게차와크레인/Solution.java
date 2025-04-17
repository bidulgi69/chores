package 지게차와크레인;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        int x = storage.length;
        int y = storage[0].length();
        char[][] warehouse = new char[x][y];
        boolean[][] faces = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                warehouse[i][j] = storage[i].charAt(j);
            }
        }

        // 맞대고 있는(접근 가능한) 컨테이너
        for (int i = 0; i < x; i++) {
            faces[i][0] = true;
            faces[i][y-1] = true;
        }
        for (int j = 0; j < y; j++) {
            faces[0][j] = true;
            faces[x-1][j] = true;
        }

        //requests[i]의 길이가 1이면 지게차를 이용한 출고 요청을, 2이면 크레인을 이용한 출고 요청을 의미합니다.
        for (String request : requests) {
            char type = request.charAt(0);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (type == warehouse[i][j] && (request.length() == 2 || faces[i][j])) {
                        warehouse[i][j] = 0;
                    }
                }
            }

            Queue<int[]> emptySpaceQueue = new LinkedList<>();
            boolean[][] visited = new boolean[x][y];
            boolean[][] _faces = new boolean[x][y];
            // 외벽부터 탐색
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (i == 0 || i == x-1 || j == 0 || j == y-1) {
                        if (warehouse[i][j] == 0) {
                            emptySpaceQueue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                        _faces[i][j] = true;
                    }
                }
            }

            // bfs(flood-fill)
            while (!emptySpaceQueue.isEmpty()) {
                int[] cursor = emptySpaceQueue.poll();
                for (int[] dir : dirs) {
                    int i = cursor[0]+dir[0];
                    int j = cursor[1]+dir[1];
                    if (i >= 0 && i < x && j >= 0 && j < y && !visited[i][j] && warehouse[i][j] == 0) {
                        visited[i][j] = true;
                        emptySpaceQueue.offer(new int[]{i, j});
                    }
                }
            }

            // 빈칸과 맞닿은 컨테이너를 새롭게 접근 가능하게 표시
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (warehouse[i][j] != 0) {
                        for (int[] dir : dirs) {
                            int ni = i+dir[0], nj = j+dir[1];
                            if (ni >= 0 && ni < x && nj >= 0 && nj < y && visited[ni][nj]) {
                                _faces[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
            faces = _faces;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (warehouse[i][j] != 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    //bfs
    private boolean isAccessible(char[][] warehouse, boolean[][] faces, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cursor = queue.poll();
            int i = cursor[0], j = cursor[1];
            for (int[] dir : dirs) {
                int _i = i+dir[0], _j = j+dir[1];
                if (_i >= 0 && _i < warehouse.length && _j >= 0 && _j < warehouse[0].length && warehouse[_i][_j] == 0) {
                    if (faces[_i][_j]) {
                        return true;
                    }
                    queue.offer(new int[]{_i, _j});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //["AZWQY", "CAABX", "BBDDA", "ACACA"]	["A", "BB", "A"]	11
        //["HAH", "HBH", "HHH", "HAH", "HBH"]	["C", "B", "B", "B", "B", "H"]	4

        String[] storage1 = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests1 = {"A", "BB", "A"};
        System.out.printf("Result 1 : %d (expected: %d)\n", solution.solution(storage1, requests1), 11);

        String[] storage2 = {"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] requests2 = {"C", "B", "B", "B", "B", "H"};
        System.out.printf("Result 2 : %d, (expected: %d)\n", solution.solution(storage2, requests2), 4);
    }
}
