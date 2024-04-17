package week_12_MST.전기철;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_2_21924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] vis = new int[v + 1];
        long ans = 0;
        long sm = 0;
        int cnt = 0;
        List<int[]>[] lst = new List[v + 1];
        for (int i = 0; i < v + 1; i++) {
            lst[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            lst[a].add(new int[] { c, b });
            lst[b].add(new int[] { c, a });
            sm += c;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(k -> k[0]));
        heap.add(new int[] { 0, 1 });
        while (!heap.isEmpty()) {
            int[] edge = heap.poll();
            int w = edge[0];
            int now = edge[1];
            if (vis[now] == 0) {
                vis[now] = 1;
                ans += w;
                cnt += 1;
                for (int[] next : lst[now]) {
                    if (vis[next[1]] == 0) {

                        heap.add(next);
                    }
                }
            }

        }
        if (cnt == v) {
            System.out.println(sm - ans);
        } else {
            System.out.println(-1);
        }
    }
}