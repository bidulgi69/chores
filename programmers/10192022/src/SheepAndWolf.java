import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SheepAndWolf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] i1 = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] e1 = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution.solution(i1, e1));

        int[] i2 = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] e2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        System.out.println(solution.solution(i2, e2));
    }

    static class Solution {
        List<Integer>[] adj;
        int answer = 0;
        public int solution(int[] info, int[][] edges) {
            adj = new ArrayList[info.length];
            for (int i = 0; i < info.length; i++) adj[i] = new ArrayList<>();

            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
            }

            dfs(0, 0, 0, info, new LinkedList<>());
            return answer;
        }

        void dfs(int n, int sheep, int wolves, int[] info, List<Integer> paths) {
            sheep += info[n] == 0 ? 1 : 0;
            wolves += info[n] == 1 ? 1 : 0;

            answer = Math.max(answer, sheep);
            if (sheep > wolves) {
                paths.addAll(adj[n]);   //  하위 노드들로 이동할 수 있다.
                for (int i = 0; i < paths.size(); i++) {
                    //  copy
                    List<Integer> next = new LinkedList<>();
                    for (int j = 0; j < paths.size(); j++) {
                        if (i!=j) next.add(paths.get(j));
                    }

                    //  반대편 트리또한 이동할 수 있는 경로로 간주해서 탐색해줘야 한다.
                    dfs(paths.get(i), sheep, wolves, info, next);
                }
            }
        }
    }
}
