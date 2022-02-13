테두리 (outline) == brown, width * height - brown == yellow 두 공식을 활용해 풀 수 있는 간단한 문제였다.

    int width = Arrays.stream(factors).reduce((f1, f2) -> f1 * f2).orElse(1);
        rectangles.add(new Rectangle(width, height));

        for (int i = 0; i < factors.length; i++) {
            int[] neighbors = new int[factors.length - 1];
            int offset = 0;
            for (int j = 0; j < factors.length; j++) {
                if (j != i) {
                    neighbors[offset++] = factors[j];
                }
            }
            dfs(height * factors[i], neighbors);
        }
처음엔 소수찾기 문제에서 했던대로 width, height 쌍의 경우의 수를 dfs 알고리즘을 수행해 계산했는데,

한 테스트 케이스에서 실행시간 초과가 나와 다른 방법을 찾아야했다.

단순하게 i 와 j 쌍을 1씩 증가시키면서 pair 를 구하는 방법을 선택했는데, brown 값이 [1, 5000] 의 값을 갖기 때문에

dfs 로 구하는 알고리즘보다 훨씬 빠르게 처리가 되는 것 같다.