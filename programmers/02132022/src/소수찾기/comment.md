소수 판별 + dfs 알고리즘을 사용해 풀 수 있는 문제였다.

소수 판별은 이전에 에라토스테네스의 체 문제를 풀어본 경험이 있어서 어렵지 않았지만,

가능한 수를 생성하는 (dfs 를 사용해서 풀 수 있는) 방법을 생각해내지 못했다. 

        for (int i = 0; i < numbers.length; i++) {
            String[] neighbors = new String[numbers.length - 1];
            int offset = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (j != i) {
                    neighbors[offset++] = numbers[j];
                }
            }
            dfs(val.concat(numbers[i]), neighbors);
        }

인접 행렬에 대한 정보를 주기 위해서 깊이가 늘어날 때마다 현재 위치를 지워주는 방식을 구현했다.

반복문 안에서 생성한 배열에 대해서 remove 함수를 수행하면 계속 에러가 발생해서 시간을 많이 뺏겼다.