import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_5_5653 {
    static int N, M, K;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N + 2 * K][M + 2 * K];
            pq = new PriorityQueue<>(((o1, o2) -> -Integer.compare(o1[2], o2[2])));

            for (int i = K; i < K + N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = K; j < K + M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    int life = arr[i][j];

                    if (life != 0) {
                        pq.add(new int[]{i, j, life, 2 * life});
                    }
                }
            }

            bfs();

            sb.append("#").append(tc).append(" ").append(pq.size()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs() {
        for (int i = 0; i < K; i++) {
            Queue<int[]> tempq = new ArrayDeque<>();
            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int r = poll[0];
                int c = poll[1];
                int life = poll[2];
                int life2 = poll[3] - 1;

                if (life2 == life - 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (arr[nr][nc] == 0) {
                            arr[nr][nc] = life;
                            tempq.add(new int[]{nr, nc, life, 2 * life});
                        }
                    }
                }

                if (life2 != 0) {
                    tempq.add(new int[]{r, c, life, life2});
                }
            }

            pq.addAll(tempq);
        }
    }
}
