package java_study.w9;

import java.util.*;

public class B_0_1446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지름길의 개수
        int dist = sc.nextInt(); // 고속도로의 길이
        // 아이템
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= dist; i++) {
            graph.add(new ArrayList<>());
        }
        final int INF = Integer.MAX_VALUE;
        int[] D = new int[dist + 1];
        Arrays.fill(D, INF);

        for (int i = 0; i < dist; i++) {
            graph.get(i).add(new int[]{i+1, 1});
        }
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int l = sc.nextInt();
            if (s>dist || e > dist) continue;
            graph.get(s).add(new int[]{e, l});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int nowI = poll[0];
            int nowD = poll[1];
            if (D[nowI] < nowD) continue;
            for (int[] nxt : graph.get(nowI)) {
                int nxtI = nxt[0];
                int nxtD = nxt[1];
                int newD = nowD + nxtD;

                if (D[nxtI] > newD) {
                    D[nxtI] = newD;
                    pq.offer(new int[] {nxtI, newD});
                }

            }

        }
        System.out.println(D[dist]);
    }
}
