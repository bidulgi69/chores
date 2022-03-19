package 가장먼노드;

import java.util.Arrays;

public class Solution {
    final int INF = 987654321;
    public int solution(int n, int[][] edge) {
        int[][] graph = new int[n][n];
        //  initialize graph
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        //  insert edges
        Arrays.stream(edge)
                .forEach(e -> {
                    graph[e[0] - 1][e[1] - 1] = 1;
                    graph[e[1] - 1][e[0] - 1] = 1;
                });

        int[] distances = new int[n];
        //  initialize distances
        for (int i = 0; i < n; i++)
            distances[i] = graph[0][i];

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int numVisited = 1;
        //  다익스트라 알고리즘 사용, 최단 경로를 계산
        //  항상 1번 노드에서 시작함.
        while (numVisited++ < n) {
            //  find nearest node
            int nearest = findNearestNode(distances, visited);
            //  renew distances
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    distances[i] = Math.min(distances[i], distances[nearest] + graph[nearest][i]);
                }
            }
            visited[nearest] = true;
        }

        //  최단 경로들 중 max 를 구함.
        int maxDistance = Arrays.stream(distances).max().orElse(0);
        return (int) Arrays.stream(distances)
                .filter(x -> x == maxDistance)
                .count();
    }

    int findNearestNode(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE, nearest = -1;
        for (int i = 0; i < distances.length; i++) {
            if (min > distances[i] && !visited[i]) {
                min = distances[i];
                nearest = i;
            }
        }
        return nearest;
    }
}