import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_1388 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] visited;
    static char[][] arr;
    static int count = 0;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_05_DFS/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    count += 1;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int r, int c) {
        char current_floor = arr[r][c];
        visited[r][c] = 1;
        int idx = 0;

        if (current_floor == '-') {
            idx = 2;
        }

        for (int d = idx; d < idx + 2; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            boolean inRange = 0 <= nr && nr < N && 0 <= nc && nc < M;

            if (inRange && visited[nr][nc] == 0 && arr[nr][nc] == current_floor) {
                dfs(nr, nc);
            }
        }
    }
}
