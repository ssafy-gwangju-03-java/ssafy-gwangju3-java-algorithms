package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5_1012 {
    static int n, m;
    static int[][] field;
    static boolean[][] visited;
    // 상하좌우
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++){
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            int cabbage = Integer.parseInt(s[2]);

            field = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < cabbage; i++) {
                String[] temp = br.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                field[b][a] = 1;
            }

            int worm = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        worm++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(worm);
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            boolean inRange = (0 <= nr && nr < n && 0 <= nc && nc < m);
            if (inRange && !(visited[nr][nc]) && (field[nr][nc] == 1)) {
                dfs(nr, nc);
            }
        }
    }
}
