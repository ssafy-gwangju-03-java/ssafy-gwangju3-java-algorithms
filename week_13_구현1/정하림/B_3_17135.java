import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3_17135 {
    static int N;
    static int M;
    static int D;
    static int ans = 0;
    static int[][] map;
    static int[][] original;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        original = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                original[i][j] = map[i][j];
            }
        }
        int[] archer = new int[3];
        comb(1, 0, archer);
        System.out.println(ans);
    }
    // nCr
    public static void comb(int n, int r, int[] archer) {
        if (r == 3) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = original[i][j]; // 복구
                }
            }
            attack(archer);
            return;
        }
        for (int i = n; i <= M; i++) {
            archer[r] = i;
            comb(n + 1, r + 1, archer);
        }
    }


    public static int distance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void attack(int[] archer) {
        int cnt = 0;
        for (int n = 1; n <= N; n++) {
            boolean[][] visited = new boolean[N + 1][M + 1];
            for (int a = 0; a < 3; a++) {
                int archerR = archer[a];
                int minD = Integer.MAX_VALUE;
                int minR = Integer.MAX_VALUE;
                int minC = Integer.MAX_VALUE;

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if (map[i][j] == 1) {
                            int distance = distance(j, archerR, i, N + 1);
                            if (distance < minD) {
                                minD = distance;
                                minC = j;
                                minR = i;
                            } else if (distance == minD) {
                                if (j < minC) {
                                    minC = j;
                                    minR = i;
                                }
                            }
                        }
                    }
                }
                if (minD <= D) visited[minR][minC] = true;

            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 0;
                        cnt++;
                    }
                }
            }
            for (int i = N; i >= 1; i--) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        ans = Math.max(cnt, ans);
    }
}