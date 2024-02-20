package study_week5;

import java.util.Scanner;

public class B_1_4963_섬의개수 {
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static int h;
    static int w;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }

            int cnt = 0;
            arr = new int[w][h];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }

    public static void dfs(int r, int c) {
        for (int i = 0; i < 8; i++) {
            arr[r][c] = 0;
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < w && nc >= 0 && nc < h && arr[nr][nc] == 1) {
//                r = nr;
//                c = nc;
                dfs(nr, nc);
            }
        }
    }

}
