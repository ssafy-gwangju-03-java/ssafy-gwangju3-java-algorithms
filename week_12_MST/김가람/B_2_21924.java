package week_12_MST.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class B_2_21924 {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Edge>[] adjl;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        adjl = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjl[i] = new ArrayList<>();
        }

        long total = 0;
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            adjl[a].add(new Edge(b, c));
            adjl[b].add(new Edge(a, c));
            total += c;
        }

        long minCost = prim();
        System.out.println((minCost == -1) ? minCost : total - minCost);
    }

    static long prim() {
        boolean[] MST = new boolean[N + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        long cost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (MST[curr.v]) continue;

            MST[curr.v] = true;
            cost += curr.w;

            for (Edge next : adjl[curr.v]) {
                if (!MST[next.v]) pq.add(next);
            }
        }

        boolean isCompleted = true;

        for (int i = 1; i < N + 1; i++) {
            if (!MST[i]) isCompleted = false;
        }

        if (isCompleted) return cost;
        else return -1;
    }

    static class Edge implements Comparable<Edge>{
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }
}


