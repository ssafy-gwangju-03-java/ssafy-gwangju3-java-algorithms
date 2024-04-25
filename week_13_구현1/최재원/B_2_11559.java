package week_13_구현1.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2_11559 {
    static char[][] arr;
    static int N, M;

    static boolean[][] visited;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static boolean boom = true;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_13_구현1/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 12;
        M = 6;

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int answer = 0;


        while (true) {
            visited = new boolean[N][M];
            boom = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != '.' && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (boom) {
                answer += 1;
            }else {
                break;
            }
            fall();
        }


        System.out.println(answer);
        br.close();
    }

    static void fall() {
        for (int i = 0; i < M; i++) {
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < N; j++) {
                if (arr[j][i] != '.') {
                    stack.add(arr[j][i]);
                    arr[j][i] = '.';
                }
            }

            int size = stack.size();

            for (int j = N - 1; j > N - size - 1; j--) {
                arr[j][i] = stack.pop();
            }
        }

        visited = new boolean[N][M];
    }

    static void bfs(int i, int j) {
        char color = arr[i][j];

        visited[i][j] = true;

        List<int[]> recorder = new ArrayList<>();
        recorder.add(new int[]{i, j});

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});


        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int r = loc[0];
            int c = loc[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && arr[nr][nc] == color) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    recorder.add(new int[]{nr, nc});
                }
            }
        }

        if (recorder.size() >= 4) {
            for (int[] loc : recorder) {
                arr[loc[0]][loc[1]] = '.';
                boom = true;
            }
        }
    }
}
