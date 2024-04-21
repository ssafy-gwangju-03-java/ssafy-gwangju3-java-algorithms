package week_12_MST.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class B_4_14621 {
    static int[] parent;
    static int V;
    static int E;
    static ArrayList<Edge> edges;
    static HashMap<Integer, String> uniInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        E = Integer.parseInt(info[1]);

        String[] c = br.readLine().split(" ");
        uniInfo = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            uniInfo.put(i, c[i-1]);     // { 1: "W", 2: "M", ... }
        }

        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int u = Integer.parseInt(edgeInfo[0]);
            int v = Integer.parseInt(edgeInfo[1]);
            int w = Integer.parseInt(edgeInfo[2]);

            // 남 + 남 || 여 + 여를 잇는 간선은 제외
            if (uniInfo.get(u).equals(uniInfo.get(v))) continue;

            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);

        int edgeCnt = 0;
        int totalDist = 0;

        for (Edge edge : edges) {
            if (union(edge.s, edge.e)) {
                totalDist += edge.w;
                if (++edgeCnt == V - 1) break;
            }
        }

        System.out.println((edgeCnt == V - 1) ? totalDist : -1);
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
    }
}


