package java_study.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_4963 {
    static int[][] map;
    static int[][] visited;
    static int[][] d = {{-1,1,0,0,-1,-1,1,1},{0,0,-1,1,-1,1,-1,1}};
    static int w, h;
    static int cnt;
    public static void land(int r, int c) {
        if (map[r][c] == 1 && visited[r][c] ==0) {
            cnt++;
        }
        visited[r][c] = 1;
        for (int i = 0; i < 8; i++) {
            int nr = r + d[0][i], nc = c + d[1][i];
            if (0 <= nr && nr < h && 0 <= nc && nc < w && visited[nr][nc] == 0) {
                if (map[r][c] == 1 && map[nr][nc] == 1) {
                    visited[nr][nc] = 1;
                    land(nr, nc);
                }
            }
        }
    }
    public static int island() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    land(i,j);

                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st= new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //종료 조건
            if (w == 0 && h ==0) {
                break;
            }

            map = new int[h][w];
            visited = new int[h][w];
            // 땅 1 바다 0
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cnt = 0;
            System.out.println(island());

        }

    }
}
