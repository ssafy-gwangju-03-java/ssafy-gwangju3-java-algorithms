 package java_study.w12;

import java.util.*;


public class B_3_1774 {
    static int N, M;
    static int[][] matrix; // 우주신 좌표
    static List<Edge>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            matrix[i] = new int[]{i, sc.nextInt(), sc.nextInt()};
        }

        edges = new List[N+1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                double r = Math.pow(matrix[i][1] - matrix[j][1], 2);
                double c = Math.pow(matrix[i][2] - matrix[j][2], 2);
                double length = Math.sqrt(r+c);
                edges[i].add(new Edge(j, length));
                edges[j].add(new Edge(i, length));
            }
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges[from].add(new Edge(to, 0));
            edges[to].add(new Edge(from, 0));
        }

        System.out.printf("%.2f", prim());
    }
    public static double prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] MST = new boolean[N+1];

        pq.offer(new Edge(1, 0));
        double total = 0;
        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int to = now.to;
            double weight = now.weight;

            if(MST[to]) continue;

            MST[to] = true;
            total += weight;
            for (Edge nxt : edges[to]) {
                if (!MST[nxt.to]) {
                    pq.offer(nxt);
                }
            }

        }
        return total;
    }
    static class Edge implements Comparable<Edge> {
        int to;
        double weight;

        public Edge(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }


}

