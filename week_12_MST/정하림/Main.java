package java_study.w12.B_2_21924;

import java.util.*;

// 프림
class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
public class Main {
    static int N, M; // 건물 N 도로 M
    static ArrayList<Edge>[] adjl;
    static long totalCost = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        adjl = new ArrayList[N + 1];
        for (int i = 0; i <= N ; i++) adjl[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            adjl[a].add(new Edge(b, c));
            adjl[b].add(new Edge(a, c));

            totalCost += c;
        }
        System.out.println(prim());
    }

    private static long prim() {
        Queue<Edge> pq = new PriorityQueue<>();
        boolean[] MST = new boolean[N+1];

        pq.offer(new Edge(1, 0));

        long sum = 0;

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
        for (int i = 1; i <= N; i++) {
            if (!MST[i]) return -1;
        }
        return totalCost - sum;
    }

}
