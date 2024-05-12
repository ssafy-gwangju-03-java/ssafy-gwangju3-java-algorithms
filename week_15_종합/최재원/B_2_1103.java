package week_15_종합.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2_1103 {
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] dp;
    static boolean cycle;
    static int answer = 0;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_15_종합/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(cycle ? -1 : answer);
    }

    static void dfs(int r, int c, int count) {
        dp[r][c] = count;

        if (answer < count) {
            answer = count;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d] * (arr[r][c] - '0');
            int nc = c + dc[d] * (arr[r][c] - '0');

            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                if (visited[nr][nc]) {
                    cycle = true;
                    return;
                }

                if (arr[nr][nc] == 'H') {
                    continue;
                }

                if (dp[nr][nc] > count) {
                    continue;
                }

                visited[nr][nc] = true;
                dfs(nr, nc, count + 1);
                visited[nr][nc] = false;
            }
        }
    }
}
