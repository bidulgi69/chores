최소가 되는 거리값들 중 최대가 되는 값을 미지수로 놓고 이진 탐색을 통해 찾아내는 문제이다.

최대가 되는 거리를 x 라고 했을 때, x 는 [0, distance] 에 포함되므로 이진 탐색을 사용할 수 있다.

0 (기준점) 으로 부터 rocks, distance 값을 x 와 비교하면서 

    if (rock - position < mid) passed++;   //  최소값보다 작을 경우, 해당 바위를 삭제함
    else position = rock;   //  최소값보다 크거나 같을 경우, 해당 바위로 부터의 거리를 계산해줘야함.

x 가 현재 이진 탐색(while loop)에서 최소값이 되야하므로, 작을 경우 해당 바위를 삭제한다.

크거나 같을 경우 해당 바위를 사용할 수 있다는것 이므로 현재 위치를 해당 바위로 이동시킨다.

    if (distance - position < mid) passed++;

반복문(for)이 종료된 후, distance 와의 거리도 계산해줘야 한다.

    if (n < passed) {
        r = mid - 1;
    } else {
        l = mid + 1;
        answer = Math.max(answer, mid);
    }

만약 삭제된(passed) 돌의 개수가 주어진 개수(n)보다 더 많을 경우, 오른쪽 기준점을 이동시킨다.

그 외의 경우에는 왼쪽 기준점을 이동시키는데, 문제의 답이 최소값들 중 최대값을 구하는 것이므로 answer 의 갱신은 해당 조건문에서 수행해준다.