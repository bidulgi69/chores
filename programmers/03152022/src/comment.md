삼각형 트리의 꼭대기로부터 내려오면서 가장 크게 누적된 path 값을 구하는 문제이다.

트리의 현재 위치 (i, j)에 대해서 (i-1, j-1), (i-1, j) 중 최대값을 고르며 누적시켜주면 된다.

    int l = 0, r = 1;
    for (int j = 1; j < triangle[i].length - 1; j++)
        triangle[i][j] = triangle[i][j] + Math.max(triangle[i - 1][l++], triangle[i - 1][r++]);

단순하게 풀 수 있는 문제였다.