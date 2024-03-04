import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_4_2206 {
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int N;
    static int M;
    static int cnt;
    static Queue<int[]> q;
    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        // visited를 두 장으로 설정
        // visited[0][i][j] == 벽을 깨지 않았을 때의 방문체크
        // visited[1][i][j] == 벽을 깬 후의 방문체크
        // 벽을 깼을 때와 깨지 않았을 때의 경로와 속도가 달라지기 때문에
        // 방문체크 배열을 따로 써주지 않으면 bfs가 정상적으로 작동하지 않는다
        // 의문: 깰수 있는 벽이 여러개이고, 각각의 벽을 부순 지도는 서로 다른 지도인데 같은 방문체크 배열 visited[1][i][j]를 함께 공유해도 되는 것일까?
        // 답: 만약 서로 다른 벽을 깬 bfs 경로끼리 겹치더라도 어차피 bfs의 본질은 최단거리를 탐색하는 것이기 때문에 조금 늦게 충돌 지점에 도착한 경로는 도태되는것이 맞다
        map = new int[N][M];
        visited = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s[j]));
            }
        }

        // q <- int[]{r, c, didBreak}
        q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});

        visited[0][0][0] = 1;
        cnt = 0;
        bfs();
        System.out.println(cnt);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] loc = q.poll();
                int r = loc[0];
                int c = loc[1];
                int didBreak = loc[2];

                if (r == N-1 && c == M-1) return;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < M);

                    // 만약 이미 벽을 깬 상태라면? 더이상 벽을 깰 수 없으므로 0만 bfs큐에 저장, 방문 체크는 두번째 장
                    if (didBreak == 1) {
                        if (inRange && map[nr][nc] == 0 && visited[1][nr][nc] == 0) {
                            visited[1][nr][nc] = 1;
                            q.add(new int[]{nr, nc, 1});
                        }
                        // 아직 벽을 깨지 않았다면?
                    } else {
                        // 0을 만나면 그대로 bfs, 방문 체크는 첫번째 장
                        if (inRange && map[nr][nc] == 0 && visited[0][nr][nc] == 0) {
                            visited[0][nr][nc] = 1;
                            q.add(new int[]{nr, nc, 0});
                            // 벽을 만나면 부순다 == didBreak를 1로 변경, 방문 체크는 두번째 장
                        } else if (inRange && map[nr][nc] == 1 && visited[1][nr][nc] == 0) {
                            visited[1][nr][nc] = 1;
                            q.add(new int[]{nr, nc, 1});
                        }
                    }
                }
            }
        }

        // 중간에 break 없이 끝났다면 == 도착점에 도달하지 못했다면
        cnt = -1;
    }
}
