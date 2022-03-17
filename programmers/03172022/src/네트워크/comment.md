Number of Islands 문제와 동일하게 union-find 로 해결할 수 있는 문제였다.

bfs 를 활용해 현재 컴퓨터에 연결된 노드들 부터 탐색을 진행한다. 

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (computers[i][j] == 1) {
                int fp = find(union, union[i]);
                int tp = find(union, union[j]);
                if (fp != tp) {
                    if (fp > tp) union[fp] = union[tp];
                    else union[tp] = union[fp];
                }
            }
        }
    }

문제없는 알고리즘이라고 생각하고 제출을 했는데, 다수의 테스트 케이스에서 실패해서 문제를 찾아내야 했다.

다른 사람들의 풀이에 달린 답글들을 보다가, 'union-find 알고리즘의 결과물이 root 노드를 따라가지 않는다'라는 힌트를 얻었다.

    for (int i = 0; i < n; i++)
        union[i] = find(union, i);

따라서 bfs 알고리즘을 수행한 뒤, 한번 더 검사해주는 방식으로 변경하니 통과할 수 있었다.

union-find 알고리즘의 결과물이 root 노드를 따라가지 않을 수도 있다는 것을 기억해야 겠다.