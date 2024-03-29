package study_week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_4_1504 {
    static final long inf = (long) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        long[][] dis = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dis[i], inf);
        }
        for (int i = 1; i <= n; i++) {
            dis[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dis[a][b] = c;
            dis[b][a] = c;
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    dis[a][b] = Math.min(dis[a][b], dis[a][k] + dis[k][b]);
                }
            }
        }
        long result = Math.min(dis[1][v1]+dis[v1][v2]+dis[v2][n], dis[1][v2]+dis[v1][v2]+dis[v1][n]);
        if(result >= inf){
            System.out.println(-1);
        }
        else{
        System.out.println(result);
        }
    }
}
