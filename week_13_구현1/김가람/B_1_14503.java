package week_13_구현1.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        String[] info = br.readLine().split(" ");
        int R = Integer.parseInt(info[0]);
        int C = Integer.parseInt(info[1]);

        int[][] map = new int[R][C];
        int[][] visited = new int[R][C];

        String[] robotInfo = br.readLine().split(" ");
        int r = Integer.parseInt(robotInfo[0]);
        int c = Integer.parseInt(robotInfo[1]);
        int d = Integer.parseInt(robotInfo[2]);

        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int cleaned = 0;

        while (true) {

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0 && visited[r][c] == 0) {
                visited[r][c] = 1;
                cleaned++;
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는지 반시계 방향으로 90도 회전하며 확인한다
            boolean didFind = false;
            int nd = d;
            for (int i = 0; i < 4; i++) {
                nd -= 1;

                if (nd == -1) nd = 3;

                int nr = r + dr[nd];
                int nc = c + dc[nd];

                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진하고 처음으로 돌아간다
                if (visited[nr][nc] == 0 && map[nr][nc] == 0) {
                    d = nd;
                    r = nr;
                    c = nc;
                    didFind = true;
                    break;
                }
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!didFind) {
                nd = (d + 2) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if (map[nr][nc] == 1) {
                    // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
                    break;
                } else {
                    // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 처음으로 돌아간다
                    r = nr;
                    c = nc;
                }
            }
        }

        System.out.println(cleaned);
    }
}



