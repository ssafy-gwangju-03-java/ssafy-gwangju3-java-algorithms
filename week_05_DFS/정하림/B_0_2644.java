package java_study.정하림;

import java.util.Scanner;

public class B_0_2644 {
    static int[][] mf;
    static int[] visited;
    static int n, p1, p2, m, x, y;
    static int c = 0;
    static int chon = -1;
    public static int dfs(int i1, int c) {
        visited[i1] = 1;
        for (int j = 1; j < n+1 ; j++) {
            if (mf[i1][j] == 1 && visited[j] == 0) {
                if (j == p2) {
                    chon = c+1;
                    break;
                }
                dfs(j,c+1);
            }
        }
        return chon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        m = sc.nextInt();
        mf = new int[n+1][n+1];
        visited = new int[n+1];
        for (int i = 0; i < m ; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            mf[x][y] = 1;
            mf[y][x] = 1; // x,y는 1촌
        }
        System.out.println(dfs(p1, 0));
    }
}
