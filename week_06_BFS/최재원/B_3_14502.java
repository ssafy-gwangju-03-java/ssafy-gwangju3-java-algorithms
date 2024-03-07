import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3_14502 {
    static int N, M, arr[][], a[][], copyArr[][];
    static boolean selected[];

    static Queue<int[]> startQueue;
    static List<int[]> safeZone;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
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

        startQueue = new ArrayDeque<>();
        safeZone = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    startQueue.add(new int[]{i, j});
                } else if (arr[i][j] == 0) {
                    safeZone.add(new int[]{i, j});
                }
            }
        }

        // safeZone에서 3개를 뽑아 1로 바꾼 후 bfs
        selected = new boolean[safeZone.size()];
        a = new int[3][2];
        comb(0, 0);

        System.out.println(answer);
    }

    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            copyArr = new int[N][M];
            // 원본배열 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyArr[i][j] = arr[i][j];
                }
            }
            // 만들어진 조합으로 벽 세우기
            for (int i = 0; i < 3; i++) {
                copyArr[a[i][0]][a[i][1]] = 1;
            }

            bfs();

            return;
        }

        for (int i = start; i < safeZone.size(); i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            a[cnt] = safeZone.get(i);
            comb(cnt + 1, i + 1);
            selected[i] = false;
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>(startQueue);
        boolean[][] visited = new boolean[N][M];

        // 시작위치 방문처리
        for (int[] s : queue) {
            visited[s[0]][s[1]] = true;
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);
                if (inRange && copyArr[nr][nc] == 0 && !visited[nr][nc]) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    copyArr[nr][nc] = 2;
                }
            }
        }

        // 0 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 0) {
                    count += 1;
                }
            }
        }

        // 정답 갱신
        if (answer < count) {
            answer = count;
        }
    }
}
