package week_12_MST.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_5_1368 {
    static int V;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        // 가상의 0번 노드(우물)을 만들어 연결
        map = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            map[0][i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= V; i++) {
            map[i][0] = map[0][i];
        }

        for (int i = 1; i <= V; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j <= V; j++) {
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        int ans = prim();

        System.out.println(ans);
    }

    static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        boolean[] MST = new boolean[V + 1];

        int totalCost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (MST[curr.v]) continue;

            MST[curr.v] = true;
            totalCost += curr.w;

            for (int i = 0; i <= V; i++) {
                if (!MST[i]) pq.add(new Edge(i, map[curr.v][i]));
            }
        }

        return totalCost;
    }

    static class Edge implements Comparable<Edge> {
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


