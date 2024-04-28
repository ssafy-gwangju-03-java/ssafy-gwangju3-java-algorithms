package week_13_구현1.전기철;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B_2_11559 {
    static String[][] lst = new String[12][6];
    static int[][] vis;
    static int chk;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < 6; j++) {
                lst[i][j] = s[j];
            }
        }

        int cnt = 0; // 연쇄 카운트
        while (true) {
            chk = 0; // 폭발 일어났는지 확인
            vis = new int[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (lst[i][j].equals(".")) { // 빈 공간이면 패스
                        continue;
                    }
                    vis[i][j] = 1; // 만났을때 방문처리 후 bfs
                    bfs(i, j, lst[i][j]);
                }
            }

            drop();

            if (chk == 1) { // 폭발이 일어난 적이 있으면 cnt+=1 후 한번 더 탐색
                cnt += 1;
            } else {
                break;
            }
        }

        System.out.println(cnt);
        sc.close();
    }

    static void bfs(int y, int x, String color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { y, x });
        List<int[]> boom = new LinkedList<>();
        boom.add(new int[] { y, x });
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = c + dx[i];
                int ny = r + dy[i];
                if (0 <= nx && nx < 6 && 0 <= ny && ny < 12 && vis[ny][nx] == 0) {
                    if (lst[ny][nx].equals(color)) { // 처음 탐색한 값과 같은 색이면 폭발
                        vis[ny][nx] = 1;
                        q.add(new int[] { ny, nx });
                        boom.add(new int[] { ny, nx });
                    }
                }
            }
        }
        if (boom.size() >= 4) { // 4개 이상이 붙어있는 경우
            for (int[] now : boom) {
                int yy = now[0];
                int xx = now[1];
                lst[yy][xx] = ".";

            }
            chk = 1; // 폭발 확인
        }
    }

    static void drop() {
        for (int j = 0; j < 6; j++) {
            int line = 11;
            for (int i = 11; i >= 0; i--) { //세로줄 하나씩 확인
                if (!lst[i][j].equals(".")) {
                    String x = lst[i][j];
                    lst[i][j] = ".";
                    lst[line][j] = x;
                    line -= 1;
                }
            }
        }
    }
}
