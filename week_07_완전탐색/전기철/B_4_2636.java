import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B_4_2636 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(int[][] lst, int n, int m) {
        int chk = 0;
        int[][] vis = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        int[][] ans = new int[n * m][2];
        int index = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && vis[ny][nx] == 0) {
                    vis[ny][nx] = 1;
                    if (lst[ny][nx] == 0) {
                        q.add(new int[]{ny, nx});
                    } else {
                        ans[index][0] = ny;
                        ans[index][1] = nx;
                        index+=1;
                        chk+=1;
                    }
                }
            }
        }
        for (int i = 0; i < index; i++) {
            lst[ans[i][0]][ans[i][1]] = 0;
        }
        return chk;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] lst = new int[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lst[i][j] = sc.nextInt();
                result += lst[i][j];
            }
        }
        int time = 0;
        while (true) {
            time+=1;
            int cnt = bfs(lst, n, m);
            result -= cnt;
            if (result == 0) {
                System.out.println(time);
                System.out.println(cnt);
                break;
            }
        }
        sc.close();
    }
}
