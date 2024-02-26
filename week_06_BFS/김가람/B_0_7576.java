package week_06_BFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_0_7576 {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] arr;
    static Queue<int[]> queue;
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        day = -1;
        bfs();

        boolean didFinish = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    didFinish = false;
                    break;
                }
            }
        }

        if (didFinish){
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);
                    if (inRange && arr[nr][nc] == 0) {
                        arr[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }

            }
        }
    }
}
