package week_06_BFS.김가람;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_3_14502 {
    static int N;
    static int M;
    static int maxSafety;
    static int[] used;
    static int[][] map;
    static Queue<int[]> q;
    static ArrayList<int[]> virusOrigin;
    static ArrayList<int[]> safeZone;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new int[N][M];

        q = new LinkedList<>();
        safeZone = new ArrayList<>();
        virusOrigin = new ArrayList<>();

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    // 안전지대에서 3개의 좌표를 뽑아 조합 생성 예정, 모든 0의 좌표를 safeZone에 저장
                    safeZone.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    // bfs를 여러번 실행해야 하기 때문에 큐와 바이러스의 원래 위치를 따로 저장
                    q.add(new int[]{i, j});
                    virusOrigin.add(new int[]{i, j});
                }
            }
        }


        used = new int[safeZone.size()];    // used는 조합 생성 함수 wallMaker를 돌리기 위한 방문 체크 배열
        maxSafety = 0;                      // 0 갯수의 최댓값을 저장할 변수
        wallMaker(0, 0);
        System.out.println(maxSafety);
    }

    static void wallMaker(int lev, int start) {
        // 3개의 벽이 완성되면 bfs를 실행하여 안전지역의 최댓값을 산출
        if (lev == 3) {
            bfs();
            return;
        }

        // 0의 좌표값을 저장한 ArrayList인 safeZone에서 3개의 좌표를 순서 상관없이 뽑아(조합) 벽 생성
        for (int i = start; i < safeZone.size(); i++) {
            if (used[i] == 0) {
                int[] loc = safeZone.get(i);
                int r = loc[0];
                int c = loc[1];

                map[r][c] = 1;
                used[i] = 1;
                wallMaker(lev + 1, i + 1);
                map[r][c] = 0;
                used[i] = 0;
            }
        }
    }

    private static void bfs() {
        // 원상복구용 스택
        Stack<int[]> changed = new Stack<>();

        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] loc = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = loc[0] + dr[d];
                    int nc = loc[1] + dc[d];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
                        map[nr][nc] = 2;                    // 전염된 곳은 2로 표시
                        q.add(new int[]{nr, nc});           // bfs 큐에 좌표값 저장
                        changed.add(new int[]{nr, nc});     // 원상복구용 스택에 좌표값 저장
                    }
                }
            }

            // 전염 완료, 더 이상 전염시킬 곳이 남아있지 않을 때 == 큐에 새로운 좌표값이 들어오지 않았을 때
            if (q.isEmpty()) {

                // 맵에서 0으로 남아있는 안전지역의 갯수를 센 후 최댓값과 비교
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 0) {
                            cnt++;
                        }
                    }
                }
                maxSafety = Math.max(maxSafety, cnt);

                // 다음에 실행될 bfs를 위해 2로 오염된 지도를 원상복구
                // 현재 실행했던 bfs가 전염시킨 모든 좌표값이 저장된 스택 changed를 사용
                while (!changed.isEmpty()) {
                    int[] loc = changed.pop();
                    map[loc[0]][loc[1]] = 0;
                }

                // 다음에 실행될 bfs를 위해 바이러스의 원래 위치를 저장한 virusOrigin 배열을 불러와 큐를 원상복구
                q.addAll(virusOrigin);

                return;
            }
        }
    }
}
