package java_study.w7;

import java.util.*;

public class B_4_2636 {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] pizza;
    static int n, m;
    static int C; // 총 치즈

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        pizza = new int[n][m];
        C = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pizza[i][j] = scan.nextInt();
                if(pizza[i][j] == 1) C++;
            }
        }

        int C_tmp = 0; // 치즈 녹기 전에 개수 저장
        int time = 0;
        while(C != 0) {
            C_tmp = C;
            time++;
            visited = new boolean[n][m];
            bfs();
        }
        System.out.println(time);
        System.out.println(C_tmp);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] poll = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if(pizza[nr][nc] == 0) {
                        q.add(new int[] {nr, nc});
                    } else {
                        C--;
                        pizza[nr][nc] = 0;
                    }
                }
            }
        }
    }
}