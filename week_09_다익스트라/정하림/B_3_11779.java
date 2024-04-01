package java_study.w9;

import java.util.*;

public class B_3_11779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            g.get(s).add(new int[]{e, c});
        }

        int[] D = new int[n + 1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(D, INF);

        int[] path = new int[n+1];
        int start = sc.nextInt();
        int end = sc.nextInt();

        // 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e->e[1]));
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
                    path[nxtI] = nowI;
                    pq.offer(new int[]{nxtI, newD});

                }
            }

        }
        System.out.println(D[end]);
        List<Integer> ans = new ArrayList<>();
        ans.add(end);
        int now = end;
        while (now!=start) {
            ans.add(path[now]);
            now = path[now];
        }
        System.out.println(ans.size());
        for (int i = ans.size()-1; i >=0 ; i--) {
            System.out.print(ans.get(i)+" ");

        }


    }
}
