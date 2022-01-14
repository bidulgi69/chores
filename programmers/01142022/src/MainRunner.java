import 주식가격.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainRunner {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] prices = { 1, 2, 3, 2, 3 };
        List<Integer> result = Arrays.stream(solution.solution(prices)).boxed().collect(Collectors.toList());
        System.out.printf("Result : %s\n", result);
    }
}

/*
    다리를 지나는 트럭
    기다리는 트럭 Queue, 다리 위에 있는 트럭 Queue 를 만들어 구현하는 것이 좋아 보임.

    Solution solution = new Solution();
    int[] truckWeights1 = {7, 4, 5, 6};
    int[] truckWeights2 = {10};
    int[] truckWeights3 = Stream.generate(() -> 10).limit(10).mapToInt(Integer::intValue).toArray();
    int[] truckWeights4 = {15, 4, 5, 6, 8};

    System.out.printf("Total: %d\n", solution.solution(2, 10, truckWeights1));
 */