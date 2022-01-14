package 다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    /**
     * @param bridge_length 다리의 길이 (1 당 1 대의 트럭이 올라갈 수 있음)
     * @param weight 다리가 견딜 수 있는 최대 무게
     * @param truck_weights 트럭들의 무게
     * @return 모든 트럭이 다리를 건널때까지 걸린 시간
     * 한 트럭이 다리를 건너는 데 소요되는 시간은 bridge_length 초
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //  총 걸린 시간
        if (bridge_length == 1) return truck_weights.length;

        //  initialize bridge with zeros.
        final Queue<Integer> bridges = Stream
                .generate(() -> 0)
                .limit(bridge_length)
                .collect(Collectors.toCollection(LinkedList::new));
        int sumOfWeightsOnBridge = 0, truckIndex = 0, numOfBlanks = bridge_length;
        while (!bridges.isEmpty()) {
            //  remove a truck located at head of bridge.
            int arrived = bridges.poll();
            sumOfWeightsOnBridge -= arrived;
            if (arrived == 0) numOfBlanks--;

            if (truckIndex < truck_weights.length) {
                int truckWeight = truck_weights[truckIndex];
                if (sumOfWeightsOnBridge + truckWeight <= weight) {
                    sumOfWeightsOnBridge += truckWeight;
                    bridges.add(truckWeight);
                    truckIndex++;
                } else {
                    bridges.add(0);
                    numOfBlanks++;
                }
            } else {
                bridges.add(0);
                numOfBlanks++;
            }
            if (numOfBlanks == bridge_length) break;
            answer++;
        }
        return answer + 1;
    }
}
