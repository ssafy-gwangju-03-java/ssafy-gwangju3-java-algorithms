package week_06_BFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S_5_5653 {
    static int N, M, K;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int[][] grid;
    static PriorityQueue<int[]> q;
    static int sec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] temp = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            K = Integer.parseInt(temp[2]);

            grid = new int[600+N][600+M];

            int sizeR = 600+N;
            int sizeC = 600+M;

            for (int i = 300; i < 300+N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 300; j < 300+M; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 우선순위 큐 사용
            // 서로 다른 생명력 수치를 가진 세포끼리 경합하여 번식하는 경우 생명력 수치가 높은 줄기세포가 해당 셀을 차지해야 함
            // 따라서 bfs 차수마다 큐를 자동으로 정렬하여 생명력 수치가 높은 세포를 먼저 번식시키는 것이 필요함
            // compare 기준은 세포 정보 배열의 3번째 값, 즉 생명력 수치
            q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[3], o1[3]));

            for (int i = 0; i < sizeR; i++) {
                for (int j = 0; j < sizeC; j++) {
                    if (grid[i][j] > 0) {
                        // 행, 열, 현재 상태(줄기세포가 살아있는 시간), 원래의 상태(생명력 수치)
                        // 줄기세포는 (생명력 수치 * 2) 시간 동안 살아있음 == (비활성 상태 X시간 + 활성 상태 X시간)
                        q.add(new int[]{i, j, grid[i][j]*2, grid[i][j]});
                    }
                }
            }

            sec = 0;

            while (sec < K) {
                bfs();
                sec++;
            }

            System.out.printf("#%d %d\n", t, q.size());
        }
    }

    static void bfs() {
        // bfs를 실행하는 도중에 우선순위 큐에 새로운 좌표값을 넣게되면 넣는 즉시 정렬이 되면서 bfs가 의도한대로 움직이지 않는다
        // 즉, 새로 들어온 다음 차수에 탐색할 좌표값과 해당 차수에 탐색해야 할 좌표값들이 섞이면서
        // 해당 차수의 좌표값은 뒤로 밀리고, 다음 차수의 좌표값을 해당 차수에 탐색하는 불상사가 발생한다
        // 따라서 다음 차수에 탐색할 좌표값들은 temp 배열에 저장해두고 해당 차수 탐색이 끝난 후 한꺼번에 큐에 저장한다
        ArrayList<int[]> temp = new ArrayList<>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];
            int currStatus = cell[2];   // 줄기세포의 현재 생명력
            int cellData = cell[3];     // 줄기세포의 생명력 수치 X

            // 만약 X시간이 아직 도달하지 않았다면 생명력을 1 차감한 후 다시 Enqueue
            if (currStatus > cellData) {
                cell[2] -= 1;
                temp.add(cell);
            }
            // X시간에 도달했다면 번식
            else if (currStatus == cellData) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = cellData;                                    // 주변 좌표에 번식 완료
                        temp.add(new int[]{nr, nc, cellData * 2, cellData});        // 새로운 세포를 큐에 저장
                    }
                }
                // 번식 후 생명력이 소진되지 않았다면 아직 활성 상태이므로 생명력 1 차감 후 다시 Enqueue
                // 2 이상의 생명력 수치를 가진 세포들은 번식 후에도 활성화 상태로 살아 있지만
                // 생명력 수치가 1인 세포는 생명력이 0일 때 번식하기 때문에 해당 조건이 반드시 필요
                cell[2] -= 1;
                if (cell[2] > 0) {
                    temp.add(cell);
                }
            }
            // 번식 후 활성화 상태인 세포들은 생명력이 0으로 떨어질 때까지 수명 깎은 후 Enqueue 반복
            // 이들 또한 살아있는 세포 집계에 포함해야 하기 때문
            else {
                cell[2] -= 1;
                if (cell[2] > 0) {
                    temp.add(cell);
                }
            }
        }

        // 해당 차수가 끝난 후에는 temp안의 세포 정보들을 우선순위 큐에 다시 저장
        q.addAll(temp);
    }
}
