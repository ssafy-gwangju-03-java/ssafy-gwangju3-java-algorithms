package week_09_다익스트라.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B_0_1916 {
    static int N;
    static int M;
    static ArrayList[] adjl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjl = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjl[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            adjl[u].add(new Node(w, v));
        }

        String[] depArr = br.readLine().split(" ");
        int S = Integer.parseInt(depArr[0]);
        int E = Integer.parseInt(depArr[1]);

        System.out.println(djk(S, E));
    }

    static int djk(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, s));
        int[] dist = new int[N + 1];
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

        return dist[e];
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