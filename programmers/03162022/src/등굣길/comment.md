최단 경로를 구하는 문제이다. 

<img src="https://user-images.githubusercontent.com/17774927/158537683-9dd67ca1-323b-409f-bb11-15b573f394d5.png">
출처(https://bhsmath.tistory.com/154)

물에 잠긴 지역이 2개 이상일 경우가 존재하기 때문에, 위 그림처럼 계산하는 방식을 선택했다.

    for (int[] puddle : puddles) map[puddle[0] - 1][puddle[1] - 1] = -1;
    for (int i = 0; i < m; i++) {
        if (map[i][0] == -1) break;
        map[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        if (map[0][j] == -1) break;
        map[0][j] = 1;
    }

먼저 물에 잠긴 지역을 표시한 뒤, [m][0], [0][n] 의 값을 1로 초기화해준다.

이 때 주의해야할 것은 중간에 물에 잠긴 지역이 있을 경우, 해당 지역(x)과 [x+1...][0] 또는 [0][x+1...] 은 0으로 초기화된 상태여야 한다. (도달할 수 없다.)

    for (int row = 1; row < m; row++) {
        for (int col = 1; col < n; col++) {
            if (map[row][col] != -1) {
                map[row][col] = (Math.max(map[row - 1][col], 0) + Math.max(map[row][col - 1], 0)) % DENOM;
            }
        }
    }

이후엔 단순 계산을 해주면 되는데, cell 의 값이 Integer.MAX_VALUE 를 넘어가는 경우가 발생할 수도 있으니 문제에서 주어진 값으로 modulo 연산을 수행해줘야 한다.