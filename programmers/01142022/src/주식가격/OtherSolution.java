package 주식가격;

import java.util.Stack;

class OtherSolution {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxes = new Stack<>();
        int i = 0;
        int[] terms = new int[prices.length];

        beginIdxes.push(i); //  처음부터 시작
        for (i=1; i<prices.length; i++) {
            /*
             * 배열의 다음 원소들을 확인하면서,
             * 주식 가격이 떨어진 경우 현재 위치에서 내가 위치한 beginIndex 만큼을 계산 (days) 후 삭제
             * 삭제 이후 이전 위치로 이동한 뒤 위 operation 을 반복 수행
             * 이후 다음 원소로 이동함. (주식 가격이 오르거나 유지된 경우는 operation 수행하지 않음)
             */
            while (!beginIdxes.empty() && prices[i] < prices[beginIdxes.peek()]) {
                int beginIdx = beginIdxes.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxes.push(i);
        }
        /*
         * Stack 에 남은 원소들은 주식 가격이 계속해서 상승한 경우임.
         * 따라서 length 값에서 원소가 위치했던 index 값의 차를 계산
         */
        while (!beginIdxes.empty()) {
            int beginIdx = beginIdxes.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}