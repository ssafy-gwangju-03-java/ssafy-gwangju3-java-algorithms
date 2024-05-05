package week_14_구현2.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_1_2573 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int year = 0;

        // 1루프 == 1년
        while (true) {
            visited = new boolean[N][M];

            boolean melted = false;
            boolean divided = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    // 방문하지 않은 새 빙산이 있다면 melt 함수 (BFS) 가동
                    if (map[i][j] > 0 && !visited[i][j]) {

                        // 아직 melt 함수가 가동되지 않은 상태였다면 가동 기록 남겨놓기
                        if (!melted) {
                            melted = true;
                            melt(i, j);

                        // melt 함수가 이미 가동된 적 있는데 방문되지 않은 빙산이 남아있다면 빙산이 분리되었다는 뜻이므로 break
                        } else {
                            divided = true;
                            break;
                        }
                    }
                }
            }

            // 분리되었다면 break
            if (divided) break;

            // 만약 빙산이 없어서 melt 함수가 가동되지 않았다면 그 전에 분리된 적 없이 전부 녹은 것이므로 답을 0으로 바꿔주고 break
            if (!melted) {
                year = 0;
                break;
            }

            // 세월이 흐릅니다
            year++;
        }

        System.out.println(year);
    }


    // 빙산 녹이는 BFS 함수
    static void melt(int sr, int sc) {

        // 빙산의 높이를 하나씩 계산한 후 한꺼번에 처리하기 위한 ArrayList
        ArrayList<int[]> toBeMelted = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            // 4방향 탐색하며 바닷물이 있는 칸을 세어줄 변수 water
            int water = 0;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 0이면 water 변수를 업데이트해주고, 아니라면 방문처리 후 q에 넣어줍니다
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
                    if (map[nr][nc] == 0) {
                        water++;
                    } else {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            // ice == (현재 빙산 높이 - 바닷물이 있는 칸의 갯수), 음수면 0처리
            int ice = Math.max(map[r][c] - water, 0);

            // 지금 처리하면 다른 빙산들의 처리에 영향을 주니까 ArrayList에 넣어주고 나중에 처리하기
            toBeMelted.add(new int[]{r, c, ice});
        }

        // BFS 끝나고 빙산 한번에 처리하기
        for (int[] loc : toBeMelted) {
            map[loc[0]][loc[1]] = loc[2];
        }
    }
}


