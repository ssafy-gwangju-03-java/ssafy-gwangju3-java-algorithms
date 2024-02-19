package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_2644 {
    static int[][] family;
    static int N;
    static int p1;
    static int p2;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        p1 = Integer.parseInt(temp[0]);
        p2 = Integer.parseInt(temp[1]);
        int R = Integer.parseInt(br.readLine());
        family = new int[N+1][N+1];
        ans = -1;

        for (int i = 0; i < R; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            family[a][b] = 1;
            family[b][a] = 1;
        }

        dfs(p1, 0);
        System.out.println(ans);
    }

    private static void dfs(int p, int r) {
        family[p][p] = 1;
        if (p == p2) {
            ans = r;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (family[p][i] == 1 && family[i][i] == 0) {
                dfs(i, r+1);
            }
        }
    }
}


