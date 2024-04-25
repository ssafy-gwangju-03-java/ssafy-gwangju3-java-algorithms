package week_13_구현1.전기철;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B_3_17135 {
    static int n, m, d;
    static int[][] lst;
    static int[] dx = { -1, 0, 1 };
    static int[] dy = { 0, -1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        lst = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                lst[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) { // 3자리 조합 구현
                    int[] archor = new int[3];
                    archor[0] = i;
                    archor[1] = j;
                    archor[2] = k;
                    ans = Math.max(ans, shoot(archor));
                }
            }
        }

        System.out.println(ans);
        sc.close();
    }

    static int shoot(int[] archor) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = lst[i][j];
            }
        }

        int[][] die = new int[n][m];
        int cnt = 0;
        for (int i = n - 1; i > -1; i--) { // 적 죽이는거랑 내려오는거 따로 구현하는게 복잡함 -> 궁수가 한칸씩 올라가는 느낌으로 접근
            List<int[]> now = new ArrayList<>();
            for (int xx : archor) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] { i, xx, 1 }); // 궁수 바로 윗칸 , 거리 1
                while (!q.isEmpty()) {
                    int[] temp = q.poll();
                    int y = temp[0];
                    int x = temp[1];
                    int dis = temp[2];

                    if (arr[y][x] == 1) { // 적 만남 -> 어짜피 탐색 순서가 왼 위 오른쪽이므로 제일 먼저 만나는 타겟이 공격할 타겟
                        now.add(new int[] { y, x });
                        if (die[y][x] == 0) { // 아직 살아있는 적일 경우 공격, cnt+=1
                            die[y][x] = 1;
                            cnt += 1;
                        }
                        break;
                    }

                    if (dis < d) { // 적을 못만난 경우 공격범위 내 탐색
                        for (int j = 0; j < 3; j++) {
                            int nx = x + dx[j];
                            int ny = y + dy[j];
                            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                                q.add(new int[] { ny, nx, dis + 1 });
                            }
                        }
                    }
                }
            }

            for (int[] temp : now) { // 공격한 적 제거
                int y = temp[0];
                int x = temp[1];
                arr[y][x] = 0;
            }
        }
        return cnt;
    }

}