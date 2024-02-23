package java_study.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2_1388 {
    static String[][] floor;
    static int[][] visited;
    static int N, M, cnt;

    public static void h(int r, int c) {
        // 가로
        cnt++;
        for (int j = c; j < M; j++) {
            if (floor[r][j].equals("-")) {
                visited[r][j] = 1;
            } else {
                return;
            }
        }
    }
    public static void v(int r, int c) {
        // 세로
        cnt++;
        for (int i = r; i < N; i++) {
            if (floor[i][c].equals("|")) {
                visited[i][c] = 1;
            } else {
                return;
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        floor = new String[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    if (floor[i][j].equals("-")){
                        h(i,j);
                    }
                    else {
                        v(i, j);
                    }
                }

            }
        }
        System.out.println(cnt);
    }
}
