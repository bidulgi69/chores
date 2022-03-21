package 방의개수;

import java.util.*;

public class Solution {
    //  이동
    final int[][] ARROWS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0 , -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public int solution(int[] arrows) {
        int answer = 0;
        int i = 0, j = 0;
        Queue<Vertex> vertexes = new LinkedList<>();
        Map<Vertex, Boolean> visited = new HashMap<>();
        Map<Vertex, List<Vertex>> routes = new HashMap<>();

        vertexes.offer(new Vertex(i, j));
        for (int arrow : arrows) {
            for (int q = 0; q < 2; q++) {
                i += ARROWS[arrow][0];
                j += ARROWS[arrow][1];
                vertexes.offer(new Vertex(i, j));
            }
        }

        Vertex prev = vertexes.poll();
        visited.put(prev, true);

        while (!vertexes.isEmpty()) {
            Vertex next = vertexes.poll();
            if (visited.containsKey(next)) {
                if (!routes.get(next).contains(prev)) {
                    answer++;
                }
            } else {
                visited.put(next, true);
            }

            addRoute(routes, prev, next);
            addRoute(routes, next, prev);
            prev = next;
        }

        return answer;
    }

    void addRoute(Map<Vertex, List<Vertex>> routes, Vertex from, Vertex to) {
        List<Vertex> edges = routes.getOrDefault(from, new LinkedList<>());
        edges.add(to);
        routes.put(from, edges);
    }
}

class Vertex implements Comparable<Vertex> {
    final Integer i;
    final Integer j;

    public Vertex(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return i.equals(vertex.i) && j.equals(vertex.j);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", i, j);
    }

    @Override
    public int compareTo(Vertex o) {
        if (i.equals(o.i)) {
            return j.compareTo(o.j);
        } else return i.compareTo(o.i);
    }
}