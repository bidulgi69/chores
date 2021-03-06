동적 계획법을 이용해 쉽게 풀 수 있는 문제였다.

피보나치 수열처럼, 
    
    fib[3] = fib[1] + fib[2] 

의 형태로 이전 단계에서 계산했던 값은 변하지 않으며 뒤의 연산에서 사용할 경우(반복될 경우) 동적 계획법을 활용할 수 있다.

주어진 수 N 에 대해서, [1], [2] 와 같이 증가할 수 있는 방식은 N 을 활용한 횟수라고 생각하고 진행했다.

N = 5 일 경우, dp[1] = [5] 이며

dp[2] = dp[1] + dp[1] 로 나타낼 수 있는데, 이 때의 + 연산은 사칙연산(+, -, *, /)을 모두 수행해줘야 한다. (O(n^2))

연산 결과의 중복을 피하기 위해 Set 을 사용해 결과값들을 저장하고, 최종 결과값에 number 가 존재할 경우 해당 반복문의 인덱스를 반환한다.

문제에서 N 을 8회 이상 사용할 경우 -1을 반환하도록 제시했기 때문에, memoization 을 위한 배열의 초기 크기와 반복 횟수를 8로 정해둘 수 있다.