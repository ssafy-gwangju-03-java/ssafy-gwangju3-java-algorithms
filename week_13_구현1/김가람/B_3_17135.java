package week_13_구현1.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_3_17135 {
    static int N;
    static int M;
    static int D;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        D = Integer.parseInt(info[2]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        ans = 0;
        comb(0, 0, new int[3]);     // M개의 칸 중에서 궁수 3명의 위치를 조합으로 선정해 배치한다
        System.out.println(ans);
    }

    static void comb(int lev, int start, int[] selected) {
        if (lev == 3) {
            // 배열 복제
            int[][] newMap = map.clone();
            for (int i = 0; i < N; i++) {
                newMap[i] = map[i].clone();
            }

            // 3명의 궁수를 모두 배치 완료하면 shot 함수 구동
            // shot 함수는 배치된 궁수 3명이 제거한 적의 수를 반환
            ans = Math.max(ans, shot(selected, newMap));
            return;
        }

        for (int i = start; i < M; i++) {
            selected[lev] = i;
            comb(lev + 1, i + 1, selected);
        }
    }

    static int shot(int[] selected, int[][] newMap) {
        int dead = 0;

        // 1루프 == 1턴
        while (true) {

            // 해당 턴에서 사정거리 내에 있는 적을 넣어줄 ArrayList
            // 각 궁수로부터 거리가 가장 가깝고 가장 왼쪽에 있는 적의 좌표를 넣어주기
            // 이 좌표는 중복될 수 있음 ("""같은 적이 여러 궁수에게 공격당할 수 있다""")
            ArrayList<int[]> toKill = new ArrayList<>();

            // 3명의 궁수가 적을 쏜다
            for (int i = 0; i < 3; i++) {
                int c = selected[i];

                // 해당 궁수의 사정거리에 있는 적들의 좌표를 모두 넣어 줄 우선순위 큐
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        int o1Dist = distance(o1, c);   // |r1-r2| + |c1-c2|를 계산해주는 함수
                        int o2Dist = distance(o2, c);
                        if (o1Dist == o2Dist) {
                            // 거리가 같다면 열(column)의 값으로 정렬
                            return o1[1] - o2[1];
                        } else {
                            // 거리가 가까운 순서로 정렬
                            return o1Dist - o2Dist;
                        }
                    }
                });

                // 사정거리 내에서 적이 있는지 탐지
                // 적이 있다면 우선순위 큐에 넣어주기
                int nr = N - D;
                int range = 0;
                while (nr < N) {
                    for (int j = -range; j <= range; j++) {
                        int nc = c + j;
                        if (0 <= nr && nr < N && 0 <= nc && nc < M && newMap[nr][nc] == 1) {
                            pq.add(new int[]{nr, nc});
                        }
                    }
                    nr++;
                    range++;
                }

                // 우선순위 큐에서 가장 앞에 있는 적을 toKill에 넣어준다
                if (!pq.isEmpty()) {
                    toKill.add(pq.poll());
                }
            }

            // 3명의 궁수가 조준해놓은 적들을 한꺼번에 쏘며 dead를 1씩 증가
            // 중복이면 continue
            for (int[] loc : toKill) {
                if (newMap[loc[0]][loc[1]] == 1) {
                    dead++;
                    newMap[loc[0]][loc[1]] = 0;
                }
            }

            // 적이 더이상 존재하지 않으면 return
            if (!moveForward(newMap)) {
                return dead;
            }
        }
    }

    // 적들이 전진한다
    // 전진과 동시에 적의 유무를 판별하여 boolean값을 반환한다
    static boolean moveForward(int[][] newMap) {
        boolean hasEnemy = false;
        for (int i = N - 1; i >= 1; i--) {
            newMap[i] = newMap[i-1].clone();
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 1) {
                    hasEnemy = true;
                }
            }
        }
        newMap[0] = new int[M];
        return hasEnemy;
    }

    // |r1-r2| + |c1-c2|
    static int distance(int[] loc, int c) {
        return Math.abs(loc[0] - N) + Math.abs(loc[1] - c);
    }
}


