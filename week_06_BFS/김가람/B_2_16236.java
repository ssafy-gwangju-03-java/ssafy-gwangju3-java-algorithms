package week_06_BFS.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2_16236 {
    static int N;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int babySize;

    static int eaten;
    static int totalMove;
    static Queue<int[]> q;
    static PriorityQueue<int[]> feed;
    static int[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        // bfs 이동 시 쓰는 일반 큐
        q = new LinkedList<>();

        // 먹이를 발견했을 때 먹이의 위치를 가까운 순으로 정렬해 줄 우선 순위 큐
        feed = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] != o2[0]? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] == 9) {
                    // 상어의 위치를 알아낸 후에는 9를 지우고 길을 비워준다
                    map[i][j] = 0;
                    visited[i][j] = 1;
                    q.add(new int[]{i, j});
                }
            }
        }

        babySize = 2;
        eaten = 0;
        totalMove = 0;

        bfs();
        System.out.println(totalMove);
    }

    static void bfs() {
        while (!q.isEmpty()){
            int size = q.size();
            int currDistance = 0;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                currDistance = visited[r][c];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if ((0 <= nr && nr < N && 0 <= nc && nc < N) && visited[nr][nc] == 0) {
                        if (map[nr][nc] == 0 || map[nr][nc] == babySize) {
                            // 거리는 visited 배열로 측정
                            visited[nr][nc] = visited[r][c] + 1;
                            q.add(new int[]{nr, nc});
                        } else if (map[nr][nc] < babySize) {
                            // 현재의 반경에서 먹이를 발견하면 일단 우선순위 큐에 집어넣는다
                            feed.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            // 같은 거리에 있는 칸들을 모두 탐색한 후에, 발견한 먹이가 있다면 먹는 작업을 시작한다
            if (!feed.isEmpty()) {
                eaten++;
                totalMove += currDistance;

                // feed는 정렬되어 있는 우선순위 큐, 맨 첫번째의 값이 바로 가장 가까운 먹이가 된다
                int[] closest = feed.poll();
                int cr = closest[0];
                int cc = closest[1];

                // 먹이를 먹은 후에는 지도에서 먹이를 삭제해주고 visited를 초기화해준다
                visited = new int[N][N];
                visited[cr][cc] = 1;
                map[cr][cc] = 0;

                if (eaten == babySize) {
                    babySize++;
                    eaten = 0;
                }

                // 현재 위치를 다시 기준으로 설정하여 다시 bfs를 시작할 준비를 한다 (다른 먹이 찾으러 가기)
                feed.clear();
                q.clear();
                q.add(new int[]{cr, cc});
            }
        }
    }
}