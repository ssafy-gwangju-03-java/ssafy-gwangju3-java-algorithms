package week_13_구현1.최재원;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1_14503 {
    static int N, M;
    static int[][] arr;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_13_구현1/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int currentDirection = 0;

        if (d == 0) {
            currentDirection = 0;
        } else if (d == 1) {
            currentDirection = 3;
        } else if (d == 2) {
            currentDirection = 2;
        } else {
            currentDirection = 1;
        }

        int answer = clean(r, c, currentDirection);

        System.out.println(answer);
        br.close();
    }

    static int clean(int r, int c, int currentDirection) {
        int answer = 0;

        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우 청소
            if (arr[r][c] == 0) {
                arr[r][c] = 2;
                answer += 1;
            }

            // 주변 4칸중 청소되지 않은 빈 칸이 있는 경우
            if (findUncleanedArea(r, c)) {
                // 반시계 방향 회전
                currentDirection = (currentDirection + 1) % 4;

                int nr = r + dr[currentDirection];
                int nc = c + dc[currentDirection];

                if (inRange(nr, nc) && arr[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
            // 주변 4칸중 청소되지 않은 빈 칸이 없는 경우
            } else {
                int reverseDirection = (currentDirection + 2) % 4;
                int nr = r + dr[reverseDirection];
                int nc = c + dc[reverseDirection];

                if (inRange(nr, nc) && arr[nr][nc] != 1) {
                    r = nr;
                    c = nc;
                } else {
                    break;
                }
            }
        }

        return answer;
    }

    static boolean findUncleanedArea(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (inRange(nr, nc)) {
                if (arr[nr][nc] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
