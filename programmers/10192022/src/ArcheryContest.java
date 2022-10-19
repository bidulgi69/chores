import java.util.Arrays;
import java.util.stream.Collectors;

public class ArcheryContest {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] i1 = {2,1,1,1,0,0,0,0,0,0,0};
//        System.out.println(Arrays.stream(solution.solution(5, i1)).boxed().collect(Collectors.toList()));

//        int[] i2 = {1,0,0,0,0,0,0,0,0,0,0};
//        System.out.println(Arrays.stream(new Solution().solution(1, i2)).boxed().collect(Collectors.toList()));

        int[] i3 = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(Arrays.stream(new Solution().solution(9, i3)).boxed().collect(Collectors.toList()));
    }

    static class Solution {
        private int diff = -1;
        private final int[] answer = new int[11];

        public int[] solution(int n, int[] info) {
            dfs(n, 0, info, new int[11]);
            return diff == -1 ? new int[]{-1} : answer;
        }

        //  완전 탐색
        void dfs(int n, int here, int[] apeaches, int[] lions) {
            if (n < 0) return;
            if (here == apeaches.length-1) {
                int apeach = 0, lion = 0;
                for (int i = 0; i < apeaches.length; i++) {
                    if (lions[i] > apeaches[i]) lion += 10-i;
                    else if (apeaches[i] > 0) apeach += 10-i;
                }

                if (lion > apeach) {
                    //  남은 화살은 0에 쏜다.
                    lions[10] = n;
                    //  가장 큰 점수 차이가 나는 경우 복사
                    if (diff < lion-apeach) {
                        diff = lion-apeach;
                        System.arraycopy(lions, 0, answer, 0, 11);
                    } else if (diff == lion-apeach) {   //  같은 점수차일 경우, 가장 낮은 점수를 더 많이 맞춘 case 를 선택.
                        boolean change = false;
                        for (int i = 10; i >= 0; i--) {
                            if (answer[i] < lions[i]) {
                                change = true;
                                break;
                            } else if (answer[i] > lions[i]) {
                                break;
                            }
                        }
                        if (change) {
                            diff = lion-apeach;
                            System.arraycopy(lions, 0, answer, 0, 11);
                        }
                    }
                }
            } else {
                lions[here] = apeaches[here] + 1;
                dfs(n - lions[here], here + 1, apeaches, lions);
                lions[here] = 0;    //  백트래킹
                dfs(n, here + 1, apeaches, lions);
            }
        }
    }
}
