package week_09_다익스트라.김가람;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_0_1753 {
    static int V;
    static int E;
    static int S;
    static ArrayList[] adjl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        S = Integer.parseInt(br.readLine());
        adjl = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adjl[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            adjl[u].add(new Node(w, v));
        }

        djk(S);
    }

    static void djk(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, s));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.n] < curr.w) continue;
            dist[curr.n] = curr.w;

            ArrayList<Node> connected = adjl[curr.n];
            for (int i = 0; i < connected.size(); i++) {
                Node next = connected.get(i);
                int acc = curr.w + next.w;
                if (acc < dist[next.n]) {
                    pq.add(new Node(acc, next.n));
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    static class Node implements Comparable<Node> {
        int w, n;

        public Node(int w, int n) {
            this.w = w;
            this.n = n;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}