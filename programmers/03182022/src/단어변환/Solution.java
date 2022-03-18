package 단어변환;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    int tried = Integer.MAX_VALUE;
    Set<String> visited = new HashSet<>();

    public int solution(String begin, String target, String[] words) {
        boolean contains = false;
        for (String word : words) {
            if (target.equals(word)) {
                contains = true;
                break;
            }
        }
        if (!contains) return 0;

        HashMap<String, List<String>> dict = new HashMap<>();
        for (String word : words) addSatisfiedWordToDict(dict, begin, word);

        for (String word : words)
            for (String next : words)
                addSatisfiedWordToDict(dict, word, next);

        System.out.printf("dict: %s\n", dict.entrySet());

        search(begin, target, dict, 0);
        visited.clear();
        return tried;
    }

    void search(String current, String target,
                HashMap<String, List<String>> dict, int passed) {
        System.out.printf("In Stack: %s, %s, %s, %d\t%s\n", dict.entrySet(), current, target, passed, visited.toString());
        visited.add(current);
        List<String> next = dict.getOrDefault(current, Collections.emptyList())
                .stream()
                .filter(x -> !visited.contains(x))
                .collect(Collectors.toList());

        if (current.equals(target)) {
            tried = Math.min(tried, passed);
        } else {
            passed++;
            for (String nw : next) {
                search(nw, target, dict, passed);
            }
        }
    }

    int numberOfDiffCharacters(String s1, String s2) {
        int numOfDiff = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) numOfDiff++;

        return numOfDiff;
    }
    
    void addSatisfiedWordToDict(HashMap<String, List<String>> dict, String s1, String s2) {
        if (numberOfDiffCharacters(s1, s2) == 1) {
            List<String> edges = dict.getOrDefault(s1, new LinkedList<>());
            edges.add(s2);
            dict.put(s1, edges);
        }
    }
}
