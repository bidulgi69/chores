dfs 를 활용해 풀 수 있는 문제다.

주어진 tickets[][] 배열의 원소들을 모두 사용할 때까지  재귀호출을 해야 한다.

주의해야할 점은 두 가지인데,

1. 동일한 티켓(출발지, 도착지)이 존재할 수도 있다.
2. 다음 도착지로 넘어갔을 때, 고립될 수 있다. (다음 여행지로 넘어갈 수 있는 티켓이 존재하지 않음.)

첫 번째 경우부터 살펴보자. 나의 경우 첫 번째 경우 때문에 풀이에 시간이 오래 걸렸다..

    AtomicBoolean isDuplicated = new AtomicBoolean(false);
    String[] cases = dfs(
            candidate[1],
            Arrays.stream(tickets)
                    .filter(ticket -> {
                        //  중복 티켓이 존재할 경우, 1개만 filter 처리를 해줘야함.
                        boolean isSame = candidate[0].equals(ticket[0]) && candidate[1].equals(ticket[1]);
                        if (!isSame) return true;
                        else {
                            if (!isDuplicated.get()) {
                                isDuplicated.set(true);
                                return false;
                            } else return true;
                        }
                    })
                    .map(ticket -> new String[]{ticket[0], ticket[1]})
                    .toArray(String[][]::new),
            routes,
            routeIndex
    );

다음 재귀함수를 호출할 때 내가 사용한 티켓을 제외하고 넘겨줘야 하는데,

만약 동일한 티켓이 존재한다면 .filter() 에서 동일한 티켓이 모두 사라지게 된다. 이를 주의해줘야 한다.

test case 로는 

    tickets:    {{"ICN", "A"}, {"ICN", "A"}, {"A", "B"}, {"B", "A"}, {"A", "ICN"}}
    answer:     {"ICN", "A", "B", "A", "ICN", "A"} 

를 사용해보면 알 수 있다.

두 번째 경우는 단순히 다음 도착지를 선택할 경우 선택할 티켓이 존재하지 않는 경우이다.

내가 작성한 코드에서는 따로 고려해주지 않아도 되는 사항이다. (다시 상위 node 로 돌아올 수 있기 때문.)

    // 아래 코드는 잘못된 코드임.
    Optional<String[]> next = Optional.empty();
    if (candidates.length > 1) {
        next = Arrays.stream(candidates)
                .filter(candidate -> {
                    //  다음 candidate 로 넘어간 뒤, 다시 여행을 출발할 수 있는지 (갇힐 수 있음) 검사
                    boolean movable = false;
                    for (String[] ticket : tickets) {
                        if (ticket[0].equals(candidate[1])) {
                            movable = true;
                            break;
                        }
                    }
                    return movable;
                })
                .min(Comparator.comparing(ticket -> ticket[1]));
    } else if (candidates.length == 1) {
        next = Optional.of(candidates[0]);
    }

만약, 위와 같이 다음 여행지를 판별하는 형태로 구현한다면, 

매번 다음 여행지로 넘어간 뒤부터 다시 dfs 를 호출해 모든 티켓을 사용할 수 있는지를 판별해줘야 한다.