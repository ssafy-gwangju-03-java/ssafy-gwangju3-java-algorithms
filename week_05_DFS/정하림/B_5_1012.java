package java_study.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5_1012 {
    static int T, M, N, K, X, Y;
    static int[][] map;
    static int[][] D = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int nr, nc;
    public static void worm(int r, int c) {
        for (int d = 0; d < 4; d++) {
            nr = r + D[0][d];
            nc = c + D[1][d];
            boolean inRange = (0<=nr && nr<N && 0<=nc && nc<M);
            if (inRange && map[nr][nc] == 1) {
                map[nr][nc] = 0;
                worm(nr, nc);
            } 
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                        worm(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }

    }
        
}
