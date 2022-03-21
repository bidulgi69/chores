package 방의개수;

import java.util.*;

public class OtherSolution {
    final int[][] ARROWS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0 , -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public int solution(int[] arrows) {

        Set<Vertex> v = new HashSet<>();
        Set<Edge> e = new HashSet<>();

        int i = 0, j = 0;
        Vertex prev = new Vertex(i, j);
        v.add(prev);
        for (int arrow : arrows) {
            for (int q = 0; q < 2; q++) {
                i += ARROWS[arrow][0];
                j += ARROWS[arrow][1];

                Vertex next = new Vertex(i, j);
                v.add(next);

                if (!prev.equals(next)) {
                    if (prev.compareTo(next) > 0) e.add(new Edge(next, prev));
                    else e.add(new Edge(prev, next));
                }
                prev = next;
            }
        }
        //  euler
        //  v-e+f=1
        return 1 - v.size() + e.size();
    }
}

class Edge {
    Vertex v1;
    Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(v1, edge.v1) && Objects.equals(v2, edge.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                "}\n";
    }
}