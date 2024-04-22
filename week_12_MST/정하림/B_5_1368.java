package java_study.w12;

import java.util.*;

public class B_5_1368 {
    static int N;
    static List<Edge>[] adjl;
    static int[] W;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


        adjl = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) adjl[i] = new ArrayList<>();

        W = new int[N + 1];
        int start = 1;
        int w = 999999;
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            if (w > W[i]) {
                w = W[i];
                start = i;
            }
            for (int j = 1; j <= N; j++) {
                adjl[j].add(new Edge(i, W[i]));
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adjl[i].add(new Edge(j, sc.nextInt()));
            }
        }
        System.out.println(prim(start));
    }

    private static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] MST = new boolean[N+1];

        pq.offer(new Edge(start, W[start]));
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int to = now.to;
            int weight = now.weight;

            if (MST[to]) continue;
            MST[to] = true;
            sum += weight;

            for (Edge nxt : adjl[to]) {
                if (!MST[nxt.to]) pq.offer(nxt);
            }
        }
        return sum;
    }
    static class Edge implements Comparable<Edge>{
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
