package 다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int weight;
    int move;

    public Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }

    public void moving() {
        move++;
    }
}

class OtherSolution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        /*
         * 다리를 건너기 전의 트럭들을 queue 에 입력 (선입선출)
         */
        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        //  현재 다리 위에 올라와 있는 트럭들의 무게 합
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            //  1 초가 지났음을 의미
            answer++;

            /*
             * 현재 다리 위에 트럭이 없을 경우,
             * Wait queue 에서 제거함.
             * 이후 다음 트럭이 다리에 올라올 수 있는지 확인 (continue)
             */
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            //  다리 위에 있는 트럭들을 모두 1 씩 이동시킴.
            for (Truck t : moveQ) {
                t.moving();
            }

            /*
             * 다리 끝에 도착한 경우
             * Move queue 에서 제거함.
             */
            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            /*
             * 현재 다리 위에 또 다른 트럭이 이동할 수 있을 경우,
             * Move queue 에 다음 트럭 추가.
             */
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
