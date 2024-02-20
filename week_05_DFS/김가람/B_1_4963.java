package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_4963 {
    static int[][] sea;
    static int[][] visited;
    static int W;
    static int H;
    static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (!s.equals("0 0")) {
            String temp[] = s.split(" ");
            W = Integer.parseInt(temp[0]);
            H = Integer.parseInt(temp[1]);

            sea = new int[H][W];
            visited = new int[H][W];

            for (int i = 0; i < H; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    sea[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (sea[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j);
                        island++;
                    }
                }
            }



            System.out.println(island);

            s = br.readLine();
        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = 1;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            boolean inRange = (0 <= nr && nr < H && 0 <= nc && nc < W);
            if (inRange && visited[nr][nc] == 0 && sea[nr][nc] == 1) dfs(nr, nc);
        }
    }
}


