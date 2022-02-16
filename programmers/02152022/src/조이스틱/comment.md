조이스틱을 최소한으로 움직여 내 이름을 남기는 문제이다. (메탈슬러그 처럼)

처음에는 이전에 풀었던 문제들처럼 위치가 변할 때를 한 iteration 으로 잡아 알고리즘을 풀어내보려고 했다.

    while (!String.valueOf(chars).equals(name)) {

문제는 왼쪽으로 이동하냐, 오른쪽으로 이동하냐에서 어떤 방향이 최적의 해인지 판별하는 방법에서 발생했다.

    int prev = (offset - 1 + chars.length) % chars.length,
                    next = (offset + 1) % chars.length,
                    L = 0, R = 0;
    while (L < chars.length &&
            (name.charAt(prev) == 'A' || changed[prev])) {
        prev = (prev - 1 + chars.length) % chars.length;
        L++;
    }
    while (R < chars.length &&
            (name.charAt(next) == 'A' || changed[next])) {
        next = (next + 1) % chars.length;
        R++;
    }
    L %= chars.length;
    R %= chars.length;

    answer += Math.min(L, R);
    offset = L <= R ? prev : next;
다음 작업을 수행해야 하는 offset 을 찾고 진행해야 된다고 생각해 위와 같은 코드를 작성했다. 

    offset = L <= R

이 코드 부분에서 어떤 문제에서는 L < R 이 되야하는 것들이 있어 다른 방법을 찾아야 했다.

현재는 시간이 너무 오래걸려 다른 사람의 풀이를 보고 이해한 뒤, 주석을 달아 작성해 놨다.

후에 시간을 내서 내가 작성했던 코드를 완전 탐색 알고리즘으로 수정하면 문제 없이 통과할 수 있을 것이라 생각해본다.