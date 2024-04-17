package week_12_MST.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3_1774 {
    static int N, M;
    static int[] p;
    static Point[] points;
    static Edge[] edgeList;

    static class Point {
        int id, x, y;

        private Point(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return from + " " + to + " " + weight;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_12_MST/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = makeSet();
        points = new Point[N + 1];
        edgeList = new Edge[N * (N - 1) / 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i + 1] = new Point(i + 1, x, y);
        }

        int edgeCnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (union(a, b)) {
                edgeCnt += 1;
            }
        }

        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Point p1 = points[i + 1];
                Point p2 = points[j + 1];
                double weight = weightBetween(p1, p2);

                edgeList[idx] = new Edge(p1.id, p2.id, weight);
                idx += 1;
            }
        }

        Arrays.sort(edgeList);

        double totalCost = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.weight;

                if (++edgeCnt == N - 1) {
                    break;
                }
            }
        }

        System.out.printf("%.2f%n", totalCost);
        br.close();
    }

    static double weightBetween(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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
