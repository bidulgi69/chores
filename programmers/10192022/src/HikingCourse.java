import java.util.*;

public class HikingCourse {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        private int[] nodes;
        private List<int[]>[] edges;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = new int[2];
            nodes = new int[n+1];
            for (int gate : gates) nodes[gate] = 1; //  출입구
            for (int summit : summits) nodes[summit] = 2;   //  산봉우리
            Arrays.sort(summits);   //  더 작은 값의 산봉우리를 먼저 선택해야하기 때문에, 정렬을 수행한다.

            edges = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
            int u, v, w;
            for (int[] path : paths) {
                u = path[0];
                v = path[1];
                w = path[2];

                //  산봉우리로 부터 출입구로 도달하는 방법을 찾는다.
                //  출입구 또는 산봉우리일 경우 directed graph 형태로 저장
                if (nodes[u] == 1 || nodes[v] == 2) {
                    edges[v].add(new int[]{u, w});
                } else if (nodes[u] == 2 || nodes[v] == 1) {
                    edges[u].add(new int[]{v, w});
                } else {
                    edges[u].add(new int[]{v, w});
                    edges[v].add(new int[]{u, w});
                }
            }

            //  intensity 가 최소가 되도록 찾아야 함. -> binary search
            int lo = 0, hi = 10000000, mid;
            while (hi - lo >= 0) {
                mid = (lo+hi)/2;
                int[] res = solve(n, mid, summits);
                if (res[0] == 0) { //  경로 탐색에 실패
                    lo = mid+1;
                } else {
                    hi = mid-1;
                    answer[0] = res[1];
                    answer[1] = mid;
                }
            }
            return answer;
        }

        private int[] solve(int n, int intensity, int[] summits) {
            Queue<Integer> queue = new LinkedList<>();
            int cursor;
            for (int summit : summits) {
                boolean[] visited = new boolean[n+1];
                queue.offer(summit);
                visited[summit] = true;
                while (!queue.isEmpty()) {
                    cursor = queue.poll();
                    for (int[] edge : edges[cursor]) {
                        if (!visited[edge[0]] && edge[1] <= intensity) { //  최소 intensity 를 충족한다면 이동할 수 있음.
                            if (nodes[edge[0]] == 1) {  //  출입구에 도달했다면, 최소 intensity 로 산봉우리->출입구로 이동할 수 있다는 것과 동일.
                                return new int[]{1, summit};
                            }
                            queue.offer(edge[0]);
                            visited[edge[0]] = true;
                        }
                    }
                }
            }
            return new int[]{0};
        }
    }
}
