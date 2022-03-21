그래프 내에서 사방이 막힌 도형이 생성되는 개수를 판별해내는 문제다.

처음에 문제 접근 방식은 그래프 내에서 cycle 을 찾아내면 될 것이라고 생각해 SCC 알고리즘을 떠올렸다.

주어진 문제에서 arrow 값을 활용해 억지로 directed graph 형태로 저장해보려고 했는데, 한 정점을 여러번 지나치는 경우에서 처리가 불가능해져서 다른 방법을 찾아야 했다.

먼저 도형이 생성되기 위해서는 한번 방문했었던 정점을 다시 방문해야하는 조건이 있고, 간선또한 이미 방문했었는지를 체크해줘야 한다.

    while (!vertexes.isEmpty()) {
        Vertex next = vertexes.poll();
        if (visited.containsKey(next)) {
            if (!routes.get(next).contains(prev)) {
                answer++;
            }
        } else {
            visited.put(next, true);
        }

        addRoute(routes, prev, next);
        addRoute(routes, next, prev);
        prev = next;
    }

먼저 정점을 방문했었는지를 검사한 뒤, 지나치지 않았던 간선이라면 도형이 생성된 것으로 간주할 수 있다.

이후 next 방문과 prev->next, next->prev 의 간선 정보까지 체크해준다.

이 문제에서 가장 중요한 것은 점을 지나치지 않으면서 만들어지는 도형이다.

<img src="https://user-images.githubusercontent.com/17774927/159260369-be6383ad-7e5b-438c-bfd2-8656ae8c25d5.png">

다음과 같이 모래시계 형태로 도형이 두개 만들어졌다고 했을 때, 위의 코드로는 도형이 1개 만들어졌다고 판단해버릴 수 있다.

이를 위해서 이동할 때 두 번씩 이동시키면 대각선이 만나는 정점이 생기고, 이 정점을 지나치므로 도형이 2개 만들어진 것을 판별할 수 있다. 

<img src="https://user-images.githubusercontent.com/17774927/159261527-e0902171-33f3-4714-9c48-a969a0b8b7a8.png">

이것을 잘 고려해야지 풀 수 있는 문제였다.

이후에 다른 풀이 중에 재밌는 것이 있어서 추가했는데 (OtherSolution.java), 오일러 공식을 이용한 방법이다.

2차원 평면에서 적용할 수 있는 오일러 공식은 다음과 같다.

    v-e+f=1

따라서 arrow 방향으로 움직이면서 정점과 간선의 중복체크를 해주면서 개수를 저장하기만 하면 굉장히 쉽게 풀 수 있었다.

수학은 위대하다..