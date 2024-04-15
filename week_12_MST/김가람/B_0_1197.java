package week_12_MST.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class B_0_1197 {
    static int V;
    static int E;
    static ArrayList<Edge>[] adjl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        E = Integer.parseInt(info[1]);
        adjl = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjl[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] temp = br.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);
            int C = Integer.parseInt(temp[2]);
            adjl[A].add(new Edge(B, C));
            adjl[B].add(new Edge(A, C));
        }

        System.out.println(prim());
    }

    static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        boolean[] MST = new boolean[V + 1];
        int ans = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int next = curr.to;
            int weight = curr.weight;

            if (MST[next]) continue;

            MST[next] = true;
            ans += weight;

            for (Edge nextNode : adjl[next]) {
                if (!MST[nextNode.to]) {
                    pq.add(nextNode);
                }
            }
        }

        return ans;
    }

    static class Edge implements Comparable<Edge> {
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
}