package week_05_DFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_3_2667 {
    static int N;
    static int[][] town;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int houses = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        town = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                town[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        int cnt = 0;
        ArrayList<Integer> houseNum = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (town[i][j] == 1) {
                    houses = 0;
                    dfs(i, j);
                    cnt++;
                    houseNum.add(houses);
                }
            }
        }

        Collections.sort(houseNum);

        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(houseNum.get(i));
        }
    }

    static void dfs(int r, int c) {
        int curr = town[r][c];
        town[r][c] = 2;
        houses++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < N);
            if (inRange && town[nr][nc] == curr) dfs(nr, nc);
        }
    }
}


