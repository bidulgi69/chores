주어진 값들에서 삽입, 삭제 연산을 수행하고 마지막에는 { 최대값, 최소값 } 을 반환해야 한다.

다른 사람들의 풀이를 보니 PriorityQueue 를 활용해 asc, desc 두 정렬 방식으로 나누고, 최대값, 최소값을 따로 관리해준다.

        queue.remove(val > 0 ? max : min);
        max = getMax(queue, Integer.MIN_VALUE);
        min = getMin(queue, Integer.MAX_VALUE);

Queue 클래스에 존재하는 remove 함수를 활용하면 굳이 정렬이 필요하지 않을 것 같아 위와 같이 작성했다.

Queue 두 개를 활용해 마지막에 peek() 로 가져오는 것보다는 공간이 절약되지만, 

풀이를 읽다보니 위와 같이 작성했을 때 통과하지 못하는 경우가 존재한다고 한다고들 한다.. 후에 한 번 알아봐야겠다.