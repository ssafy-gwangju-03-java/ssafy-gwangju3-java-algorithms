import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_3_2667 {
    static ArrayList<Integer> danji = new ArrayList<>();
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] visited = new int[N][N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    danji.add(0);
                    dfs(i, j, visited, idx);
                    idx += 1;
                }
            }
        }

        Collections.sort(danji);

        System.out.println(danji.size());
        for (int i = 0; i < danji.size(); i++) {
            System.out.println(danji.get(i));
        }
    }

    private static void dfs(int r, int c, int[][] visited, int idx) {
        visited[r][c] = 1;
        danji.set(idx, danji.get(idx) + 1);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < N);

            if (inRange && visited[nr][nc] == 0 && arr[nr][nc] == 1) {
                dfs(nr, nc, visited, idx);
            }
        }
    }
}
