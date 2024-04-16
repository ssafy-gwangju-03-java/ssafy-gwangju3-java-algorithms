package week_12_MST.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_3_1774 {
    static int[] parent;
    static int V;
    static int M;
    static ArrayList<Edge> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        int[][] vertices = new int[V + 1][2];
        for (int i = 1; i <= V; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            vertices[i] = new int[]{x, y};
        }

        edges = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            int[] left = vertices[i];
            for (int j = i + 1; j <= V; j++) {
                int[] right = vertices[j];
                long x = left[0] - right[0];
                long y = left[1] - right[1];
                double w = Math.sqrt(x * x + y * y);
                edges.add(new Edge(i, j, w));
            }
        }

        Collections.sort(edges);

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] connected = br.readLine().split(" ");
            int s = Integer.parseInt(connected[0]);
            int e = Integer.parseInt(connected[1]);

            union(s, e);
        }

        double ans = 0;
        int edgeCnt = 0;


        for (Edge edge : edges) {
            if (union(edge.s, edge.e)) {
                ans += edge.w;
                if (++edgeCnt == V - 1) break;
            }
        }

        System.out.println(String.format("%.2f", ans));
    }

    static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        parent[y] = x;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int s, e;
        double w;

        public Edge(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(w, o.w);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "s=" + s +
                    ", e=" + e +
                    ", w=" + w +
                    '}';
        }
    }
}


