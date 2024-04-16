package week_12_MST.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_1_16398 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        System.out.println(prim());
    }

    static long prim() {
        boolean[] MST = new boolean[N];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        long cost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (MST[curr.v]) continue;

            MST[curr.v] = true;
            cost += curr.w;

            for (int i = 0; i < N; i++) {
                if (!MST[i]) pq.add(new Edge(i, map[curr.v][i]));
            }
        }

        return cost;
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


