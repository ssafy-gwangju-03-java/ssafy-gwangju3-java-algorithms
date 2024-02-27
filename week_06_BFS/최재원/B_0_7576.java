import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_0_7576 {
    static int N, M;
    static int[][] arr;
    static Queue<int[]> queue;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int count = -1;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
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

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    count = -1;
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            count += 1;

            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];

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
