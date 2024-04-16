package week_12_MST.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1_16398 {
    static int N, E;
    static int[] p;
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_12_MST/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        p = makeSet();
        edgeList = new Edge[(N) * (N - 1) / 2];

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edgeList[idx] = new Edge(i, j, arr[i][j]);
                idx += 1;
            }
        }

        Arrays.sort(edgeList);

        long totalCost = 0;
        int edgeCnt = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.weight;

                if (++edgeCnt == N - 1) {
                    break;
                }
            }
        }

        System.out.println(totalCost);
        br.close();
    }

    static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a == b) {
            return false;
        }

        p[b] = a;
        return true;
    }

    static int findSet(int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = findSet(p[x]);
    }

    static int[] makeSet() {
        int[] arr = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        return arr;
    }
}
