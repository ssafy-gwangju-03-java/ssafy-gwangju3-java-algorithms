import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1_3055 {
    static int R, C;
    static int[] S;
    static Queue<int[]> hedgehog;
    static Queue<int[]> flood;
    static char[][] arr;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int distance = 0;
    static boolean arrival = false;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        hedgehog = new LinkedList<>();
        flood = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'S') {
                    hedgehog.add(new int[]{i, j});
                }
                if (arr[i][j] == '*') {
                    flood.add(new int[]{i, j});
                }
                if (arr[i][j] == 'D') {
                    S = new int[]{i, j};
                }
            }
        }

        bfs();

        System.out.println(arrival ? distance : "KAKTUS");
        br.close();
    }

    private static void bfs() {
        while (!hedgehog.isEmpty()) {
            distance += 1;

            int size = flood.size();

            for (int i = 0; i < size; i++) {
                int[] poll = flood.poll();
                int r = poll[0];
                int c = poll[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    boolean inRange = (0 <= nr && nr < R && 0 <= nc && nc < C);

                    if (inRange && (arr[nr][nc] == '.' || arr[nr][nc] == 'S')) {
                        flood.add(new int[]{nr, nc});
                        arr[nr][nc] = '*';
                    }
                }
            }

            size = hedgehog.size();

            for (int i = 0; i < size; i++) {
                int[] poll = hedgehog.poll();
                int r = poll[0];
                int c = poll[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    boolean inRange = (0 <= nr && nr < R && 0 <= nc && nc < C);

                    if (inRange) {
                        if (arr[nr][nc] == '.') {
                            hedgehog.add(new int[]{nr, nc});
                            arr[nr][nc] = 'S';
                        } else if (arr[nr][nc] == 'D') {
                            arrival = true;
                            return;
                        }
                    }
                }
            }
        }
    }
}
