import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3_17135 {

    static int N, M, D, enemies, result;
    static int[] selected;
    static int[][] map;
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("week_12_MST/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        selected = new int[3];

        map = new int[N][M];
        enemies = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) enemies++;
            }
        }

        comb(0, 0);

        System.out.println(result);
        br.close();
    }

    public static void comb(int start, int cnt) {
        if (cnt == 3) {
            result = Math.max(result, simulation());
            return;
        }

        for (int i = start; i < M; i++) {
            selected[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    public static int simulation() {
        int enemyNum = enemies;

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++)
            copyMap[i] = Arrays.copyOf(map[i], M);

        int castle = N;
        while (enemyNum > 0 && castle > 0) {
            for (int i = 0; i < 3; i++) {
                enemyNum = bfs(enemyNum, castle, copyMap, i);
            }
            castle -= 1;
        }

        return enemies - enemyNum;
    }

    static int bfs(int enemyNum, int castle, int[][] copyMap, int i) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{castle, selected[i]});
        boolean[][] visited = new boolean[N][M];

        int d = 0;
        while (!q.isEmpty()) {

            if (++d > D) {
                break;
            }

            for (int k = 0, size = q.size(); k < size; k++) {
                int[] node = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nr = node[0] + dr[j];
                    int nc = node[1] + dc[j];

                    if (0 <= nr && nr < castle && 0 <= nc && nc < M && !visited[nr][nc]) {//범위에 속하면
                        if (copyMap[nr][nc] == 1) {
                            enemyNum--;
                            copyMap[nr][nc] = -castle;

                            return enemyNum;
                        } else if (copyMap[nr][nc] == -castle) {
                            return enemyNum;
                        }

                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return enemyNum;
    }
}
