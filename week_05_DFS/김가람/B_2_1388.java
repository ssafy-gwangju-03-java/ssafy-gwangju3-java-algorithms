package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2_1388 {
    static int N;
    static int M;
    static char[][] floor;
    static int[] dr = new int[]{0, 1};
    static int[] dc = new int[]{1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        floor = new char[N][M];

        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().toCharArray();
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-') {
                    cnt++;
                    dfs(i, j, 0);
                } else if (floor[i][j] == '|') {
                    cnt++;
                    dfs(i, j, 1);
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int r, int c, int d) {
        char curr = floor[r][c];
        floor[r][c] = 'X';

        int nr = r + dr[d];
        int nc = c + dc[d];
        boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);
        if (inRange && floor[nr][nc] == curr) dfs(nr, nc, d);
    }
}



