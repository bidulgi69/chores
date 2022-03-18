package 여행경로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else return o1[0].compareTo(o2[0]);
        });
        return dfs("ICN", tickets, answer, 0);
    }

    String[] dfs(String airport, String[][] tickets, String[] routes, int routeIndex) {
        routes[routeIndex++] = airport;
        System.out.printf("DFS: %s,\n%s\n%s, %d\n\n", airport, print2dArray(tickets), Arrays.toString(routes), routeIndex);
        if (tickets.length == 0) return routes;
        else {
            String[][] candidates = Arrays.stream(tickets)
                    .filter(ticket -> ticket[0].equals(airport))
                    .sorted(Comparator.comparing(ticket -> ticket[1]))
                    .toArray(String[][]::new);

            for (String[] candidate : candidates) {
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
                if (cases.length != 0) return cases;
            }
        }
        return new String[]{};
    }

    String print2dArray(String[][] array) {
        StringBuilder sb = new StringBuilder();
        for (String[] arr : array) {
            sb.append("[").append(arr[0]).append(", ").append(arr[1]).append("]\t");
        }
        return sb.toString();
    }
}

