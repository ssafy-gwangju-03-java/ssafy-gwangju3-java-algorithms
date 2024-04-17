package java_study.w12;
import java.util.Arrays;
import java.util.Scanner;



public class B_0_1197 {
    static int V, E;
    static int[] p;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(s, e, w);
        }
        Arrays.sort(edges);

        p = new int[V+1];
        for (int i = 1; i <= V; i++) p[i] = i;

        int sum = 0, cnt = 0;
        for (Edge edge : edges) {
            if (unionSet(edge.from, edge.to)) {
                sum += edge.weight;
                cnt++;
                if (cnt == V-1) break;

            }
        }
        System.out.println(sum);

    }
    public static Boolean unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if (pa == pb) return false;
        p[pb] = p[pa];
        return true;
    }

    public static int findSet(int a) {
        if (a == p[a]) return a;
        return p[a] = findSet(p[a]);
    }
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
