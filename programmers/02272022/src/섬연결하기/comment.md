kruskal 알고리즘과 union-find 알고리즘을 사용해서 풀 수 있는 문제였다.

https://m.blog.naver.com/ndb796/221230994142, https://m.blog.naver.com/ndb796/221230967614 글을 참고해 풀 수 있었다.

- Kruskal 알고리즘

    kruskal 알고리즘은 그래프 내에서 최소가 되는 가중치의 합을 구할 때 사용된다. 

    먼저 edge 들을 weight 값의 오름차순으로 정렬한 뒤, 작은 값을 갖는 edge 를 추가하면서 MST 를 찾는다.

    MST 이기 때문에 edge 추가 시 cycle 이 생성되는지를 계속 확인해줘야 하는데, 이를 위해 union-find 알고리즘을 사용한다.

<img src="https://user-images.githubusercontent.com/17774927/155876047-2997ff3e-c5d5-4e11-989b-0d3c794ddbdb.png">


- Union-find 알고리즘

    각 정점들을 기준으로 어떤 그룹에 속하는지를 저장하는 방법이다.

    두 정점 중 더 낮은 인덱스를 갖는 쪽으로 합쳐주면서, 재귀함수를 이용해 한 그룹으로 뭉쳐준다.

    이 때 i, j 인덱스에 위치한 값이 갖다면 cycle 이 생성된 것으로 간주할 수 있다.

<img src="https://user-images.githubusercontent.com/17774927/155876187-d9e792a8-532a-47a5-a92e-8a1f23fef935.png">