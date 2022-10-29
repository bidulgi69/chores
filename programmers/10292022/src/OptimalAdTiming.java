import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OptimalAdTiming {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] l1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution.solution("02:03:55", "00:14:15", l1));  //  "01:30:59"

        String[] l2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        System.out.println(solution.solution("99:59:59", "25:00:00", l2));  //  "01:00:00"
    }

    static class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            final int pt = convert(play_time), adv = convert(adv_time);

            int[] times = new int[pt+1];
            for (String log : logs) {
                String[] s = log.split("-");
                times[convert(s[0])]++; 
                times[convert(s[1])]--;
            }

            //  누적합
            //  해당 시간(i)에 영상을 시청하고 있는 사용자의 수를 구한다.
            for (int i = 1; i <= pt; i++) {
                times[i] += times[i-1];
            }

            //  누적합
            //  위에서 계산한 배열에 i~i+adv 의 누적합을 구해 최대가 되는 i 를 구하면 된다.
            Queue<Integer> queue = new LinkedList<>();
            long sum = 0L, max;
            for (int i = 0; i < adv; i++) {
                sum += times[i];
                queue.offer(times[i]);
            }
            max = sum;
            int start = 0;
            for (int i = adv; i < pt; i++) {
                sum += times[i];
                queue.offer(times[i]);
                sum -= queue.poll();
                if (sum > max) {
                    max = sum;
                    //  i 가 종료시간 기준이기 때문에, 아래와 같이 계산해야 함.
                    start = i-adv+1;
                }
            }

            return String.format("%02d:%02d:%02d", start/3600, start%3600/60, (start%3600%60));
        }

        int convert(String hhmmss) {
            int[] s = Arrays.stream(hhmmss.split(":")).mapToInt(Integer::parseInt).toArray();
            return s[0]*3600 + s[1] * 60 + s[2];
        }
    }
}

/*
32.3점 풀이
if (play_time.equals(adv_time)) return "00:00:00";
PriorityQueue<Integer> pq = new PriorityQueue<>();

int[][] timelines = new int[logs.length][2];
for (int i = 0; i < logs.length; i++) {
    String[] s = logs[i].split("-");
    int[] timeline = new int[2];
    timeline[0] = convert(s[0]);
    timeline[1] = convert(s[1]);
    pq.offer(timeline[0]);

    timelines[i] = timeline;
}
final int pt = convert(play_time), adv = convert(adv_time);
int start, max = 0, answer = 0;
while (!pq.isEmpty() && pq.peek() + adv < pt) {
    start = pq.poll();
    int exposed = 0;
    //  start~start+adv
    for (int[] timeline : timelines) {
        if (timeline[0] > start+adv || timeline[1] < start) continue;
        exposed += Math.min(timeline[1], start+adv) - Math.max(timeline[0], start);
    }

    if (max < exposed) {
        max = exposed;
        answer = start;
    }
}

int hh = answer/3600;
answer%=3600;
int mm = answer/60;
answer%=60;

return (hh < 10 ? "0"+hh : hh) + ":" + (mm < 10 ? "0"+mm : mm) + ":" + (answer < 10 ? "0"+answer : answer);
 */