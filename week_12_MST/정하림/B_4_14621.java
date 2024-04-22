package java_study.w12;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_4_14621 {

    static int N, M;
    static List<Edge>[] adjl;
    static String[] MW;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        MW = new String[N+1];
        for (int i = 1; i <= N; i++) MW[i] = sc.next();

        adjl = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) adjl[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (MW[a].equals(MW[b])) continue;
            adjl[a].add(new Edge(b, c));
            adjl[b].add(new Edge(a, c));
        }
        System.out.println(prim());
    }

    private static long prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
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
        for (int i = 1; i <= N; i++) {
            if (MST[i]) continue;
            return -1;
        }
        return sum;
    }


static class Edge implements Comparable<Edge> {
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
