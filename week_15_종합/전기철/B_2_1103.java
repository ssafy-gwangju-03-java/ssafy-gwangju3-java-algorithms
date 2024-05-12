package week_15_종합.전기철;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class B_2_1103 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n, m;
    static char[][] lst;
    static int[][] vis;
    static int[][] end;
    static ArrayList<int[]> lineup;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        lst = new char[n][m];
        vis = new int[n][m];
        end = new int[n][m];
        lineup = new ArrayList<>();
        ans = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                lst[i][j] = line.charAt(j);
            }
        }
        dfs(0, 0);

        if (ans == -1) {
            System.out.println(-1);
        } else {
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = 1;
                }
            }
            Stack<int[]> stack = new Stack<>();
            stack.addAll(lineup);
            while (!stack.isEmpty()) {
                int[] point = stack.pop(); // 끝에서부터 다시 돌려보면서 진행
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int num = Character.getNumericValue(lst[y][x]);
                    int nx = x + num * dx[i];
                    int ny = y + num * dy[i];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n && lst[ny][nx] != 'H') {
                        dp[ny][nx] = Math.max(dp[ny][nx], dp[y][x] + 1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            System.out.println(ans);
        }
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int num = Character.getNumericValue(lst[y][x]);
            int nx = x + num * dx[i];
            int ny = y + num * dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n && lst[ny][nx] != 'H') {
                if (vis[ny][nx] == 1) { // 무한루프 가능
                    ans = -1;
                    return;
                }
                if (end[ny][nx] == 1) {
                    continue;
                }
                vis[ny][nx] = 1;
                dfs(nx, ny);
                vis[ny][nx] = 0;
            }
        }
        end[y][x] = 1;
        lineup.add(new int[] { x, y });
    }
}
