package week_06_BFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1_3055 {
    static int R;
    static int C;
    static char[][] map;
    static Queue<int[]> water;
    static Queue<int[]> beaver;
    static int[][] visited;
    static int[] destination;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1,};
    static int arrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        R = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
        map = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        water = new LinkedList<>();
        beaver = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                } else if (map[i][j] == 'S') {
                    beaver.add(new int[]{i, j});
                    visited[i][j] = 1;
                } else if (map[i][j] == 'D') {
                    destination = new int[]{i, j};
                }
            }
        }

        bfs();
        arrived = visited[destination[0]][destination[1]] - 1;

        if (arrived == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(arrived);
        }
    }

    static void bfs() {
        while (true) {
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                int[] currWater = water.poll();
                int r = currWater[0];
                int c = currWater[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    boolean inRange = (0 <= nr && nr < R && 0 <= nc && nc < C);
                    if (inRange && map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                        water.add(new int[]{nr, nc});
                    }
                }
            }

            int beaverSize = beaver.size();
            for (int i = 0; i < beaverSize; i++) {
                int[] currBeaver = beaver.poll();
                int r = currBeaver[0];
                int c = currBeaver[1];
                if (r == destination[0] && c == destination[1]) {
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    boolean inRange = (0 <= nr && nr < R && 0 <= nc && nc < C);
                    if (inRange && (map[nr][nc] == '.' || map[nr][nc] == 'D') && visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[r][c] + 1;
                        beaver.add(new int[]{nr, nc});
                    }
                }
            }

            if (beaver.isEmpty()) {
                return;
            }
        }
    }
}
