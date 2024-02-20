import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_4693 {
    static int[] dr = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dc = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    static int[][] arr;
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_05_DFS/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0) {
            arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] visited = new int[h][w];

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] == 0 && arr[i][j] == 1) {
                        count += 1;
                        dfs(i, j, visited);
                    }
                }
            }

            System.out.println(count);

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
    }

    private static void dfs(int r, int c, int[][] visited) {
        visited[r][c] = 1;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            boolean inRange = (0 <= nr && nr < h && 0 <= nc && nc < w);
            if (inRange && visited[nr][nc] == 0 && arr[nr][nc] == 1) {
                dfs(nr, nc, visited);
            }
        }
    }
}
