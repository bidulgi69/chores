dfs 를 활용해 풀 수 있는 문제다.

begin 글자부터 시작해서 한번에 한 개의 character 만 변경하면서 target 에 도달하면 된다.

dfs 의 파라미터로 words 배열을 계속 넘겨준 뒤 현재(param: current)와 다른 글자가 1개인 글자를 찾아내는 것이 비효율적이라고 생각해,

{ word, [1개의 글자만 차이나는 words] } 형태로 구조를 변경했다.

풀고 난 후에 생각해보니 큰 차이는 없는 것 같다.

이후 다른 dfs 문제들처럼 현재 이동할 수 있는 edge 들에 대해서 재귀함수를 수행해주면 쉽게 풀 수 있는 문제였다.

    passed++;
    for (String nw : next) {
        search(nw, target, dict, passed);
    }