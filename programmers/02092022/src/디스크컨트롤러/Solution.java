package 디스크컨트롤러;

import java.util.*;

public class Solution {

    public int solution(int[][] jobs) {
        Comparator<Job> initTimeComparator = Comparator.comparing(job -> job.start);
        Comparator<Job> executionTimeComparator = Comparator.comparing(job -> job.execution);
        PriorityQueue<Job> waiting = new PriorityQueue<>(initTimeComparator);
        PriorityQueue<Job> executor = new PriorityQueue<>(executionTimeComparator);
        List<Job> done = new ArrayList<>();
        Disk disk = new Disk();
        for (int i = 0; i < jobs.length; i++) {
            waiting.offer(new Job(jobs[i]));
            disk.elapsed = Math.min(disk.elapsed, jobs[i][0]);
        }

        while (!waiting.isEmpty() || !executor.isEmpty()) {
            //  현재 시간보다 낮은 job 객체들을 !먼저 executor queue 에 넣어줘야 한다.
            System.out.printf("Current elapsed: %d\n", disk.elapsed);
            while (true) {
                Job wait = waiting.peek();
                if (wait != null && wait.start <= disk.elapsed) {
                    executor.offer(waiting.poll());
                } else break;
            }

            Job job = executor.peek();
            if (job == null) {
                job = waiting.peek();
                disk.elapsed = job.start;
                continue;
            } else {
                job = executor.poll();
                disk.elapsed += job.execution;
                job.end = disk.elapsed;
            }
            done.add(job);
        }
        return done.stream().mapToInt(job -> job.end - job.start).sum() / done.size();
    }
}

class Disk {
    int elapsed;

    public Disk() {
        this.elapsed = 1001;
    }
}

class Job {
    final int start;
    final int execution;
    int end;

    public Job(int[] job) {
        this.start = job[0];
        this.execution = job[1];
    }

    @Override
    public String toString() {
        return String.format("Start: %d, Execution: %d, End: %s\n", start, execution, end);
    }
}