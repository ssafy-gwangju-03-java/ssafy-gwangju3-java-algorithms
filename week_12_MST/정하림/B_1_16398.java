package java_study.w12;

import java.util.*;



public class B_1_16398 {
    static int N;
    static List<Edge>[] adjl;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        adjl = new ArrayList[N];
        for (int i = 0; i < N; i++) adjl[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int w = sc.nextInt();
                adjl[i].add(new Edge(j, w));
            }
        }

        System.out.println(prim());

    }

    private static long prim() {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        boolean[] MST = new boolean[N];
        long sum = 0;
        while (!pq.isEmpty()){
            Edge poll = pq.poll();
            int to = poll.to;
            int weight = poll.weight;

            if (MST[to]) continue;
            MST[to] = true;
            sum += weight;

            for (Edge nxt : adjl[to]){
                if (!MST[nxt.to]) pq.offer(nxt);
            }
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

            return this.weight - o.weight;
        }
    }

}
