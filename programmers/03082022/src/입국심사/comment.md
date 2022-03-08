이진 탐색을 이용해 총 걸린 시간을 찾아내는 문제였다.

처음엔 다리를 지나는 트럭 문제처럼 풀기로 (Queue) 생각했다.

     Integer[] acc = Stream.generate(() -> 0)
            .limit(len)
            .toArray(Integer[]::new);

각 심사관이 사용한 시간을 누적시켜 저장하는 acc 배열을 이용해

    int min = Integer.MAX_VALUE, minIndex = -1;
    for (int i = 0; i < len; i++) {
        int after = acc[i] + times[i];
        if (min > after) {
            min = after;
            minIndex = i;
        }
    }

    acc[minIndex] = min;

가장 빠르게 통과할 수 있는 경우의 수를 찾아 구하는 방식이다. O(n)

이진 탐색의 경우 O(log n) 이 소요되므로, 위의 방식으로는 시간초과가 발생했다.

가장 빠르게 통과할 수 있는 경우를 이진 탐색으로 찾아야되나 고민했었는데, 매번 정렬을 수행해줘야 하므로 불가능하다고 생각했다. (PriorityQueue 를 활용해 해결할 수는 있다..)

다른 풀이를 찾아보니 총 걸린 시간을 미지수로 선언하고, 그 시간안에 처리할 수 있는 입국자의 수가 n 과 동일해질때까지 반복하는 해결법이 있었다.

처음엔 입국자의 시각에서 문제를 봐서 위의 풀이가 이해되지 않았다.

"입국자가 어떤 심사관에게 배정되는지를 생각하지 않고 단순히 해당 시간 안에 이만큼의 입국자를 처리할 수 있다." 라는 시각으로 변화를 줘야한다.
    
    Arrays.sort(times);
    long l = 0L, r = (long) times[times.length - 1] * n, mid;

이진 탐색의 오른쪽 끝을 가장 오래걸리는 시간 (가장 오래걸리는 심사관 * 입국자의 수)으로 설정해놓고, 탐색을 수행한다.

AnotherSolution.java 파일에 PriorityQueue 를 활용한 풀이를 추가했다.

내가 처음 생각해냈던 풀이와는 달리, 심사관들의 capacity 를 이용해 upper bound (r) 을 미리 계산하고, 

계산한 r 값을 이용해 처리할 수 있는 입국자들은 미리 처리를 해놓고 수행하는 방식이다.

다만 정렬이 수행되야하기 때문에 처리 시간은 이진 탐색을 사용한 풀이보다 오래 걸린다.

    AnotherSolution solution1 = new AnotherSolution();
    OtherSolution solution2 = new OtherSolution();

    long s1 = System.currentTimeMillis();
    solution1.solution(6, new int[]{ 7, 10 });
    s1 = System.currentTimeMillis() - s1;

    long s2 = System.currentTimeMillis();
    solution2.solution(6, new int[]{ 7, 10 });
    s2 = System.currentTimeMillis() - s2;

    System.out.printf("%d, %d\n", s1, s2);

    //  RUN
    106, 1