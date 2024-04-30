package week_14_구현2.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1_2573 {
    static int N, M;
    static int[][] arr;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_14_구현2/최재원/input.txt"));
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


        int islandCount = 0;
        int year = 0;

        while (islandCount < 2) {
            islandCount = 0;
            year += 1;

            int[][] temp = new int[N][M];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    int seaCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);

                        if (inRange && arr[nr][nc] == 0) {
                            seaCount += 1;
                        }
                    }

                    temp[r][c] = seaCount;

                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Math.max(0, arr[i][j] - temp[i][j]);
                }
            }

            boolean islandExists = false;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) {
                        islandExists = true;
                        islandCount += 1;
                        bfs(i, j);
                    }
                }
            }

            if (!islandExists) {
                year = 0;
                break;
            }
        }

        System.out.println(year);
        br.close();
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];


            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);

                if (inRange && arr[nr][nc] != 0 && !visited[nr][nc]) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
