import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class B_1_2573 {
    static int N, M;
    static int[][] arr;
    static List<int[]> icebergs = new ArrayList<>();;
    static int year = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        year = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // icebergs ; 빙산 정보 {높이 , r, c}
                if (arr[i][j] != 0) icebergs.add(new int[]{arr[i][j], i, j});
            }
        }
        while (true) {
            // 빙산 녹임
            year++;
            melt();
//            debug();

            // 방산 덩어리 개수
            int cnt = countGroup();

            if (cnt >= 2) {
                System.out.println(year);
                break;
            }

            // 다 녹음
            if (icebergs.isEmpty()) {
                System.out.println(0);
                break;
            }

        }

    }
    private static void melt() {
        // 인접 바다 개수 방해 안받기 위해서 임시로 담아둠
        List<int[]> tmp = new ArrayList<>();
        for (int[] ice : icebergs) {
            int h = ice[0], r = ice[1], c = ice[2];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (arr[nr][nc] == 0) h--;
            }
                               // == 0 으로 잡아두는 바람에
            tmp.add(new int[]{Math.max(h,0), r, c});
        }
        // 녹은 후 정보 반영
        icebergs.clear();
        for (int[] ice : tmp) {
            int h = ice[0], r = ice[1], c = ice[2];
            arr[r][c] = h;
            if (h !=0) icebergs.add(new int[]{h, r,c});
        }
    }

    private static int countGroup() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for (int[] ice : icebergs) {
            int r = ice[1], c = ice[2];
            if (visited[r][c]) continue;
            dfs(r, c, visited);
            cnt++;
        }
        return cnt;
    }
    private static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (arr[nr][nc] !=0 && !visited[nr][nc]) {
                dfs(nr, nc, visited);
            }
        }
    }


}
