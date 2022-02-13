package 소수찾기;

import java.util.*;

//  define MAX  9999999
public class Solution {
    final int MAX = 100;
    private final boolean[] primes = new boolean[MAX + 1];
    private final Set<Integer> duplicates = new HashSet<>();

    public Solution() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;  //  mark it is not a prime number.
        for(int i = 2; i * i <= MAX; i++){
            if (primes[i]) {
                for (int j = i * i; j <= MAX; j += i)
                    primes[j] = false;
            }
        }
    }

    public int solution(String numbers) {
        //  generate all possible numbers.
        dfs("", numbers.split(""));
        System.out.printf("Generated: %s\n", duplicates);
        return (int) duplicates.stream().filter(x -> primes[x]).count();
    }

    private void dfs(String val, String[] numbers) {
        if (!val.equals("")) {
            duplicates.add(Integer.parseInt(val));
        }

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
    }
}
