package study_week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1_2573 {
    static int n, m;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            int cnt = separate();
            if (cnt == 0) {
                ans = 0;
                break;
            } else if (cnt >= 2) {
                break;
            }
            melt();
            ans++;
        }
        System.out.println(ans);


    }

    static int separate() {
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }
            if (map[nr][nc] > 0 && !visited[nr][nc]) {
                dfs(nr, nc, visited);
            }
        }
    }


    static void melt() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int nr, nc;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int r = t[0];
            int c = t[1];

            int sea = 0;

            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    sea++;
                }
            }

            if (map[r][c] - sea < 0) {
                map[r][c] = 0;
            } else {
                map[r][c] -= sea;
            }

        }
    }

}
