package week_13_구현1.전기철;

import java.util.Arrays;
import java.util.Scanner;

public class B_1_14503 {
    static int d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        d = sc.nextInt();
        sc.nextLine();
        int[][] lst = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                lst[i][j] = Integer.parseInt(s[j]);
            }
        }
        // 북 동 남 서
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        int cnt = 2; // 벽이 1이므로 2부터 시작

        while (true) {
            int chk = 0; // 4방향 탐색 확인용 변수
            if (lst[y][x] == 0) {
                lst[y][x] = cnt;
                cnt += 1;
            }

            for (int i = 0; i < 4; i++) { // 4방향 탐색 후 직진
                turn(); // 회전
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (lst[ny][nx] == 0) { // 청소할 곳 찾음
                        x = nx;
                        y = ny; // 이동
                        chk = 1; // 청소할 곳 찾음
                        break; // 방향탐색 중지
                    }
                }
            }

            if (chk == 0) { // 4방향 돌았는데 청소할 곳이 없음 -> 후진
                int nx = x - dx[d];
                int ny = y - dy[d]; // 후진
                if (0 <= nx && nx < m && 0 <= ny && ny < n) { // 영역 내 이동
                    if (lst[ny][nx] == 1) { // 벽이라 후진을 못함
                        break;
                    } else {
                        x = nx;
                        y = ny;
                    }
                } else { // 영역 넘어감
                    break;
                }
            }
        }
        // for(int i=0;i<n;i++){
        // System.out.println(Arrays.toString(lst[i]));
        // }

        System.out.println(cnt - 2); // 출력
        sc.close();
    }

    static void turn() {
        if (d == 0) {
            d = 3;
        } else {
            d -= 1;
        }
    }
}