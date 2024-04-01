package java_study.w9;

import java.util.*;

public class B_4_1504 {
    static int N, E, a, b, c;
    static List<List<int[]>> g = new ArrayList<>();
    static int v1, v2;
    static PriorityQueue<int[]> pq;
    static int[] D;
    static int INF = 1000 * 400000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점 개수
        E = sc.nextInt(); // 간선 개수

        for (int i = 0; i <= N; i++) g.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            g.get(a).add(new int[]{b, c});
            g.get(b).add(new int[]{a, c}); // 양방향
        }

        D = new int[N + 1];

        v1 = sc.nextInt();
        v2 = sc.nextInt();

        int route1 = 0, route2 = 0;
        dijkstra(1);
        route1 += D[v1];
        route2 += D[v2];
        dijkstra(v1);
        route1 += D[v2];
        route2 += D[v2];
        route2 += D[N];
        dijkstra(v2);
        route1 += D[N];

        int ans = INF;
        ans = Math.min(ans, route1);
        ans = Math.min(ans, route2);
        if (ans == INF) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void dijkstra(int start) {
        pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        Arrays.fill(D, INF);
        pq.offer(new int[]{start, 0});
        D[start] = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int nowI = poll[0];
            int nowD = poll[1];

            if (D[nowI] < nowD) continue;

            for (int[] nxt : g.get(nowI)) {
                int nxtI = nxt[0];
                int nxtD = nxt[1];
                int newD = nowD + nxtD;
                if (D[nxtI] > newD) {
                    D[nxtI] = newD;
                    pq.offer(new int[]{nxtI, newD});
                }
            }
        }

    }
}
