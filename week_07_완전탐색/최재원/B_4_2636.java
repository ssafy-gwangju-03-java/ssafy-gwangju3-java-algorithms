import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4_2636 {

    static int N, M;
    static int[][] arr;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_07_완전탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int prev_count = 0;
        int time = 0;
        while (true) {
            // 치즈 개수 확인
            int cheese_count = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (arr[r][c] == 1) {
                        cheese_count += 1;
                    }
                }
            }

            if (cheese_count == 0) {
                break;
            }

            prev_count = cheese_count;
            time += 1;

            visited = new int[N][M];

            // 좌우 테두리에서 공기 검사
            for (int i = 0; i < N; i++) {
                if (arr[i][0] == 0) {
                    if (visited[i][0] == 0) {
                        bfs_air(i, 0);
                    }
                    if (visited[i][M - 1] == 0) {
                        bfs_air(i, M - 1);
                    }
                }
            }

            // 상하 테두리에서 공기 검사
            for (int i = 0; i < M; i++) {
                if (arr[0][i] == 0) {
                    if (visited[0][i] == 0) {
                        bfs_air(0, i);
                    }
                    if (visited[N - 1][i] == 0) {
                        bfs_air(N - 1, i);
                    }
                }
            }

            // 배열을 순회하며 치즈면 상하좌우 검사
            // 상하좌우를 visited와 비교해서 공기가 있으면 치즈 좌표를 녹일 target배열에 저장

            int[][] target = new int[N][M];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    // 치즈면 상하좌우 검사
                    if (arr[r][c] == 1) {

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);

                            // 공기랑 닿아있으면
                            if (inRange && visited[nr][nc] == 1) {
                                target[r][c] = 1;
                            }

                        }
                    }
                }
            }

            // target을 이용해서 치즈 녹이기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (target[r][c] == 1) {
                        arr[r][c] = 0;
                    }
                }
            }
        }

        System.out.println(time);
        System.out.println(prev_count);

    }

    private static void bfs_air(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[i][j] = 1;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);

                if (inRange && visited[nr][nc] == 0 && arr[nr][nc] == 0) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = 1;
                }

            }
        }

    }

}
