package java_study.w9;

import java.util.*;

public class B_2_11404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] g = new int[n + 1][n + 1];
        final int INF = 100*100000;
        for (int i = 0; i <= n; i++) Arrays.fill(g[i], INF);
        for (int i = 1; i <= n; i++) g[i][i] = 0;


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (g[a][b] > c) g[a][b] = c;

        }

        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    g[a][b] = Math.min(g[a][b], g[a][i] + g[i][b]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (g[a][b] == INF) System.out.print(0+" ");
                else System.out.print(g[a][b]+" ");
            }
            System.out.println();
        }
    }
}
