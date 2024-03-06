package java_study.w6;

import java.io.*;
import java.util.*;

public class B_1_3055 {
    static int R, C;
    static int[] S;
    static Queue<int[]> q;
    static Queue<int[]> w;
    static String[][] arr;
    static int[][] D = {{-1,1,0,0},{0,0,-1,1}};
    static int d = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().split("");
        }

        q = new LinkedList<>();
        w = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j].equals("S")) {
                    q.add(new int[]{i, j});
                }
                if (arr[i][j].equals("*")) {
                    w.add(new int[]{i, j});
                }
                if (arr[i][j].equals("D")) {
                    S = new int[]{i, j};
                }
            }
        }

        bfs();

        System.out.println(flag ? d : "KAKTUS");
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            d ++;

            int size = w.size();

            for (int i = 0; i < size; i++) {
                int[] poll = w.poll();
                int r = poll[0], c = poll[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + D[0][d];
                    int nc = c + D[1][d];

                    boolean inRange = (0 <= nr && nr < R && 0 <= nc && nc < C);

                    if (inRange && (arr[nr][nc].equals(".") || arr[nr][nc].equals("S"))) {
                        w.add(new int[]{nr, nc});
                        arr[nr][nc] = "*";
                    }
                }
            }

            size = q.size();

            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + D[0][d];
                    int nc = c + D[1][d];

                    boolean inRange = (0 <= nr && nr < R && 0 <= nc && nc < C);

                    if (inRange) {
                        if (arr[nr][nc].equals(".")) {
                            q.add(new int[]{nr, nc});
                            arr[nr][nc] = "S";
                        } else if (arr[nr][nc].equals("D")) {
                            flag = true;
                            return;
                        }
                    }
                }
            }
        }
    }
}
