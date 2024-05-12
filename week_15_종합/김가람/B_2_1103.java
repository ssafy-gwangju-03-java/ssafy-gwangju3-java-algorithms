package week_15_종합.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2_1103 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] map;
    static int[][] memo;
    static int ans;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        map = new int[N][M];
        memo = new int[N][M];           // 각 좌표를 지나는 경로가 지니는 최대 움직임의 갯수를 저장해줄 Memoization 배열
        visited = new boolean[N][M];    // 사이클 여부를 체크해줄 방문체크 배열

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'H') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
                }
            }
        }

        ans = 0;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int depth) {
        if (ans == -1) return;          // 사이클이 존재하면 더이상 진행하지 않는다
        ans = Math.max(ans, depth);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d] * map[r][c];
            int nc = c + dc[d] * map[r][c];

            // 예전에 탐색했던 경로에서 저장해놓았던 값(memo[nr][nc])보다 현재 탐색한 경로의 값(depth + 1)이 더 크면 갱신
            if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && depth + 1 > memo[nr][nc]) {

                // visited 배열이 체크되어있다
                // == 현재 탐색중인 경로에서 이미 탐색했던 지점으로 되돌아왔다
                // == 사이클이 발생했다
                if (visited[nr][nc]) {
                    ans = -1;
                    return;
                } else {
                    memo[nr][nc] = depth + 1;
                    visited[nr][nc] = true;         // 현재 탐색중인 경로임을 표시
                    dfs(nr, nc, depth + 1);
                    visited[nr][nc] = false;        // 현재 경로 탐색 완료했으므로 다음에 탐색할 경로 위해 다시 비워주기
                }
            }
        }
    }
}


