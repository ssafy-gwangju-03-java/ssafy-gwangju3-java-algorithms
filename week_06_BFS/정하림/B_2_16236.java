package java_study.w6;

import java.io.*;
import java.util.*;

public class B_2_16236 {
    static int N;
    static int[][] arr;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    ans = move(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    // 우선순위 큐 모르겠다..
    private static int move(int i, int j) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int[][] v = new int[N][N];
        pq.add(new int[]{i, j});
        v[i][j] = 1;

        int ans = 0;

        int bs_size = 2;
        int eat_cnt = 0;

        while (!pq.isEmpty()) {
            int size = pq.size();

            Queue<int[]> qq = new ArrayDeque<>();

            for (int s = 0; s < size; s++) {
                int[] poll = pq.poll();
                int r = poll[0];
                int c = poll[1];

                // 방문장소에 물고기가 있고 내 사이즈보다 작으면
                if (arr[r][c] < bs_size && arr[r][c] != 0) {
                    // 먹기
                    eat_cnt += 1;
                    arr[r][c] = 0;

                    // 사이즈만큼 먹었으면 크기 증가
                    if (eat_cnt == bs_size) {
                        bs_size += 1;
                        eat_cnt = 0;
                    }

                    // 이동거리저장
                    ans += v[r][c] - 1;

                    // 먹은 자리에서부터 다시 반복
                    pq.clear();
                    qq.clear();
                    pq.add(new int[]{r, c});
                    v = new int[N][N];
                    v[r][c] = 1;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    boolean inRange = (0 <= nr && nr < N && 0 <= nc && nc < N);

                    if (inRange) {
                        if (arr[nr][nc] <= bs_size && v[nr][nc] == 0) {
                            v[nr][nc] = v[r][c] + 1;
                            qq.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            pq.addAll(qq);
        }

        return ans;
    }
}