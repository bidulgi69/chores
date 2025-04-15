package 무인도여행;

import java.util.*;

public class Solution {

    //bfs
    public int[] solution(String[] maps) {
        int x = maps.length;
        int y = maps[0].length();

        int[][] map = new int[x][y];
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c == 'X' ? -1 : Integer.parseInt(c + "");
            }
        }

        List<Integer> answer = new ArrayList<>();
        solve(map, visited, answer);
        if (answer.isEmpty()) {
            answer.add(-1);
        }

        answer.sort(Integer::compareTo);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void solve(int[][] map, boolean[][] visited, List<Integer> answer) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j] && map[i][j] != -1) {
                    answer.add(bfs(map, visited, i, j));
                }
            }
        }
    }

    private int bfs(int[][] map, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        int foods = 0;
        visited[i][j] = true;

        int x, y;
        while (!queue.isEmpty()) {
            int[] cursor = queue.poll();
            x = cursor[0];
            y = cursor[1];
            foods += map[x][y];

            if (x-1 >= 0 && !visited[x-1][y] && map[x-1][y] != -1) {
                queue.offer(new int[]{x-1,y});
                visited[x-1][y] = true;
            }
            if (x+1 < map.length && !visited[x+1][y] && map[x+1][y] != -1) {
                queue.offer(new int[]{x+1,y});
                visited[x+1][y] = true;
            }
            if (y-1 >= 0 && !visited[x][y-1] && map[x][y-1] != -1) {
                queue.offer(new int[]{x,y-1});
                visited[x][y-1] = true;
            }
            if (y+1 < map[0].length && !visited[x][y+1] && map[x][y+1] != -1) {
                queue.offer(new int[]{x,y+1});
                visited[x][y+1] = true;
            }
        }

        return foods;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        //["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
        String[] maps1 = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.printf("Result1: %s\t(expected: [1, 1, 27])\n", Arrays.toString(solution.solution(maps1)));

        //["XXX","XXX","XXX"]	[-1]
        String[] maps2 = {"XXX","XXX","XXX"};
        System.out.printf("Result2: %s\t(expected: [-1])\n", Arrays.toString(solution.solution(maps2)));
    }
}
