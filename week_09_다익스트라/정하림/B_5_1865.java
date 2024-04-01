package java_study.w9;

import java.util.*;

public class B_5_1865 {
    static int N, M;
    static List<int[]> l = new ArrayList<>();
    static long[] D;
    static final long INF = 10000*500;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            l.add(new int[]{A, B, C});
        }

        D = new long[N + 1];
        Arrays.fill(D, INF);

        if (bellmanFord(1)) {
            for (int i = 2; i <= N; i++) {
                if (D[i] != INF) System.out.println(D[i]);
                else System.out.println(-1);
            }

        }
        else System.out.println(-1);
    }

    static boolean bellmanFord(int start) {
        D[start] = 0;

        for (int i = 0; i < N; i++) {
            for (int[] edge : l) {
                int now = edge[0];
                int nxt = edge[1];
                long cost = edge[2];

                if (D[now] != INF && D[now] + cost < D[nxt]) {
                    D[nxt] = D[now] + cost;
                }
            }
        }

        for (int[] edge : l) {
            int now = edge[0];
            int nxt = edge[1];
            long cost = edge[2];

            if (D[now] != INF && D[now] + cost < D[nxt]) {
                return false;
            }
        }

        return true;
    }
}
