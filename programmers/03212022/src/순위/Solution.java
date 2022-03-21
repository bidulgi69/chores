package 순위;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[][] results) {
        //  directed graph
        int[][] graph = new int[n][n];

        //  한 선수의 순위를 결정짓기 위해서는
        //  다른 선수들과의 경기 결과를 모두 알고 있어야 함.
        //  즉, win + lose == n - 1 인 경우 해당 선수의 순위를 결정할 수 있음.
        Arrays.stream(results)
                        .forEach(result -> {
                            graph[result[0] - 1][result[1] - 1] = 1;    //  win
                            graph[result[1] - 1][result[0] - 1] = -1;    //  lose
                        });

        //  floyd-warshall
        for (int k = 0; k < n; k++) {   //  k = 거쳐가는 노드
            for (int i = 0; i < n; i++) {   //  i, j 그래프 위치
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        //  승패가 결정났는지 여부를 k 를 거쳐서 확인함.
                        //  알려진 i, j 의 승패 여부는 이미 값이 적용됐기 때문이다.
                        if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;  //  i > k && k > j === i > j
                        else if (graph[i][k] == -1 && graph[k][j] == -1) graph[i][j] = -1;  //  i < k && k < j === i < j
                    }
                }
            }
        }

        return (int) Arrays.stream(graph)
                .filter(battles ->  //  승패가 결정난 경기가 n - 1 일 경우 순위를 확정지을 수 있다.
                        Arrays.stream(battles)
                                .filter(x -> x != 0)
                                .count()
                        == n - 1
                )
                .count();
    }
}